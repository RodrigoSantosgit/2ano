package aula10;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class VectorGeneric<T> {

	private T[] vectorGeneric;
	private int size;
	
	public VectorGeneric() {
		this.vectorGeneric = (T[]) new Object[1];
		this.size = 0;
	}
	
	public boolean addElem(T t) {
		if(size==0) {
			vectorGeneric[0]=t;
			size++;
			return true;
		}
		T[] aux = (T[]) new Object[++size];
		System.arraycopy(vectorGeneric, 0, aux, 0, vectorGeneric.length);
		aux[size-1]= t;
		vectorGeneric = aux;
		return true;
	}
	
	public boolean removeElem(T t) {
		T[] aux = (T[]) new Object[--size];
		for(int i = 0; i < vectorGeneric.length; i++) {
			if(!vectorGeneric[i].equals(t))
				aux[i]= vectorGeneric[i];
		}
		vectorGeneric = aux;
		return true;
	}
	
	public int totalElem() {
		return size;
	}
	
	public Iterator iterador() {
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
		result = prime * result + Arrays.deepHashCode(vectorGeneric);
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
		VectorGeneric other = (VectorGeneric) obj;
		if (size != other.size)
			return false;
		if (!Arrays.deepEquals(vectorGeneric, other.vectorGeneric))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Vector Pessoas [Vector Pessoas = " + Arrays.toString(vectorGeneric) + ", size = " + size + "]";
	}

	private class VectorIterator implements Iterator{

		private int ponteiro = 0;
		
		@Override
		public boolean hasNext() {
			if(ponteiro < size)
				return true;
			return false;
		}
		
		public void remove() {
			if(ponteiro == 0)
				removeElem(vectorGeneric[0]);
			else
				removeElem(vectorGeneric[ponteiro-1]);
		}
		
		@Override
		public Object next() {
			int i = ponteiro;
			if (i >= size)
				throw new NoSuchElementException();
			ponteiro = i + 1;
			return (T) vectorGeneric[i];
		}
		
	}
	
	private class VectorBFIterator implements BFIterator{

		private int ponteiro = 0;
		@Override
		public boolean hasPrevious() {
			return ponteiro >= 0;
		}

		@Override
		public Object previous() {
			int i = ponteiro;
			if (i == 0)
				throw new NoSuchElementException();
			ponteiro = i - 1;
			return (T) vectorGeneric[i];
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
			return (T) vectorGeneric[i];
		}
	}
}
