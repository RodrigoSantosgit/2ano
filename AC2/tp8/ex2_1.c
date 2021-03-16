#include <detpic32.h>

void configUart(int baudrate, char parity, int stop_bits)
{
	
	U1BRG = ((PBCLK + 8 * baudrate) / (16 * baudrate)) - 1;
	U1MODEbits.BRGH = 0;
	
	if(parity == 'E')
		U1MODEbits.PDSEL = 01;
	else if(parity == 'O')
			U1MODEbits.PDSEL = 10;
		else
			U1MODEbits.PDSEL = 00;
			
	if(stop_bits == 2)
		U1MODEbits.STSEL = 1;
	else
		U1MODEbits.STSEL = 0;
		
	U1STAbits.URXEN = 1;
	U1STAbits.UTXEN = 1;
	
	U1MODEbits.ON = 1;
	
	IPC6bits.U1IP = 2;
	IEC0bits.U1RXIE = 1;
	IFS0bits.U1RXIF = 0;
	
}

void putc(char c){
	
	while(U1STAbits.UTXBF == 1);
	
	U1RXREG = c;
	
}

void _int_(27) isr_adc(void)
{
	int voltage=0;
	int* i = (int *) (&ADC1BUF0);
	int p = 0;	
	for(p=0; p < 4;p++){
		int value = i[p*4];
		Vtotal += value;
	}
		
	Vmedio = Vtotal / 8;
	int V = (Vmedio*33+511)/1023;
	int wholePart = V/10;
	int DecPart = V%10;
	
	Voltage = (wholePart & 0x000F) << 4 | (DecPart & 0x000F);
	
	// Convert voltage amplitude to decimal. Assign it to "value2display"
	// Update variables "voltMin" and "voltMax"
	IFS1bits.AD1IF = 0;
	// Reset AD1IF flag
}
void _int_(12) isr_T3(void)
{
	static int counter = 0;
	// Send "value2display" global variable to displays
	if(++counter == 100)
	{
		counter = 0;
		// send voltage to the serial port UART1
		
	}
	// Clear T3 interrupt flag
}
void _int_(24) isr_uart1(void)
{
	if(U1RXREG == 'L')
	{
	// Send "voltMin" and "voltMax" to the serial port UART1
	}
	// Clear UART1 rx interrupt flag
}

int main(void)
{
	configUart(115200,'N',1); // default "pterm" parameters
								// with RX interrupt enabled
	EnableInterrupts();
	
	AD1PCFGbits.PCFG4 = 0; // RB4 configured as analog input (AN4)
	AD1CON1bits.SSRC = 7;
	
	AD1CON1bits.CLRASAM = 1;
	
	AD1CHSbits.CH0SA = 4; // Selects AN4 as input for the A/D converter
	
	AD1CON3bits.SAMC = 16;
	AD1CON2bits.SMPI = 3; // 0 samples will be converted and stored
						  // in buffer locations ADC1BUF0 to ADC1BUF3
	
	AD1CON1bits.ON = 1;  // AD SEGMENT ON
	
	
	
	while(1);
	
	return 0;
}
