		.data
		.eqv MAX_STR_SIZE, 33
		.eqv print_string, 4
		.eqv read_int, 5
		.text
		.globl main, strrev_ex2, ex2
		
main:		subiu $sp, $sp, 4
		sw $ra, 0($sp)
		
		li $a0,0
		
do:		li $a0,read_int
		syscall
		
		move $a1,2
		jal itoa