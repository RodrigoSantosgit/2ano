#include <detpic32.h>

int baudrate = 115200;

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

int main(void){
	
	U1BRG = ((PBCLK + 8 * baudrate) / (16 * baudrate)) - 1;
	U1MODEbits.BRGH = 0;
	
	U1MODEbits.PDSEL = 00; // 8-data bit no parity
	
	U1MODEbits.STSEL = 0; // 1 stop bit
	
	U1STAbits.UTXEN = 1; // UART TANSMITER ENABLED
	 
	U1STAbits.URXEN = 1; // UART RECEIVER ENABLED
	
	U1MODEbits.ON = 1; // UART ON;
	
	while(1){
		putc('A');
		delay(1000);
	}
	return 0;
}
