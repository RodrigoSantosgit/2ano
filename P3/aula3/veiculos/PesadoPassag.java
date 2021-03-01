package aula3.veiculos;

public class PesadoPassag extends Pesado{

	public PesadoPassag() {
		this.setTipo('D');
	}

	@Override
	public boolean tipoValido(char tipo) {
		return tipo=='D';
	}
	
	@Override
	public String toString() {
		return "Pesado de Passageiros: " + super.toString();
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
