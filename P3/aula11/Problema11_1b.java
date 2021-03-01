package aula11;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Problema11_1b {

	public static void main(String[] args) throws IOException{
		
		Map<String, Integer> words = new TreeMap<String, Integer>();
		
		List<String> list = Files.readAllLines(
				Paths.get("C:\\Users\\Utilizador\\Desktop\\P3\\P3\\src\\aula11\\testProblema1.txt"), StandardCharsets.ISO_8859_1);
		
		for(String line: list) {
			String[] lineWords = line.split(" ");
			for(int i = 0; i < lineWords.length; i++) {
				if(words.containsKey(lineWords[i].toLowerCase()))
					words.put(lineWords[i].toLowerCase(), words.get(lineWords[i].toLowerCase())+1);
				else
					words.put(lineWords[i].toLowerCase(), 1);
			}
		}
		
		int count =0;
		for(Integer n: words.values())
			count += n;
		
		System.out.println("Numero Total de palavras: " + count);
		System.out.println("Numero de palavras diferentes: " + words.size());
	}
	
}
