package aula9.ex2;

public class Cone extends GeladoDecorator{
	
	public Cone(Gelado g) {
		super(g);
	}
	
	public void base(int b) {
		g.base(b);
		System.out.print(" em cone");
	}

}
