package aula13.ex1.alinea_e;

public class Localidade {

	private String nome;
	private int populacao;
	
	public Localidade(String nome, int populacao) {
		this.nome = nome;
		this.populacao = populacao;
	}

	@Override
	public String toString() {
		return String.format("%s, Popula��o: %d",nome,populacao);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + populacao;
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
		Localidade other = (Localidade) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (populacao != other.populacao)
			return false;
		return true;
	}
	
	
	
}
