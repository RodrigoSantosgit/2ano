package aula8;

public class PlayersJogo {

	char player1 = 'X';
	char player2 = 'O';
	
	private LogicJogo jogo = new LogicJogo(player1, player2);
	
	public void turnPlay(int col, int lin) {
		jogo.turn(lin, col);
	}
	
	public String lastPlayer() {
		return jogo.getLastPlayer() + " ";
	}
	
	public boolean finished() {
		return jogo.finished();
	}
	public boolean lastPlayerWinner() {
		return jogo.lastPlayerWinner();
	}
}
