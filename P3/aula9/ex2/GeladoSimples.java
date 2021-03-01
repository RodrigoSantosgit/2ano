package aula9.ex2;

public class GeladoSimples implements Gelado{

	private String sabor;
	
	public GeladoSimples(String sabor) {
		this.sabor = sabor;
	}
	
	@Override
	public void base(int b) {
		System.out.print("\n" + b + " bolas de gelado de " + sabor);
	}
	
}
