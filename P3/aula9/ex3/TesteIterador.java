package aula9.ex3;

import java.util.Iterator;

public class TesteIterador {

	public static void main(String[] args) {
		
		VectorPessoas vp = new VectorPessoas();
		
		for (int i=0; i<10; i++)
			vp.addPessoa(new Pessoa("Beb� no Vector "+i,
					1000+i, Data.today()));
		
		Iterator vec = vp.iterador();
		
		while ( vec.hasNext() )
			System.out.println( vec.next() );
		
		ListaPessoas lp = new ListaPessoas();
		
		for (int i=0; i<10; i++)
			lp.addPessoa(new Pessoa("Beb� na Lista "+i,
					2000+i, Data.today()));
		
		Iterator lista = lp.iterator();
		
		while ( lista.hasNext() )
			System.out.println( lista.next() );
		
		////////////////////////////////////////////////////
		System.out.println();
		
		VectorPessoas vp1 = new VectorPessoas();
		
		for (int i=0; i<10; i++)
			vp1.addPessoa(new Pessoa("Beb� no Vector "+i,
					1000+i, Data.today()));
		
		BFIterator vec1 = vp1.bfIterator();
		
		while ( vec1.hasNext() )
			System.out.println( vec1.next() );
		
	}
}
