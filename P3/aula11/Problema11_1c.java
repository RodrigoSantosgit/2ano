package aula11;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class Problema11_1c {

	public static void main(String[] args) throws IOException {
		
		HashMap<String, Integer> words = new HashMap<>();
		
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
		
		Iterator<String> it = words.keySet().iterator();
		
		while(it.hasNext()) {
			String s = it.next();
			System.out.println(s + ": " + words.get(s));
		}
	}
	
}
