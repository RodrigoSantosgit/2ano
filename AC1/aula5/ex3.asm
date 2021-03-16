# Mapa de registos
# ...
# houve_troca: $t4
# i: $t5
# lista: $t6
# lista + i: $t7

 	.data
 	.eqv FALSE,0
 	.eqv TRUE,1
 	.eqv SIZE,10
 	.eqv print_int10,1
 	.eqv read_int,5
 	.eqv print_string,4
 	.space 20
str1:  	.asciiz "Introduza um numero: "
str2:  	.asciiz "Conteudo do array:\n"
 	.text
 	.globl main
 	
main: 	(...)	 		# código para leitura de valores
 	la $t6,lista 		#
do: 				# do {
 	li $t4,FALSE 		# houve_troca = FALSE;
 	li $t5,0 		# i = 0;
while: 	bge $t5, 		# while(i < SIZE-1){
if: 	sll $t7,$t5,2 		# $t7 = i * 4
 	addu $t7,$t7,... 	# $t7 = &lista[i]
 	lw $t8,0(...) 		# $t8 = lista[i]
	lw $t9,4(...) 		# $t9 = lista[i+1]
 	b?? ...,...,endif 	# if(lista[i] > lista[i+1]){
 	sw $t8,4(...) 		# lista[i+1] = $t8
 	sw $t9,0(...) 		# lista[i] = $t9
 	li $t4,TRUE 		#
 				# }
endif: 	addi $t5,$t5,1 		# i++;
 	(...) ... 		# }
 	(...) 			# } while(houve_troca == TRUE);
 	(...) 			# codigo de impressao do
 				# conteudo do array
 	jr $ra