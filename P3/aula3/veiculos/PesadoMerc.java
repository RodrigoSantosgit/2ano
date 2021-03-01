package aula3.veiculos;

public class PesadoMerc extends Pesado{

	public PesadoMerc() {
		this.setTipo('C');
	}
	
	@Override
	public boolean tipoValido(char tipo) {
		return tipo=='C';
	}
	
	@Override
	public String toString() {
		return "Pesado de Mercadorias: " + super.toString();
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
