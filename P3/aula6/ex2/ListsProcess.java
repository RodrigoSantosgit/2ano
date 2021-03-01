package aula6.ex2;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class ListsProcess {

	public static <T> List<T> filter(List<T> lista, Predicate<T> filter) {
		List<T> filtered = new ArrayList<T>();
		for(T t : lista) {
			if(filter.test(t))
				filtered.add(t);
		}
		return filtered;
	}
	
}
