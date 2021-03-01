package aula6.ex1;

public class Carne extends Alimento {

	private Variedade variedade;

	public Carne(Variedade variedade, double calorias, double peso, double proteinas) {
		super(proteinas, calorias, peso);
		this.variedade = variedade;
	}

	public Variedade getVariedade() {
		return variedade;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((variedade == null) ? 0 : variedade.hashCode());
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
		Carne other = (Carne) obj;
		if (variedade != other.variedade)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "variedade: " + variedade + super.toString();
	}
	
}
