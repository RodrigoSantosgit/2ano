package aula13.ex1;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Pais {

	private final String nome;
	private Localidade capital;
	private List<Regiao> regioes = new ArrayList<>();
	
	public Pais(String nome) {
		this.nome = nome;
	}
	
	public Pais(String nome, Localidade capital) {
		if (capital.tipo() != TipoLocalidade.CIDADE) 
			throw new IllegalArgumentException("Capital Inválida");
		this.nome = nome;
		this.capital = capital;
	}
	
	public void addRegiao(Regiao regiao) {
		regioes.add(regiao);
	}
	
	public int populacaoTotal() {
		return regioes.stream().collect(Collectors.summingInt(Regiao::populacao));
	}

	public Localidade getCapital() {
		return capital;
	}

	public void setCapital(Localidade capital) {
		this.capital = capital;
	}

	public String getNome() {
		return nome;
	}

	public List<Regiao> getRegioes() {
		return regioes;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((capital == null) ? 0 : capital.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((regioes == null) ? 0 : regioes.hashCode());
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
		Pais other = (Pais) obj;
		if (capital == null) {
			if (other.capital != null)
				return false;
		} else if (!capital.equals(other.capital))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (regioes == null) {
			if (other.regioes != null)
				return false;
		} else if (!regioes.equals(other.regioes))
			return false;
		return true;
	}

	@Override
	public String toString() {
		if(capital!=null)
			return "Pais: " + nome + ", População: " + populacaoTotal() + "(Capital: " + capital + ")";
		else
			return "Pais: " + nome + ", População: " + populacaoTotal() + "(Capital: *Indefinida*)";
	}
	
	
	
}
