package ap2018;

public class StandOrganizacao extends Stand{

	@Override
	public String toString() {
		return "StandOrganizacao [contato=" + contato + "]";
	}

	private String contato;
	
	public StandOrganizacao(String codigo, String nome, Participante responsavel, String contato) {
		super(codigo, nome, responsavel);
		this.contato = contato;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((contato == null) ? 0 : contato.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		StandOrganizacao other = (StandOrganizacao) obj;
		if (contato == null) {
			if (other.contato != null)
				return false;
		} else if (!contato.equals(other.contato))
			return false;
		return true;
	}

	public static StandOrganizacao instance(String codigo, String nome, Participante responsavel, String contato) {
		return new StandOrganizacao(codigo, nome, responsavel, contato);
	}

	public String getContato() {
		return contato;
	}
	
}
