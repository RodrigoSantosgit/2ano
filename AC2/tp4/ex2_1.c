#include <detpic32.h>

void delay(int ms) {

	while(ms > 0) 
	{
		resetCoreTimer();
   		while(readCoreTimer() < PBCLK/1000);
   		ms--;
  	}
}

void send2displays(unsigned char value)
{
	static const char display7Scodes[] = {0x3F, 0x06,0x5b,0x4F, 0x66, 0x6D, 0x7D, 
		0x07, 0x7F, 0x67, 0x77, 0x7C, 0x39, 0x5E, 0x79, 0x71};
		
	// send digit_low (dl) to display_low: dl = value & 0x0F
	int dh = value >> 4;
	int dl = value & 0x0F;
	
	LATDbits.LATD6 = 0;
	LATDbits.LATD5 = 1;
	LATB = (LATB & 0x80FF) | ((int)display7Scodes[dl]<<8);
	delay(10);
	
	LATDbits.LATD6 = 1;
	LATDbits.LATD5 = 0;
	LATB = (LATB & 0x80FF) | ((int)display7Scodes[dh]<<8);
	delay(10);
	
	
}

int main(void)
{
	
	TRISB = TRISB & 0x000F; // Setting RB0 .. RB3 to inputs
	
	TRISB = TRISB & 0x80FF; // Setting RB8 .. RB14 to outputs
	TRISD = TRISD & 0xFF9F; // Setting RD5 and RD6 to outputs
	
	while(1)
	{
		int val = PORTB & 0x000F;
		int value2 = val<<4;
        val = val | value2;
		send2displays(val);
	}
	return 0;
}


