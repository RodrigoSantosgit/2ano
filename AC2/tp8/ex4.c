#include <detpic32.h>

void configUART(unsigned int baud, char parity, unsigned int stopbits){

	if(baud < 600 || baud > 115200) baud = 115200;
	
	U1BRG = ((PBCLK + 8 * baud) / (16 * baud)) - 1;
	U1MODEbits.BRGH = 0;
	
	if(parity == 'E')
		U1MODEbits.PDSEL = 01;
	else if(parity == 'O')
		U1MODEbits.PDSEL = 10;
	else 
		U1MODEbits.PDSEL = 00;

	if(stopbits == 2){
		U1MODEbits.STSEL = 1;
	}
	else
		U1MODEbits.STSEL = 0;

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
	
	while(U1STAbits.UTXBF == 1);
		
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
	
	while(1){
		putstr("Rodrigo\n");
		delay(1000);
	}
	
	return 0;
}
