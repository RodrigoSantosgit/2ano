#include <detpic32.h>

int main(void){
	
	TRISBbits.TRISB4 = 1; // RB4 digital output disconnected
	AD1PCFGbits.PCFG4 = 0; // RB4 configured as analog input (AN4)
	AD1CON1bits.SSRC = 7;
	
	AD1CON1bits.CLRASAM = 1;
	
	AD1CHSbits.CH0SA = 4; // Selects AN4 as input for the A/D converter
	
	AD1CON3bits.SAMC = 16;
	AD1CON2bits.SMPI = 15; // 0 samples will be converted and stored
						  // in buffer locations ADC1BUF0 to ADC1BUF3
	
	AD1CON1bits.ON = 1;
	
	while(1){
		
		AD1CON1bits.ASAM = 1; // Start conversion
		
		while( IFS1bits.AD1IF == 0 ); // Wait while conversion not done
		
		//printInt(ADC1BUF0, 16 | 3 << 16);
		
		int *p = (int *)(&ADC1BUF0);
		int i;
		for( i = 0; i < 16; i++ )
		{
			printInt( p[i*4], 10 | 4 << 16);
			putChar(' ');
		}
		
		putChar('\n');
		
	}
	
	return 0;
	
}
