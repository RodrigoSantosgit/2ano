package aula5.ex2;

public abstract class Motorizado extends Veiculo{
	
	private String matricula;
	private int cilindrada, maxVel, potencia, consumo;
	private Combustivel comb;
	
	public Motorizado(String corBase, int numRodas, int ano,String matricula, int cilindrada, int maxVel, int potencia, int consumo,Combustivel comb) {
		super(corBase, ano, numRodas);
		this.matricula = matricula;
		this.cilindrada = cilindrada;
		this.maxVel = maxVel;
		this.potencia = potencia;
		this.consumo = consumo;
		this.comb = comb;
	}

	public String getMatricula() {
		return matricula;
	}

	public int getCilindrada() {
		return cilindrada;
	}

	public int getMaxVel() {
		return maxVel;
	}

	public int getPotencia() {
		return potencia;
	}

	public int getConsumo() {
		return consumo;
	}
	
	public Combustivel getComb() {
		return comb;
	}

	@Override
	public String toString() {
		return "matricula=" + matricula + ", cilindrada=" + cilindrada + ", maxVel=" + maxVel
				+ ", potencia=" + potencia + ", consumo=" + consumo + super.toString();
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Motorizado other = (Motorizado) obj;
		if (cilindrada != other.cilindrada)
			return false;
		if (consumo != other.consumo)
			return false;
		if (matricula == null) {
			if (other.matricula != null)
				return false;
		} else if (!matricula.equals(other.matricula))
			return false;
		if (maxVel != other.maxVel)
			return false;
		if (potencia != other.potencia)
			return false;
		return true;
	}
	
	
	
}
