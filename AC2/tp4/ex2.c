#include <detpic32.h>

void delay(int ms);

int main(void)
{
	LATEbits.LATE0 = 0;
	LATEbits.LATE1 = 0;
	LATEbits.LATE2 = 0;
	LATEbits.LATE3 = 0;	
	
	TRISEbits.TRISE0 = 0;
	TRISEbits.TRISE1 = 0;
	TRISEbits.TRISE2 = 0;
	TRISEbits.TRISE3 = 0;
	
	int i;	
	for(i=0; i< 16; i++){
		delay(250);
		LATE = (LATE & 0xFFF0) | i;	
		
	}	
		
}	

void delay(int ms){
	
	while(ms>0)
	{
		resetCoreTimer();
		while(readCoreTimer() < PBCLK/1000);
		ms--;
	}
	
}
