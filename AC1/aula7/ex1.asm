# Mapa de registos
# res: $v0
# s: $a0
# *s: $t0
# digit: $t1
# Sub-rotina terminal: n�o devem ser usados registos $sx

atoi: 	li $v0,0 		# res = 0;
while: 	lb $t0,0($a0) 		# while(*s >= ...)
 	blt $t0,'0',endW 	#
 	bgt $t0,'9',endW	# {
 	sub $t1,$t1,'0' 	# digit = *s � '0'
 	addiu $a0,$a0,1 	# s++;
 	mul $v0,$v0,10 		# res = 10 * res;
 	add $v0,$v0,$t1		# res = 10 * res + digit;
 	j while			# }
endW: 	jr $ra 			# termina sub-rotina