package aula13.ex1.alinea_e;

public class Aldeia extends Localidade{

	public Aldeia(String nome, int populacao) {
		super(nome, populacao);
	}

	@Override
	public String toString() {
		return "Aldeia "+super.toString();
	}
	
}
