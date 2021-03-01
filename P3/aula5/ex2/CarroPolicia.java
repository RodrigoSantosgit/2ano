package aula5.ex2;

public class CarroPolicia extends Automovel implements Policia{
	
	private static int nextID = 0;
	private String id;
	private Tipo tipo;
	
	public CarroPolicia(String matricula, String corBase, int ano, int numRodas, int cilindrada, int maxVel, String id,
			Tipo tipo, int potencia, int consumo, Combustivel comb) {
		super(matricula, corBase, ano, numRodas, cilindrada, maxVel, potencia, consumo, comb);
		this.id = "#" + nextID++;
		this.tipo = tipo;
	}

	public String getID() {
		return id;
	}

	public Tipo getTipo() {
		return tipo;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		CarroPolicia other = (CarroPolicia) obj;
		if (id != other.id)
			return false;
		if (tipo != other.tipo)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Carro Policia: id=" + id + ", tipo=" + tipo + super.toString();
	}
	
}
