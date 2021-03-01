package aula13.ex2;

import java.io.FileWriter;
import java.io.IOException;

public class TestePairCounter {

	public static void main(String[] args) throws IOException {
		
		String filepath = "C:\\Users\\Utilizador\\Desktop\\P3\\P3\\src\\aula13\\ex2\\Policarpo.txt";
		PairCounter pairCounter = new PairCounter(filepath);
		FileWriter fw = new FileWriter("C:\\Users\\Utilizador\\Desktop\\P3\\P3\\src\\aula13\\ex2\\output.txt");
		fw.write(pairCounter.toString());
		fw.close();
		
	}
	
}
