	.data
 	.text
 	.globl main
 	
main: 	ori $t0,$0,7	# instrução virtual (decomposta
 	ori $t1,$0,7		# em duas instruções nativas)
 			 
 	srl $t1,$t1,4		#desolcamento de 1 bit 
 	xor $t1,$t0,$t1		# $t0 ^ $t1
 	
 	
 	srl $t0,$t1,2
 	xor $t1,$t1,$t0
 	
 	srl $t0,$t1,1
 	xor $t1,$t1,$t0
 	
 	jr $ra 		# fim do programa