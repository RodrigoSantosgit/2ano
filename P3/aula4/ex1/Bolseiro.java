package aula4.ex1;

public class Bolseiro extends Estudante{

	private int bolsa;

	public Bolseiro(String nome, int numcc, Data dataNasc, Data dataInsc) {
		super(nome, numcc, dataNasc, dataInsc);
		setBolsa(0);
	}
	
	public Bolseiro(String nome, int numcc, Data dataNasc) {
		super(nome, numcc, dataNasc);
		setBolsa(0);
	}

	public int getBolsa() {
		return bolsa;
	}

	public void setBolsa(int bolsa) {
		this.bolsa = bolsa;
	}

	@Override
	public String toString() {
		return super.toString() + "; Bolsa: " + bolsa + "euros";
	}
}
