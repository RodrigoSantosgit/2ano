#include <detpic32.h>

void delay(int ms) {

	while(ms > 0) 
	{
		resetCoreTimer();
   		while(readCoreTimer() < PBCLK/1000);
   		ms--;
  	}
}

int main(void){
	
	TRISBbits.TRISB4 = 1; // RB4 digital output disconnected
	AD1PCFGbits.PCFG4 = 0; // RB4 configured as analog input (AN4)
	AD1CON1bits.SSRC = 7;
	
	AD1CON1bits.CLRASAM = 1;
	
	AD1CHSbits.CH0SA = 4; // Selects AN4 as input for the A/D converter
	
	AD1CON3bits.SAMC = 16;
	AD1CON2bits.SMPI = 3; // 0 samples will be converted and stored
						  // in buffer locations ADC1BUF0 to ADC1BUF3
	
	AD1CON1bits.ON = 1;
	delay(100);
	while(1){
		double Vtotal=0, Vmedio;
		int* i = (int *) (&ADC1BUF0);

		AD1CON1bits.ASAM =1;
		while(IFS1bits.AD1IF == 0);
		
		for(; i<= (int *) (&ADC1BUFF);i+=4){
			Vtotal += *i;
		}
		
		Vmedio = Vtotal / 4;
		int V = (Vmedio*33+511)/1023;
		int wholePart = (V/10);
		int decimalPart = (V%10);
		printInt(wholePart, 10);
		putChar('.');
		printInt(decimalPart, 10);
		printStr(" Volts \n");
	}
	
	return 0;
}


