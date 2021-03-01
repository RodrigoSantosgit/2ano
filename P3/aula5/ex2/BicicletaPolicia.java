package aula5.ex2;

public class BicicletaPolicia extends Bicicleta implements Policia {
	
	private static int nextID = 0;
	private String id;
	private Tipo tipo;
	
	public BicicletaPolicia(String corBase, int ano, int numRodas, Tipo tipo) {
		super(corBase, ano, numRodas);
		this.id = "#"+nextID++;
		this.tipo = tipo;
	}

	public String getID() {
		return id;
	}

	public Tipo getTipo() {
		return tipo;
	}

	@Override
	public String toString() {
		return "BicicletaPolicia: id=" + id + ", tipo=" + tipo + super.toString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		BicicletaPolicia other = (BicicletaPolicia) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (tipo != other.tipo)
			return false;
		return true;
	}

}
