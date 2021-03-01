package aula9.ex2;

public class Topping extends GeladoDecorator{
	
	private final String sabor; 
	
	public Topping(Gelado g, String sabor) {
		super(g);
		this.sabor = sabor;
		
	}
	
	public void base(int b) {
		g.base(b);
		System.out.print(" com " + sabor);
	}

}
