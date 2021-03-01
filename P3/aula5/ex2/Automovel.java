package aula5.ex2;

public class Automovel extends Motorizado {

	
	public Automovel(String matricula, String corBase, int ano, int numRodas, int cilindrada, int maxVel, int potencia, int consumo, Combustivel comb) {
		super(corBase,numRodas, ano,matricula,cilindrada,maxVel, potencia, consumo, comb);
	}

	@Override
	public String toString() {
		return super.toString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		return true;
	}
}
