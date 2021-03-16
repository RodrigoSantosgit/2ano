	.data
 	.text
 	.globl main
 	
main: 	ori $t0,$0,2	# instrução virtual (decomposta
 			# em duas instruções nativas)
 			 
 	srl $t1,$t0,1		#desolcamento de 1 bit 
 	xor $t1,$t0,$t1		# $t0 ^ $t1
 	
 	jr $ra 		# fim do programa