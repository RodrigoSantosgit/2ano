package aula6.ex1;

public class PratoDieta extends Prato{

	private double limite;
	
	public PratoDieta(String nome, double limite) {
		super(nome);
		this.limite = limite;
	}

	@Override
	public String toString() {
		return " [limite calorias: " + limite + super.toString()+"]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		long temp;
		temp = Double.doubleToLongBits(limite);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		PratoDieta other = (PratoDieta) obj;
		if (Double.doubleToLongBits(limite) != Double.doubleToLongBits(other.limite))
			return false;
		return true;
	}

	public double getLimite() {
		return limite;
	}
	
	@Override
	public boolean addIngrediente (Alimento ingredient) {
		if (ingredient.getCalorias() + this.getCalorias() > limite) return false; 

		return super.addIngrediente(ingredient);
	}
	
}
