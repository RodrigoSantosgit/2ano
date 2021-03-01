package aula1;

public class Rectangulo {

	private double comp, larg;

	public Rectangulo(double comp, double larg) {
		this.comp = comp;
		this.larg = larg;
	}

	public double getComp() {
		return comp;
	}

	public double getLarg() {
		return larg;
	}

	public String toString() {
		return "Rectangulo [comprimento = " + comp + ", largura = " + larg + "]";
	}
	
	public double area() {
		return larg * comp;
	}
	
	public double perimetro() {
		return larg * 2 + comp * 2;
	}
}
