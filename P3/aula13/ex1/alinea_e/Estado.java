package aula13.ex1.alinea_e;

public class Estado extends Regiao{

	private final Cidade capital;
	
	public Estado(String nome, int populacao, Cidade capital) {
		super(nome, populacao);
		this.capital = capital;
	}

	public Cidade getCapital() {
		return capital;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((capital == null) ? 0 : capital.hashCode());
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
		Estado other = (Estado) obj;
		if (capital == null) {
			if (other.capital != null)
				return false;
		} else if (!capital.equals(other.capital))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Estado: " + super.toString() + "capital: " + capital;
	}

	
	
}
