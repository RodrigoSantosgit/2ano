package aula1;

public class Circulo {
	
	private double raio;
	private Ponto centro;
	
	public Circulo(double r, Ponto c) {
		this.centro= c;
		this.raio= r;
	}
	
	public Circulo(double x, double y, double r) {
		this.centro= new Ponto(x, y);
		this.raio = r;
	}
	
	public String toString() {
		return "Círculo, com centro em ( " + centro.getx() + "," + centro.gety() + " )com raio = " + raio;
	}
	
	public double getRaio() {
		return raio;
	}
	
	public Ponto getCentro() {
		return centro;
	}
	
	public double area() {
		return Math.PI * ( raio * raio );
	}
	
	public double perimetro() {
		return 2 * Math.PI * raio;
	}
	
	public boolean equals (Circulo cir) {
		return this.area() == cir.area() && this.getCentro().getx()==cir.getCentro().getx() && this.getCentro().gety()==cir.getCentro().gety();
	}
	
	public boolean intersecao (Circulo circle) {
		return Math.sqrt((this.getCentro().getx()-circle.getCentro().getx())*(this.getCentro().getx()-circle.getCentro().getx()) + (this.getCentro().gety()-circle.getCentro().gety())*(this.getCentro().gety()-circle.getCentro().gety())) <= (this.getRaio() + circle.getRaio());
	}
}
