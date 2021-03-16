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

void putstr (char *str){
	
	while(*str != '\0'){
		putc(*str);
		str++;
	}

}

int main(void){
	
	U1BRG = ((PBCLK + 8 * baudrate) / (16 * baudrate)) - 1;
	U1MODEbits.BRGH = 0;
	
	U1MODEbits.PDSEL = 0;
	
	U1MODEbits.STSEL = 0;
	
	U1STAbits.UTXEN = 1;
	
	U1STAbits.URXEN = 1;
	
	U1MODEbits.ON = 1;
	
	while(1){
		putstr("Daniel\n");
		delay(1000);
	}
	
	return 0;
}
