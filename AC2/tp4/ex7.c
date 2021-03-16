#include <detpic32.h>

void send2displays(unsigned char value) {
	static const char display7Scodes[] = {0x3F, 0x06, 0x5B, 0x4F, 0x66, 0x6D, 0x7D, 
		0x07, 0x7F, 0x67, 0x77, 0x7C, 0x39, 0x5E, 0x79, 0x71};
	
	static char flag = 0;
	
	if(flag)
	{
		// send digit_low to display_low
		LATDbits.LATD6 = 1;
		LATDbits.LATD5 = 0; // toggle display selection 
		LATB = (LATB & 0x80FF) | (display7Scodes[value >> 4] << 8); // high part (shift)
	}
	else
	{
		// send digit_high to display_high
		LATDbits.LATD6 = 0;
		LATDbits.LATD5 = 1; // toggle display selection 
		LATB = (LATB & 0x80FF) | (display7Scodes[value & 0x0F] << 8); // low part (rem)
	}
	
	flag = !flag;
}

void delay(int ms) {

	while(ms > 0) 
	{
		resetCoreTimer();
   		while(readCoreTimer() < PBCLK/1000);
   		ms--;
  	}
}

unsigned char toBcd(int value)
{
	return (char) ((value / 10) << 4) + (value % 10);
}

int main(void)
{
	// configure RB0 to RB3 as inputs
	TRISB = (TRISB & 0xFFF0) | 0x000F;

	// configure RB8 to RB14 ...
	//  ... and RD5 to RD6 as outputs
	TRISD = TRISD & 0xFF9F;		// configure RD5-RD6 as outputs
	TRISB = TRISB & 0x80FF; 	// configure RB8-RB14 as outputs
	
	// LATD = (LATD & 0xFF9F) | 0x0040; // display high active, low inactive
	int i = 0;
   	int count = 0;

	// Select display low
	while(1) 
	{
    	// read dip-switch
    	//unsigned char val = PORTB & 0x000F;
    	// convert to 7 segments code
    	//unsigned char value = toBcd(val);
    	if((PORTB & 0x000F) == 0){
			if(i++ == 100){
				i=0;
				count++;
			}
			if(count == 100)
				count = 0;
		}
		send2displays(toBcd(count));
		delay(10);
		// send to display
	} 
	return 0;
}
