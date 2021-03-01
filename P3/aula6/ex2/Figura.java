package aula6.ex2;

public abstract class Figura implements Comparable<Figura>{

private Ponto centro;
	
	public Figura(Ponto centro) {
		setCentro(centro);
	}
	
	public Figura(double x, double y) {
		this(new Ponto(x,y));
	}
	
	public Ponto getCentro() {
		return centro;
	}

	public void setCentro(Ponto centro) {
		this.centro = centro;
	}
	
	@Override
	public String toString() {
		return "Figura com centro " + centro; 
	}
	
	public abstract double getArea();
	
	public abstract double getPerimetro();

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Figura other = (Figura) obj;
		if (centro == null) {
			if (other.centro != null)
				return false;
		} else if (!centro.equals(other.centro))
			return false;
		return true;
	}
	
	public int compareTo(Figura fig) {
		if(this.getArea()<fig.getArea())
			return -1;
		if(this.getArea()>fig.getArea())
			return 1;
		return 0;
	}
}
