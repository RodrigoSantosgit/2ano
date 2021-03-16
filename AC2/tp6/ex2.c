#include <detpic32.h>

volatile unsigned char Voltage=0;

void delay(int ms) {

	while(ms > 0) 
	{
		resetCoreTimer();
   		while(readCoreTimer() < PBCLK/1000);
   		ms--;
  	}
}

void _int_(27) isr_adc(void){
	
	int Vtotal=0, Vmedio=0;
	int* i = (int *) (&ADC1BUF0);
	int p = 0;	
	for(p=0; p < 8;p++){
		int value = i[p*4];
		Vtotal += value;
	}
		
	Vmedio = Vtotal / 8;
	int V = (Vmedio*33+511)/1023;
	int wholePart = V/10;
	int DecPart = V%10;
	
	Voltage = (wholePart & 0x000F) << 4 | (DecPart & 0x000F);
	
	IFS1bits.AD1IF = 0;
}

void send2displays(unsigned char value)
{
	static const char display7Scodes[] = {0x3F, 0x06,0x5B,0x4F, 0x66, 0x6D, 0x7D, 
		0x07, 0x7F, 0x67, 0x77, 0x7C, 0x39, 0x5E, 0x79, 0x71};
	static char displayFlag = 0;
	// send digit_low (dl) to display_low: dl = value & 0x0F
	
	int dh = value >> 4;
	int dl = value & 0x0F;
	
	if(displayFlag){
		LATDbits.LATD6 = 0;
		LATDbits.LATD5 = 1;
		LATB = (LATB & 0x80FF) | ((int)display7Scodes[dl]<<8);
	}
	
	if(!displayFlag){
		LATDbits.LATD6 = 1;
		LATDbits.LATD5 = 0;
		LATB = (LATB & 0x80FF) | ((int)display7Scodes[dh]<<8);
	}
	
	displayFlag = !displayFlag;
}

int main(void)
{
	// Configure all (digital I/O, analog input, A/D module)
	TRISBbits.TRISB4 = 1; // RB4 digital output disconnected
	
	AD1PCFGbits.PCFG4 = 0; // RB4 configured as analog input (AN4)
	AD1CON1bits.SSRC = 7;
	
	AD1CON1bits.CLRASAM = 1;
	
	AD1CHSbits.CH0SA = 4; // Selects AN4 as input for the A/D converter
	
	AD1CON3bits.SAMC = 16;
	AD1CON2bits.SMPI = 7; // 0 samples will be converted and stored
	AD1CON1bits.ON = 1;	  // in buffer locations ADC1BUF0 to ADC1BUF3
	
	IPC6bits.AD1IP = 2; // A/D priority
	IEC1bits.AD1IE = 1; // enable A/D interrupts
	IFS1bits.AD1IF = 0; // clear A/D interrupt flag
	
	TRISB = TRISB & 0x00FF; // Setting RB8 .. RB14 to outputs
	TRISD = TRISD & 0xFF9F; // Setting RD5 and RD6 to outputs
 
	// Configure interrupt system
	EnableInterrupts(); // Global Interrupt Enable
	// Start A/D conversion
	
	int i = 0;
	while(1) { 
		delay(10);
		if(i++==25){
			AD1CON1bits.ASAM =1;
			i=0;
			// all activity is done by the ISR
		}
		send2displays(Voltage);
	}
	return 0;
}

