package aula3.veiculos;

public class Ligeiro extends Vehicle{

	public Ligeiro() {
		this.setTipo('B');
	}
	
	@Override
	public boolean cilindradaValida(double cilindrada) {
		return cilindrada >= 500;
	}

	@Override
	public boolean potenciaValida(double power) {
		return power >= 50;
	}

	@Override
	public boolean pesoBrutoValido(double pesoBruto) {
		return pesoBruto > 0 && pesoBruto <= 3500;
	}

	@Override
	public boolean tipoValido(char tipo) {
		return tipo=='B';
	}

	@Override
	public boolean lotacaoValida(int lotacao) {
		return lotacao >= 1 && lotacao <= 9;
	}

	@Override
	public String toString() {
		return "Ligeiro: " + super.toString();
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
	
}
