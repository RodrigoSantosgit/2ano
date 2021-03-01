package aula4.ex1;

public class Pessoa {
	
	private String nome;
	private int numCC;
	private Data dataNasc;
	
	public Pessoa (String nome, int numcc, Data dataNasc) {
		this.nome  = nome;
		this.numCC   = numcc;
		this.dataNasc = dataNasc;
	}
	
	public String getNome() {
		return nome;
	}
	
	public int getNumCC() {
		return numCC;
	}
	
	public Data getDataNasc() {
		return dataNasc;
	}
	
	public String toString() {
		
		String s = nome;

		s+="; Numero de CC: ";
		s+=numCC;

		s+="; data de nascimento: ";
		s+=dataNasc;

		return s;
	}
}
