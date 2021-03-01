package aula4.ex1;

public class Professor extends Pessoa{

	private static int nextNFunc = 1;
	private int nFunc;
	private Data dataAdm;
	
	public Professor(String nome, int numcc, Data dataNasc, Data dataAdm) {
		super(nome, numcc, dataNasc);
		this.nFunc = nextNFunc++;
		this.dataAdm = dataAdm;
	}
	
	public Professor(String nome, int numcc, Data dataNasc) {
		super(nome, numcc, dataNasc);
		this.nFunc = nextNFunc++;
		this.dataAdm = Data.today();
	}

	public int getnFunc() {
		return nFunc;
	}

	public Data getDataAdm() {
		return dataAdm;
	}

	@Override
	public String toString() {
		return super.toString()+ ", Professor, numero de Funcionario= " + nFunc + ", data Admissao= " + dataAdm;
	}
	
	
	
}
