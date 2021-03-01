package aula1;

public class Lista {

	private Pessoa[] list;
	private int Size;
	private int numPessoas;
	
	
	public Lista(int Size) {
		
		list = new Pessoa[Size];
		this.Size = Size;
		numPessoas = 0;
	}
	
	public void add (Pessoa p) {
		if(full()) 
			expandir();
		list[numPessoas] = p;
		numPessoas++;
	}
	
	public boolean remove (int num) {
		int index = search(num);
		
		if (index == -1) return false;
		
		list[index] = null;
		
		System.arraycopy(list, index+1, list, index, numPessoas - index);
		
		numPessoas--;
		
		return true;
		
	}
	
	public void ordenarNum() {
		ordenarNum(0, numPessoas);
	}
	
	public void ordenarNome() {
		ordenarNome(0, numPessoas);
	}
	
	private boolean full() {
		return numPessoas == list.length;
	}
	
	private void expandir() {
		int listLength = list.length;
		Pessoa[] newList = new Pessoa[listLength + Size];
		System.arraycopy(list, 0, newList, 0, listLength);
	}
	
	private int search(int num) {
		for (int i = 0; i < numPessoas; i++) {
			if (list[i].getNumCC() == num) return i;  
		}
		return -1;
	}
	
	private void ordenarNum (int start, int end) {
		assert 0<=start && start<=end && end<=list.length;

		int j = end;
		boolean existTroca;
		do {
			existTroca = false;
			for(int i = start; i < j-1 ; i++) {
				if (list[i].getNumCC() > list[i+1].getNumCC()) {
					trocar(i, i+1);
					existTroca = true;
				}
			}
			j--;
		} while (j>start+1 && existTroca);
	}
	
	private void ordenarNome (int start, int end){
		assert 0 <= start && start <= end && end <= list.length;

		int j = end;
		boolean existTroca;
		do {
			existTroca = false;
			for(int i = start; i < j-1 ; i++) {
				if (list[i].getNome().compareTo(list[i+1].getNome()) > 0) {
					trocar(i, i+1);
					existTroca = true;
				}
			}
			j--;
		} while (j>start+1 && existTroca);
	}
	
	private void trocar(int i, int j){
		assert 0 <= i && i < list.length;
		assert 0 <= j && j < list.length;

		Pessoa temp = list[i];
		list[i] = list[j];
		list[j] = temp;
	}
	
	public String toString () {
		String s = "";
		
		for (int i = 0; i < numPessoas; i++){
			s += list[i] + "\n";
		}
		return s;
	}
}
