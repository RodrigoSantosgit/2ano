package aula5.ex2;

public class Bicicleta extends Veiculo {

	public Bicicleta(String corBase, int ano, int numRodas) {
		super(corBase, ano, numRodas);
	}

	@Override
	public String toString() {
		return "Bicicleta: " + super.toString();
	}
	
}
