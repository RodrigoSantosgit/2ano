package aula10.ex2;

import java.util.Iterator;

import aula10.ex1.Quadrado;

public class TesteBinarySearchTree {

	public static void main(String[] args) {
		
		BinarySearchTree<Quadrado> tree = new BinarySearchTree<>();
		
		Quadrado q1 = new Quadrado(8);
		Quadrado q2 = new Quadrado(15);
		Quadrado q3 = new Quadrado(2,3,26);
		Quadrado q4 = new Quadrado(6,7,19.4);
		Quadrado q5 = new Quadrado(4,0,15.9);
		Quadrado q6 = new Quadrado(4.5,2,2.2);
		Quadrado q7 = new Quadrado(13.2);
		
		tree.insert(q1);
		tree.insert(q3);
		tree.insert(q6);
		tree.insert(q5);
		tree.insert(q4);
		
		System.out.println("A arvore binaria " + (tree.contains(q1) ? "contem" : "não contem") + " o elemento"); //V
		System.out.println("A arvore binaria " + (tree.contains(q6) ? "contem" : "não contem") + " o elemento"); //V
		System.out.println("A arvore binaria " + (tree.contains(q3) ? "contem" : "não contem") + " o elemento"); //V
		System.out.println("A arvore binaria " + (tree.contains(q7) ? "contem" : "não contem") + " o elemento"); //F
		System.out.println("A arvore binaria " + (tree.contains(q2) ? "contem" : "não contem") + " o elemento"); //F
		
		Iterator<Quadrado> it = tree.iterator();
		
		System.out.println();
		
		while(it.hasNext()) {
			System.out.println(it.next());
		}	
	}	
}