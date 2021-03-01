package aula5.ex2;

public class Moto extends Motorizado {

	
	public Moto(String matricula, String corBase, int ano, int numRodas, int cilindrada, int maxVel, int potencia, int consumo, Combustivel comb) {
		super(corBase, numRodas, ano, matricula, cilindrada, maxVel, potencia, consumo,comb);
	
	}

	@Override
	public String toString() {
		return "Moto: " + super.toString();
	}

}
