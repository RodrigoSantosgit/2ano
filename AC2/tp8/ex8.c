#include <detpic32.h>

void configUART(unsigned int baud, char parity, unsigned int stopbits){

	if(baud < 600 || baud > 115200) baud = 115200; // default baurate value
	
	U1BRG = ((PBCLK + 8 * baud) / (16 * baud)) - 1;
	U1MODEbits.BRGH = 0;
	
	if(parity == 'E')
		U1MODEbits.PDSEL = 01; // 8-BIT EVEN PARITY
	else if(parity == 'O')
		U1MODEbits.PDSEL = 10; // 8-BIT ODD PARITY
	else 
		U1MODEbits.PDSEL = 00; // 8-BIT NO PARITY

	if(stopbits == 2){
		U1MODEbits.STSEL = 1; // 2  STOP BITS
	}
	else
		U1MODEbits.STSEL = 0; // 1 STOP BIT

	U1STAbits.UTXEN = 1;
	
	U1STAbits.URXEN = 1;
	
	U1MODEbits.ON = 1;
}


void delay(int ms){

	while(ms > 0){
		resetCoreTimer();
		while(readCoreTimer() < 20000);
		ms--;
	}
}

void putc(char byte2send){
	
	while(U1STAbits.UTXBF == 1); // while transmiter buffer is full
		
	U1TXREG = byte2send;
	
}

void putstr (char *str){
	
	while(*str != '\0'){
		putc(*str);
		str++;
	}

}

int main(void){
	
	configUART(115200, 'N', 1);
	
	TRISBbits.TRISB6 = 0;  
	
	while(1){
		LATBbits.LATB6 = 1;
		putstr("123456789AB\n");
		LATBbits.LATB6 = 0;
		delay(1000);
	}
	
	return 0;
}
