#include <detpic32.h>

volatile int voltage;

void setPWM(unsigned int dutyCycle)
{
	// duty_cycle must be in the range [0, 100]
	OC1RS =50000 * dutyCycle / 100;
	// Evaluate OC1RS as a function of "dutyCycle"
	
}

void configureAll(void){
	
	//////////////////////////////////////////////////
	// CONFIGURE PORTS
	
	voltage = 0;
	
	TRISBbits.TRISB0 = 1; // RB0 digital output disconnected
	TRISBbits.TRISB1 = 1; // RB1 digital output disconnected
	TRISBbits.TRISB4 = 1; // RB4 digital output disconnected
	
	//////////////////////////////////////////////////
	// CONFIGURE TIMER AND DUTYCICLE
	
	T3CONbits.TCKPS = 2; // PRESCALER = 32;
	PR3 = 49999; //   20 000 000 / (freq*PRESCALER) - 1
	TMR3= 0; // RESET TIMER COUNTER
	T3CONbits.TON = 1; // TIMER ON
	
	OC1CONbits.OCM = 6; // FAULT PIN DISABLED
	OC1CONbits.OCTSEL = 1; // SELECT TIMER 3 AS TIME BASE
	OC1RS = 12500;   // (DUTYCYCLE * 1/FREQ)/(PBCLK / PRESCLER)
	OC1CONbits.ON = 1; // ENABLE OC1 MODULE;
	
	//////////////////////////////////////////////////
	// CONFIGURE AD CONVERSION
	
	AD1PCFGbits.PCFG4 = 0; // RB4 configured as analog input (AN4)
	AD1CON1bits.SSRC = 7;
	
	AD1CON1bits.CLRASAM = 1;
	
	AD1CHSbits.CH0SA = 4; // Selects AN4 as input for the A/D converter
	
	AD1CON3bits.SAMC = 16;
	AD1CON2bits.SMPI = 3; // 0 samples will be converted and stored
						  // in buffer locations ADC1BUF0 to ADC1BUF3
	
	AD1CON1bits.ON = 1;  // AD SEGMENT ON
	
}
int main(void)
{
	
	printStr("Rodrigo Santos, nº mec: 89180\n");
	
	int dutyCycle;
	configureAll();
	EnableInterrupts(); // Global Interrupt Enable
	
	while(1)
	{
		// Read RB1, RB0 to the variable "portVal"
		unsigned char portVal = PORTB & 0x0003;
		
		double Vtotal =0;
		int* i = (int *)(&ADC1BUF0);

		AD1CON1bits.ASAM =1; // START CONVERSION
		while(IFS1bits.AD1IF == 0); // WHILE CONVERSION NOT DONE
		
		for(; i<= (int *) (&ADC1BUFF);i+=4){
			Vtotal += *i;
		}
		
		voltage = Vtotal / 4;
		voltage=(voltage*33+511)/1023;
		
		switch(portVal)
		{
			case 0: 
				// Measure input voltage
				// Enable T1 interrupts
				
				setPWM(0); // LED OFF
				break;
			case 1: 
				// Freeze
				// Disable T1 interrupts
				setPWM(100); // LED ON (maximum bright)
				break;
			
			default: 
				// LED brigthness control
				// Enable T1 interrupts
				dutyCycle = voltage * 3;
				setPWM(dutyCycle);
				break;
		}
	}
	return 0;
}



