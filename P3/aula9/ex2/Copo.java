package aula9.ex2;

public class Copo extends GeladoDecorator{
	
	public Copo(Gelado g) {
		super(g);
	}
	
	public void base(int b) {
		g.base(b);
		System.out.print(" em copo");
	}
	

}
