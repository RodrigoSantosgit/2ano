package ap2018;

public class StandServicos extends Stand{

	private Servico tipo;

	public StandServicos(String codigo, String nome, Participante responsavel, Servico tipo) {
		super(codigo, nome, responsavel);
		this.tipo = tipo;
	}

	@Override
	public String toString() {
		return "StandServicos [tipo=" + tipo + "]";
	}
	
	public Servico getTipo() {
		return tipo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((tipo == null) ? 0 : tipo.hashCode());
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
		StandServicos other = (StandServicos) obj;
		if (tipo != other.tipo)
			return false;
		return true;
	}
	
	
}
