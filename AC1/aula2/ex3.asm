	.data
str1: 	.asciiz "Uma string qualquer"
str2: 	.asciiz "AC1 – P"
	#.eqv PrintString,4
 	.text
 	.globl main
 	
main: 	ori $v0,$0,4	#4: PrintString // ori $v0,$0,4
	la $a0,str2 	#"load-address": $a0 <- 0x10010014
	syscall
	
	jr $ra
