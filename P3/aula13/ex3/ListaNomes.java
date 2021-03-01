package aula13.ex3;

import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class ListaNomes {

	private final Set<String> nomes = new TreeSet<>();
	
	public boolean addFuncionario(String nome) {
		return nomes.add(nome);
	}
	
	public boolean removeFunc(String nome) {
		return nomes.remove(nome);
	}
	
	@Override
	public String toString() {
		return nomes.stream().collect(Collectors.joining("\n"));
	}
	
}
