package aula9.ex3;

public class Pessoa {
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dataNasc == null) ? 0 : dataNasc.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + numCC;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pessoa other = (Pessoa) obj;
		if (dataNasc == null) {
			if (other.dataNasc != null)
				return false;
		} else if (!dataNasc.equals(other.dataNasc))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (numCC != other.numCC)
			return false;
		return true;
	}

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
