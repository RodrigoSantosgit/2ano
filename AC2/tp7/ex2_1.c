#include <detpic32.h>

void setPWM(unsigned int dutyCycle)
{
	// duty_cycle must be in the range [0, 100]
	OC1RS =50000 * dutyCycle / 100;
	// Evaluate OC1RS as a function of "dutyCycle"
	
}

int main(void){
	
	// Configure Timer T3 (100 Hz with interrupts disabled)

	T3CONbits.TCKPS = 2; // PRESCALER = 32;
	PR3 = 49999; //   20 000 000 / (freq*PRESCALER) - 1
	TMR3= 0; // RESET TIMER COUNTER
	T3CONbits.TON = 1; // TIMER ON
	
	OC1CONbits.OCM = 6; // FAULT PIN DISABLED
	OC1CONbits.OCTSEL = 1; // SELECT TIMER 3 AS TIME BASE
	OC1RS = 12500;   // (DUTYCYCLE * 1/FREQ)/(PBCLK / PRESCLER)
	OC1CONbits.ON = 1; // ENABLE OC1 MODULE;
	
	unsigned int dutyC[4] = {10, 25, 50, 100};
	
	while(1){
		int i;
		for(i=0; i<5; ++i){
			int j =0;
			while(j < 5000000){
				setPWM(dutyC[i]);
				j++;
			}
			
		}
	}
	return 0;
	
}



