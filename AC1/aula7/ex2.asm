# Mapa de registos:
# n: $a0 -> $s0
# b: $a1 -> $s1
# s: $a2 -> $s2
# p: $s3
# digit: $t0
# Sub-rotina intermédia

itoa: 	subu $sp,$sp,16 	# reserva espaço na stack
 	sw $s0,4($sp) 		# guarda registos $sx e $ra
 	sw $s1,8($sp)
 	sw $s2,12($sp)
 	sw $ra,0($sp)
 	
 	move $s0,$a0 		# copia n, b e s para registos
 	move $s1,$a1		# "callee-saved"
 	move $s2,$a2
 	
 	move $s3,$a2 		# p = s;
 	
do: 				# do {
 	rem $t0,$s0,$s1		#
 	div $s0,$s0,$s1		#
 	
 	move $a0,$t0
 	jal toascii
 	
 	sb $v0,0($s3)
 	
 	bgt $s0,0,do 		# } while(n > 0);
 	sb $0,0($s3)		# *p = 0;
 	addiu $s3,$s3,1
 	
 	move $a0,$s2		#
 	jal strrev	 	# strrev( s );
 	move $v0,$s2 		# return s;
 	
 	lw $s0,4($sp) 		# repõe registos $sx e $ra
 	lw $s1,8($sp)
 	lw $s2,12($sp)
 	lw $ra,0($sp)
 	
	addu $sp,$sp,16	 	# liberta espaço na stack
 	jr $ra 			# fim de sub-rotina
 	
####################################################

toascii: addi $a0, $a0, '0'	# v += '0';
if:	 ble  $a0, '9', endIf	# if( v > '9' )
	 addi $a0, $a0, 7	# v += 7; // 'A' - '9' - 1
endIf:	 move $v0, $a0		# return v;
	 jr $ra			# }