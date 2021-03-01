package aula3.veiculos;

public class Motociclo extends Vehicle{

	public Motociclo() {
		this.setTipo('A');
	}

	@Override
	public boolean cilindradaValida(double cilindrada) {
		return cilindrada >= 50;
	}

	@Override
	public boolean potenciaValida(double power) {
		return power >= 0;
	}

	@Override
	public boolean pesoBrutoValido(double pesoBruto) {
		return pesoBruto > 0;
	}

	@Override
	public boolean tipoValido(char tipo) {
		return tipo=='A';
	}

	@Override
	public boolean lotacaoValida(int lotacao) {
		return lotacao >= 1 && lotacao <= 2;
	}
	
	@Override
	public String toString() {
		return "Motociclo: " + super.toString();
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
