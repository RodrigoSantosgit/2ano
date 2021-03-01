package aula9.ex3;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class VectorPessoas {

	private Pessoa[] vectorPessoas;
	private int size;
	
	public VectorPessoas() {
		this.vectorPessoas = new Pessoa[1];
		this.size = 0;
	}
	
	public boolean addPessoa(Pessoa p) {
		if(size==0) {
			vectorPessoas[0]=p;
			size++;
			return true;
		}
		Pessoa[] aux = new Pessoa[++size];
		System.arraycopy(vectorPessoas, 0, aux, 0, vectorPessoas.length);
		aux[size-1]= p;
		vectorPessoas = aux;
		return true;
	}
	
	public boolean removePessoa(Pessoa p) {
		Pessoa[] aux = new Pessoa[--size];
		for(int i = 0; i < vectorPessoas.length; i++) {
			if(!vectorPessoas[i].equals(p))
				aux[i]= vectorPessoas[i];
		}
		vectorPessoas = aux;
		return true;
	}
	
	public int totalPessoas() {
		return size;
	}
	
	public Iterator<?> iterador() {
		return new VectorIterator();
	}
	
	public BFIterator bfIterator() {
		return new VectorBFIterator();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + size;
		result = prime * result + Arrays.hashCode(vectorPessoas);
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
		VectorPessoas other = (VectorPessoas) obj;
		if (size != other.size)
			return false;
		if (!Arrays.equals(vectorPessoas, other.vectorPessoas))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Vector Pessoas [Vector Pessoas = " + Arrays.toString(vectorPessoas) + ", size = " + size + "]";
	}

	private class VectorIterator implements Iterator<Object>{

		private int ponteiro = 0;
		
		@Override
		public boolean hasNext() {
			if(ponteiro < size)
				return true;
			return false;
		}
		
		public void remove() {
			if(ponteiro == 0)
				removePessoa(vectorPessoas[0]);
			else
				removePessoa(vectorPessoas[ponteiro-1]);
		}
		
		@Override
		public Object next() {
			int i = ponteiro;
			if (i >= size)
				throw new NoSuchElementException();
			ponteiro = i + 1;
			return (Pessoa) vectorPessoas[i];
		}
		
	}
	
	private class VectorBFIterator implements BFIterator{

		private int ponteiro = 0;
		@Override
		public boolean hasPrevious() {
			return ponteiro > 0;
		}

		@Override
		public Object previous() {
			int i = ponteiro;
			if (i == 0)
				throw new NoSuchElementException();
			ponteiro = i - 1;
			return (Pessoa) vectorPessoas[i];
		}

		@Override
		public boolean hasNext() {	
			if(ponteiro < size)
				return true;
			return false;
		}

		@Override
		public Object next() {
			int i = ponteiro;
			if (i >= size)
				throw new NoSuchElementException();
			ponteiro = i + 1;
			return (Pessoa) vectorPessoas[i];
		}
	}
}