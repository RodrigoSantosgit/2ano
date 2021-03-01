package aula11.utils;

public class Quadrado extends Rectangulo{

	private double lado;

	public Quadrado(Ponto centro, double lado) {
		super(centro, lado, lado);
		this.lado = lado;
	}
	
	public Quadrado(double x, double y, double lado) {
		this(new Ponto(x,y), lado);
	}
	
	public Quadrado(double lado) {
		this(new Ponto(0,0), lado);
	}
	
	public Quadrado(Quadrado q) {
		this(q.getCentro(), q.getLado());
	}
	
	@Override
	public double getArea() {
		return lado*lado;
	}
	
	@Override
	public double getPerimetro() {
		return lado * 4;
	}

	@Override
	public String toString() {
		return "Quadrado com centro em " + this.getCentro().toString() + " e lado = " + lado;
	}
	
	public void setLado(double lado) {
		this.lado = lado;
	}

	public double getLado() {
		return lado;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Quadrado other = (Quadrado) obj;
		if (Double.doubleToLongBits(lado) != Double.doubleToLongBits(other.lado))
			return false;
		return true;
	}
}
