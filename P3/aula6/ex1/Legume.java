package aula6.ex1;

public class Legume extends AlimentoVegetariano{


	public Legume(String nome, double calorias, double peso, double proteinas) {
		super(proteinas, calorias, peso, nome);
	}

	@Override
	public String toString() {
		return ", " + super.toString();
	}
	
}
