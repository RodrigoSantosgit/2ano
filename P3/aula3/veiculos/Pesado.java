package aula3.veiculos;

public abstract class Pesado extends Vehicle {

	public Pesado() {
		super();
	}
	
	@Override
	public boolean cilindradaValida(double cilindrada) {
		return cilindrada >= 1000;
	}

	@Override
	public boolean potenciaValida(double power) {
		return power >= 100;
	}

	@Override
	public boolean pesoBrutoValido(double pesoBruto) {
		return pesoBruto > 3500;
	}

	@Override
	public boolean lotacaoValida(int lotacao) {
		return lotacao > 9;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!super.equals(obj)) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		return true;
	}
	
	@Override
	public String toString() {
		return super.toString();
	}
	
}
