package aula13.ex2;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class PairCounter {

	private Map<String, Map<String, Integer>> pairs = new TreeMap<>();
	
	public PairCounter(String path) throws IOException {
		loadPairs(path);	
	}
	
	private void loadPairs(String path) throws IOException {
		
		List<String> lines = Files.readAllLines(Paths.get(path), StandardCharsets.ISO_8859_1);
		String[] words;
		for(String line: lines) {
			words = line.split("[-|\t|\n| |.|,|:|'|,|;|?|!|*|{|}|=|+|&|/|(|)|[|]|\"|'|“|”|‘|’]");
			for(int i = 0; i < words.length - 1; i++) {
				String firstWord = words[i];
				String secondWord = words[i+1];
				if(pairs.containsKey(firstWord)) {
					Map<String, Integer> numbers = pairs.get(firstWord);
					if(numbers.containsKey(secondWord))
						numbers.put(secondWord, numbers.get(secondWord)+1);
					else
						numbers.put(secondWord, 1);
				}
				else {
					Map<String,Integer> wordPairs = new TreeMap<>();
					wordPairs.put(secondWord,1);
					pairs.put(firstWord, wordPairs);
				}
			}
		}
	}

	@Override
	public String toString() {
		return pairs.keySet().stream().<String>map(x -> x.concat("=").concat(pairs.get(x).toString())).collect(Collectors.joining("\n"));
	}
	
	
	
}
