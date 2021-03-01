package aula6.ex1;

public class PratoVegetariano extends Prato{

	public PratoVegetariano(String nome) {
		super(nome);
	}

	@Override
	public String toString() {
		return super.toString();
	}
	
	@Override
	public boolean addIngrediente (Alimento ingredient) {
		if (ingredient instanceof AlimentoVegetariano) return false; 

		return super.addIngrediente(ingredient);
	}
	
}
