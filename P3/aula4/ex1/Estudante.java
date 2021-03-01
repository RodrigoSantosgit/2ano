package aula4.ex1;

public class Estudante extends Pessoa{
	
	private static int nextNMec = 100;
	private int numMec;
	private Data dataInsc;
	
	public Estudante(String nome, int numcc, Data dataNasc, Data dataInsc) {
		super(nome, numcc, dataNasc);
		this.numMec = nextNMec++;
		this.dataInsc = dataInsc;
	}
	
	public Estudante(String nome, int numcc, Data DataNasc) {
		this(nome, numcc, DataNasc, Data.today());
	}
	
	public int getNumMec() {
		return numMec;
	}
	
	public Data getDataInsc() {
		return dataInsc;
	}
	
	@Override
	public String toString() {
		return super.toString() + "; num Mec = " + numMec + "; Data de Inscrição = " + dataInsc;
	}
	
}
