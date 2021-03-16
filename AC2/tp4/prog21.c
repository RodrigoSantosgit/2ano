#include <detpic32.h>
#include "delay.c"

void send2displays(unsigned char value);

void main (void)
{
    
    TRISB = (TRISB & 0x80F0) | 0x000F;
    TRISD = (TRISD & 0xFF9F);

    while(1)
    {
        int value = PORTB & 0x000F;
        int value2 = value<<4;
        value = value | value2;
        send2displays(value);
    }
}

void send2displays(unsigned char value)
{    static const char display7codes[] = {0x3F, 0x06, 0x5B, 0x4F, 0x66, 0x6D,   0x7D, 0x07, 0x7F, 0x6F, 0x77, 0x7C, 0x39, 0x5E, 0x79, 0x71};
    
    static char displayFlag = 0; 
    unsigned char digit_low = value & 0x0F;
    unsigned char digit_high = value >> 4;   

    if(!displayFlag){
        LATDbits.LATD5 = 1; LATDbits.LATD6 = 0;
 
		LATB = (LATB & 0x80FF) | ((int)display7codes[digit_low] << 8); //   high part (shift)
		
    } else{
		//LATD = LATD ^ 0x0060; // toggle display selection 
        LATDbits.LATD5 = 0; LATDbits.LATD6 = 1;
		LATB = (LATB & 0x80FF) | ((int)display7codes[digit_high] << 8); // low part (rem)
		
    }
    displayFlag= !displayFlag;
}




