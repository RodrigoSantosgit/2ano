package aula13.ex3;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class ListaFunc_Brinq {

	private final Map<String, List<String>> ListFunc_Brinq = new TreeMap<>();

	public void addBrinquedo(String gift, String func) {
		
		if(ListFunc_Brinq.containsKey(func)) {
			ListFunc_Brinq.get(func).add(gift);
		}else {
			List<String> newList = new LinkedList<>();
			newList.add(gift);
			ListFunc_Brinq.put(func, newList);
		}
		
	}
	
	public boolean removeBrinquedo(String func) {
		if(ListFunc_Brinq.containsKey(func)) {
			List<String> listBrinq = ListFunc_Brinq.get(func);
			listBrinq.remove(listBrinq.size()-1);
			if(listBrinq.size() == 0) 
				ListFunc_Brinq.remove(func);
			return true;
		}
		return false;
	}
	
	@Override
	public String toString() {
		return ListFunc_Brinq.keySet().stream().<String>map(x -> x.concat(" -> ")
				.concat(ListFunc_Brinq.get(x).toString()))
				.collect(Collectors.joining("\n"));
	}
	
}
