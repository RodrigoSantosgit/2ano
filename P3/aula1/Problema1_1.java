package aula1;

import java.util.Scanner;

public class Problema1_1 {
	
	public static void main(String[] args) {
	
		Scanner read = new Scanner(System.in);
		
		System.out.println("Introduce a String: ");
		String frase = read.nextLine();
		
		System.out.println("Count Digits: " + numDigits(frase));
		System.out.println("Only upper case: " + onlyUpperCase(frase));
		System.out.println("Only lower case: " + onlyLowerCase(frase));
		words(frase);
		System.out.println("\nSwitched chars 2 by 2: " + switchChars(frase));

		read.close();
		
	}
	
	public static int numDigits(String frase) {
		int d=0;
		
		for (int i = 0; i<frase.length(); i++) {
			if(Character.isDigit(frase.charAt(i)))
				d++;
		}
		
		return d;
	}
	
	public static boolean onlyUpperCase(String frase) {
		return frase.toUpperCase().equals(frase);
	}
	
	public static boolean onlyLowerCase(String frase) {
		return frase.toLowerCase().equals(frase);
	}
	
	public static void words(String frase) {
		String[] words = frase.split(" |\n|\t");
		System.out.print("Total words: " + words.length + "\nWords:");
		for (int i =0; i < words.length; i++) {
			System.out.print(" -" + words[i]);
		}
	}
	
	public static String switchChars(String frase) {
		
		String s = "";
		
		for (int i = 0; i < frase.length() - 1; i = i + 2) {
			s += frase.charAt(i + 1);
			s += frase.charAt(i);
		}

		if (frase.length() % 2 != 0)
			s += frase.charAt(frase.length() - 1);
		
		return s;
	}
}
