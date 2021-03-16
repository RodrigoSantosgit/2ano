#include <detpic32.h>

volatile int flag = 0;

int main(void)
{
	// Configure Timer T1 with interrupts enabled
	T1CONbits.TCKPS = 7;
	PR1 = 39062; // 20 000 000 / (2*256) - 1
	TMR1 = 0;
	T1CONbits.TON = 1;
	
	IPC1bits.T1IP = 2;
	IEC0bits.T1IE = 1;
	IFS0bits.T1IF = 0;  // reset interrupt flag
	
	T3CONbits.TCKPS = 5;
	PR3 = 62499; // 20 000 000 / (2*256) - 1
	TMR3 = 0;
	T3CONbits.TON = 1;
	
	IPC3bits.T3IP = 2;
	IEC0bits.T3IE = 1;
	IFS0bits.T3IF = 0;  // reset interrupt flag
	
	
	EnableInterrupts();
	while(1);
	return 0;
}

void _int_(12) isr_T3(void) // Replace VECTOR by the timer T3 vector number
{
	putChar('3');
	// Reset T3 interrupt flag
	IFS0bits.T3IF = 0;
	
}
void _int_(4) isr_T1(void)
{
	// print character '1'
	putChar('1');
	// Reset T1IF flag
	IFS0bits.T1IF = 0;
}
