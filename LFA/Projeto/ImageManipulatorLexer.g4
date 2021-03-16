
lexer grammar ImageManipulatorLexer;


LOADIMAGE   : 'LoadImage';
ROTATE      : '.rotate'  ;
FILTER      : '.filter'  ;
SAVE        : 'Save'     ;
SHOW        : 'Show'     ;
ADD         : 'Add';
FACEDETECT  : 'FaceDetect';
CROP        : 'Crop';
ZOOM        : '.zoom';
DETAILS     : '.details';
BRIGHTNESS  : '.brightness';
GAMMA    	: '.gamma';
SMOOTHING   : '.smoothing';
HISTOGRAM   : '.histogram';
MATCH       : '.match';
IF          : 'if';
COMPAREHIST : '.compare_histogram';

ARROW: '->' ;
EQUALSIGN: '=';
SUM: '+';
BRACKET1 : '(' ;
BRACKET2 : ')';
ENDINST: ';' ;
COMMA: ',' ;

ID 	 : [a-zA-Z][a-zA-Z0-9_]*;
STRING 	 : '"' [A-Za-z0-9_]+ '.' [A-Za-z]+ '"';
INT 	 : [0-9]+;
COMMENT  : '//' .*? '\n' -> skip;
COMMENT2 : '/#' .*? '#/' -> skip;
WS 	 : [ \t\r\n]+ -> skip;
ERROR	 : .;

