#include <detpic32.h>

void delay(int ms);
void printChar(char c);

int main(void)
{
	LATB = (LATB & 0x00FF);
	LATD = LATD & 0XFF9F;
	
	LATDbits.LATD5 = 1;
	LATDbits.LATD6 = 1;	
	
	TRISB = (TRISB & 0X00FF);
	TRISD = TRISD & 0xFF9F;
	
	unsigned char c = 0;
	
	while(1)
	{
		c = getChar();
		if((c >= 'a' && c<='g') || c == '.'){
			printChar(c);
		}
		else if ('A' <= c && 'G' >= c){
			printChar(c+32);
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
