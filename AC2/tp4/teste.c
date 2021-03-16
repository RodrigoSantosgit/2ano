#include <detpic32.h>

void delay(int ms);

int main(void){
	
	LATDbits.LATD0 = 0;
	
	TRISDbits.TRISD0 = 0;
	
	while(1)
	{
		delay(500);
		LATDbits.LATD0 = !LATDbits.LATD0;
	}
	return 0;
}

void delay(int ms){
	
	while(ms>0)
	{
		resetCoreTimer();
		while(readCoreTimer() < PBCLK/1000);
		ms--;
	}
	
}
