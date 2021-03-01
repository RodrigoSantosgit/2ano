package aula2;

import java.io.*;
import java.util.*;


public class SopaDeLetras {
	
	private char[][] sopa;
	private LinkedList<String> palavras;
	
	public SopaDeLetras(String f) {
		readfile(f);
	}
	
	
	private void readfile(String f) {
		
		File file = new File(f);

		try {
			
			// Ler palavras a procurar:
			
			Scanner read = new Scanner(file);
			int numChars = 0;
			palavras = new LinkedList<>();
		
			while (read.hasNextLine()) {
				String line = read.nextLine();
				if (line.toUpperCase().equals(line))
					numChars = line.length();
				else {
					String[] words = line.split(", |; | ");
					for (int i=0; i< words.length; i++)
						palavras.add(words[i]);
				}
			}
			
			// Ler Sopa de Letras:
			
			sopa = new char[numChars][numChars];
			read.close();
			
			read = new Scanner(file);
			int numLine = 0;

			while(read.hasNextLine()) {
				String line = read.nextLine();
				if (line.toUpperCase().equals(line)) {
					for (int i = 0; i < numChars; i++) {
						sopa[numLine][i] = line.charAt(i);
					}
					numLine++;
				}
			}
			
			read.close();
			
		}catch(FileNotFoundException e) {
			System.err.println("ERROR: File not found!");
		}
	}
	
	private String procurarPalavra(String word, String currentWord, int line, int col, int incrementLine, int incrementCol){
		
		if(line + incrementLine < 0 || col + incrementCol < 0 || line + incrementLine > sopa.length - 1 || col + incrementCol > sopa.length - 1)
			return "";
		if(currentWord.equals(word)) 
			return currentWord;
		if(!currentWord.equals(word.substring(0, currentWord.length()))) 
			return "";
		
		currentWord += sopa[line + incrementLine][col + incrementCol];
		
		return procurarPalavra(word, currentWord, line + incrementLine, col + incrementCol, incrementLine, incrementCol);
	}
	
	private boolean procurarPalavra(String word, String currentWord, int line, int col,String direction){
		switch (direction.toLowerCase()){
			case "up":		
				return procurarPalavra(word, currentWord, line, col, -1,  0).equals(word);
			case "down":		
				return procurarPalavra(word, currentWord, line, col,  1,  0).equals(word);
			case "left":		
				return procurarPalavra(word, currentWord, line, col,  0, -1).equals(word);
			case "right":					
				return procurarPalavra(word, currentWord, line, col,  0,  1).equals(word);
			case "upleft":		
				return procurarPalavra(word, currentWord, line, col, -1, -1).equals(word);
			case "downleft":	
				return procurarPalavra(word, currentWord, line, col,  1, -1).equals(word);
			case "upright":		
				return procurarPalavra(word, currentWord, line, col, -1,  1).equals(word);
			case "downright":		
				return procurarPalavra(word, currentWord, line, col,  1,  1).equals(word);
			default:
				System.out.println("Invalid Direction!");
				break;
		}
		return false;
	}
	
	public void resolver() {
		for (String word: palavras) {
			System.out.println(word.toUpperCase() + "  " + resolver(word.toUpperCase()));
		}
	}
	
	private String resolver(String word) {
		
		String[] diretion = {"up", "down", "left", "right", "upleft", "downleft", "upright", "downright"};
		
		for (int i = 0; i < sopa.length; i++) {
			for (int j = 0; j < sopa.length; j++) {
				if (sopa[i][j] == word.charAt(0)){
					for (int k = 0; k < diretion.length; k ++) {
						if (procurarPalavra(word.toUpperCase(), String.valueOf(sopa[i][j]), i, j, diretion[k])) {
							return (i+1) + "," + (j+1) + " " + diretion[k];
						}
					}
				}
			}
		}
		return "";
		
	}
}
