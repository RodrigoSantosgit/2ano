package aula4.ex2;

public class Circulo extends Figura{

	private double raio;

	public Circulo(Ponto centro, double raio) {
		super(centro);
		this.raio = raio;
	}
	
	public Circulo (double x, double y, double raio) {
		this(new Ponto(x, y), raio);
	}

	public Circulo(double raio) {
		this(new Ponto(0,0), raio);
	}
	
	public Circulo(Circulo c) {
		this(c.getCentro(), c.getRaio());
	}
	
	public double getRaio() {
		return raio;
	}

	public void setRaio(double raio) {
		this.raio = raio;
	}
	
	@Override
	public double getArea() {
		return Math.PI * Math.pow(raio, 2);
	}
	
	@Override
	public double getPerimetro() {
		return Math.PI * 2 * raio;
	}

	@Override
	public String toString() {
		return "Circulo com centro em " + this.getCentro().toString() + " e raio = " + raio;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Circulo other = (Circulo) obj;
		if (Double.doubleToLongBits(raio) != Double.doubleToLongBits(other.raio))
			return false;
		return true;
	}
}
