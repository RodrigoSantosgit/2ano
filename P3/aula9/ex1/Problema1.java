package aula9.ex1;

import java.io.File;
import java.io.IOException;

public class Problema1 {

	public static void main(String[] args) throws IOException {
		
		ScannerAbeirense sa = new ScannerAbeirense(System.in);
		
		String testeTroca = sa.nextLine();
		
		System.out.println(testeTroca);
		System.out.println();
		
		//////////////////////////////////////////////
		
		File teste = new File("C:\\Users\\Utilizador\\Desktop\\P3\\P3\\src\\aula9\\ex1\\testProblema1.txt");
		
		sa = new ScannerAbeirense(teste);
		
		while(sa.hasNext()) {
			String line = sa.nextLine();
			System.out.println(line);
		}
		
		sa.close();
	}
	
}
