#include <detpic32.h>

void send2displays(unsigned char value);

void main (void)
{   static const char display7codes[] = {0x3F, 0x06, 0x5B, 0x4F, 0x66, 0x6D,   0x7D, 0x07, 0x7F, 0x6F, 0x77, 0x7C, 0x39, 0x5E, 0x79, 0x71};
    

    TRISB = (TRISB & 0x80FF);
    TRISD = (TRISD & 0xFF9F);

    int count= 0;
    
    while(1)
    {   int i=0;
        do{
        //value = PORTB & 0x000F;
        count = count & 0x00FF;
        delay(10);
        send2displays(count);
        } while(i++<20);
        count++;


    }
}

void send2displays(unsigned char value)
{    static const char display7codes[] = {0x3F, 0x06, 0x5B, 0x4F, 0x66, 0x6D,   0x7D, 0x07, 0x7F, 0x6F, 0x77, 0x7C, 0x39, 0x5E, 0x79, 0x71};
    
    static char displayFlag = 0; 
    unsigned char digit_low = value & 0x0F;
    unsigned char digit_high = value >> 4;  
    
    int low = (int)display7codes[digit_low];
    int high =(int)display7codes[digit_high]; 
    //high = high << 4; 
    
   
    if (!displayFlag){
        LATDbits.LATD5 = 1; LATDbits.LATD6 = 0;
 
		LATB = (LATB & 0x80FF) | (low << 8); //   high part (shift)
		
    } else{ 

		LATDbits.LATD5 = 0; LATDbits.LATD6 = 1;
		LATB = (LATB & 0x80FF) | (high  << 8);      
        
    }
    displayFlag = !displayFlag;
}





