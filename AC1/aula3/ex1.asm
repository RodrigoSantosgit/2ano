# Mapa de registos:
# $t0 – soma
# $t1 – value
# $t2 - i
	.data
str1: 	.asciiz "Introduza um numero: "
str2: 	.asciiz "Valor ignorado\n"
str3: 	.asciiz "A soma dos positivos e: "
 	.eqv print_string,4
 	.eqv read_int,5
 	.eqv print_int10,1
 	.text
 	.globl main
 	
main:	ori $t0,$0,0			# int soma = 0
	ori $t2,$0,0			# int i = 0
for: 	bge $t2,5,endfor		# for (i = 0; i<5)

	ori $v0,$0,print_string        # 
	la $a0,str1			#
	syscall				## print(str1)
	
	ori $v0,$0,read_int		#
	syscall				#
	or $t1,$0,$v0			## value = nextInt()
	
	blt $t1,$0,else			# if(value > 0)
	add $t0,$t0,$t1			## soma = soma + value
	j endif				
else:	ori $v0,$0,print_string        # 
	la $a0,str2			#  else
	syscall				## print(str2)
endif:	addi $t2,$t2,1			## i++
	j for
	
endfor:	ori $v0,$0,print_string        # 
	la $a0,str3			#
	syscall				## print(str3)
	
	ori $v0,$0,print_int10		#
	la $a0,($t0)			#
	syscall				## print(soma)
	
	jr $ra 				# fim do programa
 	