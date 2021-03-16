# Mapa de registos:
# $t0 – value
# $t1 – bit
# $t2 - i
# $t3 - resto
# $t4 - flag

	  .data
str1: 	  .asciiz "Introduza um numero: "
str2: 	  .asciiz "O valor em binario e: "
	  .eqv print_string, 4
	  .eqv read_int, 5
	  .eqv print_char, 11
	  .text
	  .globl main

main: 	  li $t0,0 			# int value = 0;
	  li $t1,0			# int bit = 0;
	  li $t2,0			# int i = 0;
	  li $t3,0			# int resto = 0;
	  li $t4,0			# int flag = 0;
	  
	  ori $v0, $0, print_string	# print_string("Introduza um numero: ");
	  la  $a0, str1
	  syscall
	  
	  ori $v0, $0, read_int		# value = read_int();
	  syscall
	  or  $t0, $0, $v0	
	  
	  ori $v0, $0, print_string	# print_string("O valor em binário e: ");
	  la  $a0, str2
	  syscall			
	  
do:   	  srl  $t1, $t0, 31		# bit = value >> 31;
	  
if_Flag:  bne $t4, $0, if_C		#
	  beq $t1, $0, endif_E		## if(flag == 1 || bit !=0)
	  
if_C:	  ori $t4, $0, 1		# flag = 1
	  rem $t3, $t2, 4		# resto = i % 4
  	  bne $t3, $0, endif_C		# if(resto==0) 
	  ori $v0, $0, print_char	# print(" ")
	  ori $a0,$0, 0X20
	  syscall

endif_C:  ori $v0, $0, print_char	#   print_char(0x30 + bit);
	  addi $a0, $t1, 0x30		#   0x30 + bit
	  syscall 		 
	  
endif_E:  sll $t0, $t0, 1		#   value = value << 1; 
	  addi $t2, $t2, 1		#   i++
	  
while:	  blt $t2, 32, do		# while(i < 32)

endLoop:  jr $ra			# fim do programa

