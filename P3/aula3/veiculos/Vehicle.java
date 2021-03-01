package aula3.veiculos;

public abstract class Vehicle {

	private double cilindrada, potencia, pesoBruto;
	private int lotacao;
	private char tipo;
	
	public Vehicle() {
		setCilindrada(0);
		setPotencia(0);
		setPesoBruto(0);
		setLotacao(0);
		setTipo(' ');
	}

	public double getCilindrada() {
		return cilindrada;
	}

	public void setCilindrada(double cilindrada) {
		this.cilindrada = cilindrada;
	}

	public double getPotencia() {
		return potencia;
	}

	public void setPotencia(double potencia) {
		this.potencia = potencia;
	}

	public double getPesoBruto() {
		return pesoBruto;
	}

	public void setPesoBruto(double pesoBruto) {
		this.pesoBruto = pesoBruto;
	}

	public int getLotacao() {
		return lotacao;
	}

	public void setLotacao(int lotacao) {
		this.lotacao = lotacao;
	}

	public char getTipo() {
		return tipo;
	}

	public void setTipo(char tipo) {
		this.tipo = tipo;
	}
	
	public abstract boolean cilindradaValida(double cilindrada);
	
	public abstract boolean lotacaoValida(int lotacao);
	
	public abstract boolean potenciaValida(double potencia);
	
	public abstract boolean pesoBrutoValido(double pesoBruto);
	
	public abstract boolean tipoValido(char tipo);

	@Override
	public String toString() {
		return "cilindrada= " + cilindrada + ", potencia= " + potencia + ", pesoBruto= " + pesoBruto
				+ ", lotacao= " + lotacao + ", tipo= " + tipo;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vehicle other = (Vehicle) obj;
		if (Double.doubleToLongBits(cilindrada) != Double.doubleToLongBits(other.cilindrada))
			return false;
		if (lotacao != other.lotacao)
			return false;
		if (Double.doubleToLongBits(pesoBruto) != Double.doubleToLongBits(other.pesoBruto))
			return false;
		if (Double.doubleToLongBits(potencia) != Double.doubleToLongBits(other.potencia))
			return false;
		if (tipo != other.tipo)
			return false;
		return true;
	}
	
}
