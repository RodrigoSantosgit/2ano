#include <detpic32.h>

#define DisableUart1RxInterrupt() IEC0bits.U1RXIE = 0
#define EnableUart1RxInterrupt()  IEC0bits.U1RXIE = 1
#define DisableUart1TxInterrupt() IEC0bits.U1TXIE = 0
#define EnableUart1TxInterrupt()  IEC0bits.U1TXIE = 1

#define BUF_SIZE 8
//#define INDEX_MASK (BUF_SIZE – 1)
const int INDEX_MASK = 7;
#define TRUE 1;
#define FALSE 0;

typedef struct
{
	unsigned char data[BUF_SIZE];
	unsigned int head;
	unsigned int tail;
	unsigned int count;
} circularBuffer;

volatile circularBuffer txb;
volatile circularBuffer rxb;

void comDrv_config(unsigned int baud, char parity, unsigned int stopbits){

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

void comDrv_flushRx(void)
{
	rxb.head = 0;
	rxb.tail = 0;
	rxb.count = 0;
}

void comDrv_flushTx(void)
{
	// Initialize variables of the transmission buffer
	txb.head = 0;
	txb.tail = 0;
	txb.count = 0;
}

void comDrv_putc(char ch)
{
	while(txb.count == BUF_SIZE){} // Wait while buffer is full
	txb.data[txb.tail] = ch;
	// Copy character to the transmission
	// buffer at position "tail"
	txb.tail = (txb.tail + 1) & INDEX_MASK; // Increment "tail" index
	// (mod. BUF_SIZE)
	DisableUart1TxInterrupt();
	// Begin of critical section
	// Increment "count" variable
	txb.count = txb.count + 1;
	EnableUart1TxInterrupt();
	// End of critical section
}

void comDrv_puts(char *s)
{
	while(1){
		if(*s != '\0'){
			comDrv_putc(*s);
			s++;
		}
		else break;
	}
}

char comDrv_getc(char *pchar)
{
	// Test "count" variable (reception buffer) and return FALSE
	// if it is zero
	if(rxb.count == 0) return FALSE;
	DisableUart1RxInterrupt();
	// Begin of critical section
	// Copy character pointed by "head" to *pchar
	*pchar = rxb.data[rxb.head];
	rxb.count--;
	// Decrement "count" variable
	// Increment "head" variable (mod BUF_SIZE)
	rxb.head = (rxb.head + 1 ) & INDEX_MASK;
	EnableUart1RxInterrupt();
	if(*pchar == 's' || *pchar == 'S')
	{
		comDrv_puts("0101010101000010110001111000000001 S \0");
	}
	// End of critical section
	return TRUE;
}

void _int_(24) isr_uart1(void)
{	
	// if U1TXIF is set
	if(IFS0bits.U1TXIF == 1)
	{
		// if "count" variable (transmission buffer, txb) is greater than 0
		if(txb.count > 0)
		{
			// Copy character pointed by "head" to U1TXREG register
			U1TXREG = txb.data[txb.head];
			// Increment "head" variable (mod BUF_SIZE)
			txb.head = (txb.head + 1) & INDEX_MASK;
			// Decrement "count" variable
			txb.count -= 1;
		}
		// if "count" variable is 0 then
		if(txb.count == 0)
			DisableUart1TxInterrupt();
		// Reset UART1 TX interrupt flag
		IFS0bits.U1TXIF = 0;
	
	}
	
	// If U1RXIF is set
	if(IFS0bits.U1RXIF == 1)
	{
		rxb.data[rxb.tail] = U1RXREG; 	// Read character from UART and
										// write it to the "tail" position
										// of the reception buffer
		// Increment "tail" variable (mod BUF_SIZE)
		rxb.tail = (rxb.tail + 1) & INDEX_MASK;
		// If reception buffer is not full (e.g. count < BUF_SIZE) then
		if(rxb.count < BUF_SIZE)
			rxb.count++;
		// increment "count" variable
		else
			rxb.head = (rxb.head +1) & INDEX_MASK;
		// Else 
		// increment "head" variable (discard oldest character)
		// reset UART1 RX interrupt flag
		IFS0bits.U1RXIF = 0;
		
	}
	
}
 
int main(void)
{
	comDrv_config(115200,'N',1); // default "pterm" parameters
	// with RX interrupts enabled and TX
	IPC6bits.U1IP = 2;
	IFS0bits.U1TXIF = 0;
	IFS0bits.U1RXIF = 0;
	IEC0bits.U1RXIE = 1;
	IEC0bits.U1TXIE = 1;
	// interrupts disabled
	// (...)
	
	comDrv_flushRx();
	comDrv_flushTx();
	
	EnableInterrupts();
	
	comDrv_puts("PIC32 UART Device-driver S\n");
	
	char aux;
	
	while(1)
	{
	// Read character from reception buffer
		if(comDrv_getc(&aux))
			comDrv_putc(aux);
	// Send character to the transmission buffer
	}
	return 0;
}
