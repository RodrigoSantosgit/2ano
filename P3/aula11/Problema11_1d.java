package aula11;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.TreeMap;

public class Problema11_1d {

	public static void main(String[] args) throws IOException {
		
		TreeMap<String, Integer> words = new TreeMap<>();
		
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
		
		Comparator<? super String> comp =  new Comparator<String>() {
			@Override
			public int compare(String arg0, String arg1) {
				return arg0.compareTo(arg1);
			}
		};
		
		Iterator<String> it = words.keySet().iterator();
		list.removeAll(list);
		
		for(String s: words.keySet()) {
			String s1 = it.next();
			if(comp.compare(s, s1)==1){
				if(!list.contains(s1))
					list.add(s1);
				if(!list.contains(s))
					list.add(s);
			}
			else {
				if (!list.contains(s))
					list.add(s);
				if(!list.contains(s1))
					list.add(s1);
			}
				
		}
		
		it = list.iterator();
		
		while(it.hasNext()) {
			String s = it.next();
			System.out.println(s + ": " + words.get(s));
		}
	}

	
}
