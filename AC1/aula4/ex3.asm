# Mapa de Registos:
# p: $t0
# p_ultimo: $t1
# *p: $t2
# soma: $t3

	.data	
	.eqv SIZE, 4				# define SIZE 4
	.eqv print_int10, 1
array:	.word 7692, 23, 5, 234
	.text
	.globl main	
			
main:						# void main (void) {
	li $t3, 0				# int soma = 0;
	
	li $t4, SIZE				# _
	sll $t4, $t4, 2				## $t4 = SIZE x 4; 
	
	la  $t0, array				# p = array	 	  	<->  ($t0 = &array[0]) 		
	addu $t1, $t0, $t4			# p_ultimo = array + size	<->  ($t1 = &array[3])

while:  bge $t0, $t1, endW 			# while( p < pultimo ) {	

	lw $t2, 0($t0)				# $t2 = *p
	add $t3, $t3, $t2			# soma = soma + (*p);
	addi $t0, $t0, 4			# p++
	j while					# }
endW:	
	ori $v0, $0, print_int10		# _
	or  $a0, $0, $t3			# _
	syscall					## print_int10(soma);
	  
	jr $ra					# terminar programa;
	