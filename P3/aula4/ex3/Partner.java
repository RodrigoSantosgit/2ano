package aula4.ex3;

public class Partner extends Pessoa{
	
private static int nextID = 0;
	
	private int id;
	private Data enrDate;
	
	public Partner(String nome, int numcc, Data dataNasc, Data enrDate) {
		super(nome, numcc, dataNasc);
		nextID++;
		this.id = nextID;
		this.enrDate = enrDate;
	}

	public int getId() {
		return id;
	}

	public Data getEnrDate() {
		return enrDate;
	}

	@Override
	public String toString() {
		return "Partner [id = " + id + ", enrDate = " + enrDate + "]";
	}
}
