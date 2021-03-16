#include <detpic32.h>

void delay(int ms) {

	while(ms > 0) 
	{
		resetCoreTimer();
   		while(readCoreTimer() < PBCLK/1000);
   		ms--;
  	}
}
// Interrupt Handler
void _int_(27) isr_adc(void){
	
	// Print ADC1BUF0 value
	printInt(ADC1BUF0, 16 | 3<<16);
	
	putChar('\n');
	// Start A/D conversion
	AD1CON1bits.ASAM =1;
	IFS1bits.AD1IF = 0;
	
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
	AD1CON2bits.SMPI = 0; // 1 samples will be converted and stored
	AD1CON1bits.ON = 1;	  // in buffer locations ADC1BUF0 to ADC1BUF3
	
	IPC6bits.AD1IP = 2; // define priority level
	IFS1bits.AD1IF = 0; // clear A/D interrupt flag
	IEC1bits.AD1IE = 1; // enable A/D interrupts
 
	// Configure interrupt system
	EnableInterrupts(); // Global Interrupt Enable
	// Start A/D conversion
	AD1CON1bits.ASAM =1;
	
	while(1) { 
		// all activity is done by the ISR
	}
	return 0;
}
