package aula1;

public class Quadrado {
	
	private double lado;
	
	public Quadrado(double l) {
		
		this.lado= l;
		
	}
	
	public double getLado() {
		return lado;
	}
	
	public double area() {
		return lado * lado;
	}
	
	public double perimetro() {
		return lado * 4;
	}

	public String toString() {
		return "Quadrado [lado = " + lado + "]";
	}
}
