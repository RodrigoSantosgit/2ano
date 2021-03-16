#void main(void)
#{
# unsigned int gray, bin, mask;

# print_string("Introduza um numero: ");
# gray = read_int();
# mask = gray >> 1;
# bin = gray;
# while(mask != 0)
# {
# bin = bin ^ mask;
# mask = mask >> 1;
# }

# print_string("\nValor em código Gray: ");
# print_int16(gray);
# print_string("\nValor em binario: ");
# print_int16(bin);
#} 

#-----------------------------------------

# VARIAVEIS:
# gray - $t0
# bin - $t1
# mask - $t2

#-----------------------------------------

	.data
str1:	.asciiz "Introduza um numero: "
str2:   .asciiz "Valor em codigo Gray: "
str3:	.asciiz "Valor em binario: "
	.eqv print_string, 4
	.eqv read_int, 5
	.eqv print_int16, 34
	.text
	.globl main
	
main:	ori $v0, $0, print_string	#
	la $a0, str1			#
	syscall				## print("Introduza um numero: ")
	
	ori $v0, $0, read_int		#
	syscall				#
	ori $t0, $0, $v0 		## gray = nextInt()
	
	srl $t2, $t0, 1			## mask = gray >> 1
	
	or $t1, $0, $t0			## bin = gray
	
while:  beq $t2, $0, endCic		## while(mask != 0)
	xor $t1, $t1, $t2		## bin = bin ^ mask
	srl $t2, $t2, 1

endCic:	ori $v0, $0, print_string	#
	la $a0, str1			#
	syscall				## print("Valor em codigo Gray: ")

	ori $v0, $0, print_int16	#
	la $a0, $t0			#
	syscall				## print(gray)
	
	ori $v0, $0, print_string	#
	la $a0, str3			#
	syscall				## print("Valor em binario: ")
	
	jr $ra 				## fim programa
