package aula6.ex1;

import java.util.LinkedList;

public class Prato implements Comparable<Prato> {

	private String nome;
	private LinkedList<Alimento> composicao;
	private double calorias, peso, proteinas;
	
	public Prato(String nome) {
		this.nome = nome;
		this.calorias = 0;
		this.peso = 0;
		this.proteinas = 0;
		this.composicao = new LinkedList<Alimento>();
	}

	public String getNome() {
		return nome;
	}

	public LinkedList<Alimento> getComposicao() {
		return composicao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((composicao == null) ? 0 : composicao.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Prato other = (Prato) obj;
		if (composicao == null) {
			if (other.composicao != null)
				return false;
		} else if (!composicao.equals(other.composicao))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return " [nome: " + nome + ", composicao: " + composicao+"]\n";
	}
	
	public boolean addIngrediente(Alimento a) {
		calorias += a.getCalorias();
		peso += a.getPeso();
		proteinas += a.getProteinas();
		return composicao.add(a);
	}
	
	public double getCalorias() {
		return calorias;
	}
	
	public double getProteinas() {
		return proteinas;
	}
	
	public double getPeso() {
		return peso;
	}
	
	@Override
	public int compareTo(Prato p) {
		if(this.calorias<p.getCalorias())
			return -1;
		if(this.calorias>p.getCalorias())
			return 1;
		return 0;
	}
}
