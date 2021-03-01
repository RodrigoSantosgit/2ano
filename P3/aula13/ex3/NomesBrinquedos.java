package aula13.ex3;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class NomesBrinquedos {

	private String nomeBrinq;
	private List<String> brinquedos;
	
	public NomesBrinquedos(String nome) {
		setNomeBrinq(nome);
		brinquedos = new LinkedList<>();
	}

	public boolean addBrinquedo(String brinq) {
		return brinquedos.add(brinq);
	}
	
	public void setNomeBrinq(String nome) {
		nomeBrinq = nome.split(" ")[0];
	}

	public boolean removeBrinquedo(String brinq) {
		return brinquedos.remove(brinq);
	}

	@Override
	public String toString() {
		return brinquedos.stream().<String>map(x -> nomeBrinq.concat(" "+x)).collect(Collectors.toList()).toString();
	}
	
}