package aula5.ex2;

public class MotoPolicia extends Moto implements Policia{

	private static int nextID = 0;
	private String id;
	private Tipo tipo;
	
	public MotoPolicia(String matricula, String corBase, int ano, int numRodas, int cilindrada, int maxVel,
			int potencia, int consumo, Combustivel comb,Tipo tipo) {
		super(matricula, corBase, ano, numRodas, cilindrada, maxVel, potencia, consumo, comb);
		this.id ="#" + nextID++;
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
		return "MotoPolicia: id=" + id + ", tipo=" + tipo + super.toString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		MotoPolicia other = (MotoPolicia) obj;
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
