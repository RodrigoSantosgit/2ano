package aula8;

public class LogicJogo {

	private final char PLAYER1;
	private final char PLAYER2;
	private char lastPlayer;
	private int lastLine;
	private int lastCol;
	private int numTurns;
	private static char[][] board;
	static final char EMPTY = '\0';
	
	public LogicJogo(char p1, char p2) {
		PLAYER1 = p1;
		PLAYER2 = p2;
		lastPlayer = EMPTY;
		numTurns = 0;
		lastLine = -1;
		lastCol = -1;
		board = new char[3][3]; //tamanho do tabuleiro 3x3
	    for(int l = 0; l < 3; l++) 
	      for(int c = 0; c < 3; c++)
	        board[l][c] = EMPTY; // inicializar as posições com o caracter EMPTY;
		
		
	}
	
	public char getLastPlayer() { 
		  return lastPlayer; //jogador que efetuou a ultima jogada
	}

	public int getNumTurns() {
		return numTurns;	//numero de turnos jogados
	}
	
	public static boolean validCoord(int lin, int col) { //verifica se as coordenadas são válidas
	    return 1<=lin && lin<=3 && 1<=col && col<=3;
	}
	  
	public static boolean emptyPosition(int lin, int col) {
	    assert validCoord(lin, col);
	    return board[lin-1][col-1] == EMPTY;  // verifica se a posição está vazia
	}
	
	public boolean validPlay(int lin, int col) {
		return validCoord(lin, col) && emptyPosition(lin, col) && !finished();
	}

	public boolean finished() {
		return (lastPlayer != EMPTY && lastPlayerWinner()) || numTurns == 9;
	}
	
	public void turn(int lin, int col) {
		if(validPlay(lin,col)) {
			if(lastPlayer==EMPTY)
				lastPlayer = PLAYER1;
			else if (lastPlayer==PLAYER1)
				lastPlayer = PLAYER2;
			else
				lastPlayer = PLAYER1;
			
			lastLine = lin-1;
			lastCol = col-1;
			board[lin-1][col-1] = lastPlayer;
			numTurns++;
		}
		else
			System.out.println("ERROR: Invalid Play!");
	}
	
	private int count(int lin, int col, int dirLin, int dirCol) {
		int result=0;
		int l = lin+dirLin;
		int c = col+dirCol;
		
		if(l >= 0 && l < 3  && c>=0 && c<3 && (board[l][c] == lastPlayer))
			result = 1 + count(l,c,dirLin,dirCol);
		return result;
	}
	
	public boolean lastPlayerWinner() {
		boolean winner;
		winner = 1 + (count(lastLine, lastCol, 1,0) + count(lastLine, lastCol, -1,0))==3;  // direção |
		if(!winner)
			winner = 1 + (count(lastLine,lastCol,0,1) + count(lastLine,lastCol,0,-1))==3;  // direção -
		if(!winner)
			winner = 1 + (count(lastLine,lastCol,1,1) + count(lastLine, lastCol,-1,-1))==3; // direção \
		if(!winner)
			winner = 1+ (count(lastLine,lastCol,1,-1) + count(lastLine, lastCol,-1,1))==3; // direção /
		return winner;
		
	}
	
}
