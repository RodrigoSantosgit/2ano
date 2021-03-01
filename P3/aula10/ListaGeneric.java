package aula10;

import java.util.*;

public class ListaGeneric<T> {
	
	private List<T> elems = new LinkedList<>();
	
	public boolean addElem(T t) {
		return elems.add(t);
	}
	
	public boolean removeElems(T t) {
		return elems.remove(t);
	}
	
	public int size() {
		return elems.size();
	}
	
	public Iterator iterator() {
		return elems.iterator();
	}
	
}