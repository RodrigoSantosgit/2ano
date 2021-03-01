package aula5.ex2;

public abstract class Veiculo {

	String corBase;
	int ano, numRodas;
	
	public Veiculo(String corBase, int ano, int numRodas) {
		this.corBase = corBase;
		this.ano = ano;
		this.numRodas = numRodas;
	}

	public String getCorBase() {
		return corBase;
	}

	public void setCorBase(String corBase) {
		this.corBase = corBase;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public int getNumRodas() {
		return numRodas;
	}

	public void setNumRodas(int numRodas) {
		this.numRodas = numRodas;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Veiculo other = (Veiculo) obj;
		if (ano != other.ano)
			return false;
		if (corBase == null) {
			if (other.corBase != null)
				return false;
		} else if (!corBase.equals(other.corBase))
			return false;
		if (numRodas != other.numRodas)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "cor base = " + corBase + ", ano = " + ano + ", num rodas = " + numRodas;
	}
}
