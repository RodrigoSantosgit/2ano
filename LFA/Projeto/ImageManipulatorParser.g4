parser grammar ImageManipulatorParser;

options {
	tokenVocab = ImageManipulatorLexer;
}


main: (instruction ENDINST)*  EOF;

instruction	: load
			| show
			| add
			| rotate
			| filter
			| zoom
			| save
			| facedetect
			| crop
			| details
			| brightness
			| gamma
			| smoothing
			| histogram
			| match
			| conditional
			| booleanexpr
			| compare_histogram
			;
		
load 	: LOADIMAGE ID EQUALSIGN e=expr;

rotate	: ID ROTATE ARROW e=expr;

filter 	: ID FILTER ARROW e=expr;

save 	: SAVE ID ARROW e=expr;

show 	: SHOW ID;

add		: ADD ID EQUALSIGN e1=expr SUM e2=expr;

facedetect	: FACEDETECT ID;

crop		: CROP ID ARROW BRACKET1 e1=expr COMMA e2=expr BRACKET2 BRACKET1 e3=expr COMMA e4=expr BRACKET2;

zoom 		: ID ZOOM ARROW INT;

details 	: ID DETAILS;

brightness	: ID BRIGHTNESS ARROW INT;

gamma 		: ID GAMMA ARROW INT;

smoothing   : ID SMOOTHING ARROW INT;

histogram : ID HISTOGRAM;

compare_histogram: ID COMPAREHIST ARROW ID;

match: e1=expr MATCH e2=expr ARROW ID;										
		
booleanexpr :  e1=facedetect | e2=match ;

conditional: IF booleanexpr ARROW e=expr ;



expr 	: STRING 				#ExprStr
		| INT 					#ExprInt 
		| ID					#ExprID
		;
		
		
		

