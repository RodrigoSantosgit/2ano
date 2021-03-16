#include <detpic32.h>

void delay(int ms);
void printChar(char c);

int main(void)
{
	unsigned char segment;
	LATDbits.LATD6 = 1; // display high active
	LATDbits.LATD5 = 0; // display low inactive
	// configure RB8-RB14 as outputs
	// configure RD5-RD6 as outputs
	
	TRISB = (TRISB & 0X00FF);
	TRISD = TRISD & 0xFF9F;
	
	while(1)
	{
		LATDbits.LATD6 = !LATDbits.LATD6; //
		LATDbits.LATD5 = !LATDbits.LATD5; // toggle display selection
		segment = 'a';
		int i;
		for(i=0; i < 7; i++)
		{
			// send "segment" value to display
			printChar(segment);
			// wait 0.5 second
			delay(500);
			segment = segment + 1;
		}
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

void printChar(char c){
	
	if (c == 'a') 
	{
		LATB = (LATB & 0x00FF) | 0x7700;
	}
	else if (c == 'b') 
	{
		LATB = (LATB & 0x00FF) | 0x7C00;
	}
	else if (c == 'c') 
	{
		LATB = (LATB & 0x00FF) | 0x3900;
	}
	else if (c == 'd') 
	{
		LATB = (LATB & 0x00FF) | 0x5E00;
	}
	else if (c == 'e') 
	{
		LATB = (LATB & 0x00FF) | 0x7900;
	}
	else if (c == 'f') 
	{
		LATB = (LATB & 0x00FF) | 0x7100;
	}
	else if (c == 'g') 
	{
		LATB = (LATB & 0x00FF) | 0x6F00;
	}
	else if (c == '.') 
	{
		LATB = (LATB & 0x00FF) | 0x8000;
	}
}
