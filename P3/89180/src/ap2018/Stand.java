package ap2018;

public class Stand implements Expositor{

	private String codigo, nome;
	private Participante responsavel;
	
	
	public Stand(String codigo, String nome, Participante responsavel) {
		this.codigo = codigo;
		this.nome = nome;
		this.responsavel = responsavel;
	}
	
	@Override
	public String codigo() {
		return codigo;
	}

	@Override
	public Participante responsavel() {
		return responsavel;
	}

	public String getNome() {
		return nome;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((responsavel == null) ? 0 : responsavel.hashCode());
		return result;
	}

	@Override
	public String toString() {
		return "Stand [codigo=" + codigo + ", nome=" + nome + ", responsavel=" + responsavel + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Stand other = (Stand) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (responsavel == null) {
			if (other.responsavel != null)
				return false;
		} else if (!responsavel.equals(other.responsavel))
			return false;
		return true;
	}
	
}
