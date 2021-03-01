package aula5;

public class UtilCompare {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static Comparable findMax(Comparable[] obj) {
		int max=0;
		for(int i=0; i<obj.length; i++) {
			if(obj[max].compareTo(obj[i])<0)
				max = i;
		}
		return obj[max];
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void sortArray(Comparable[] obj) {
		for(int i=0; i<obj.length-1; i++) {
			for(int j=i+1; j<obj.length; j++)
				if(obj[i].compareTo(obj[j])>0)
					swap(obj, i, j);
		}
	}
	
	@SuppressWarnings("rawtypes")
	private static void swap(Comparable[] obj, int ind1, int ind2) {
		Comparable aux;
		aux = obj[ind1];
		obj[ind1] = obj[ind2];
		obj[ind2] = aux;
	}
	
}
