package aula13.ex3;

import java.util.HashMap;
import java.util.Map;

public class ContadorNomes {

	private Map<String, Integer> contador = new HashMap<>();
	
	public void addNome(String nome) {
		if(contador.containsKey(nome))
			contador.put(nome, contador.get(nome) + 1);
		else
			contador.put(nome, 1);
	}
	
	public boolean removeNome(String nome) {
		if(contador.containsKey(nome)) {
			int contagem = contador.get(nome) - 1;
			if(contagem == 0) {
				contador.remove(nome);
				return true;
			}
			contador.put(nome, contagem);
			return true;
		}
		return false;
	}
	
	public int getCount(String nome) {
		return contador.get(nome);
	}
	
}
