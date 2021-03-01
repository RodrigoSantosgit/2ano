package aula7;

import java.io.*;

public class Problema1 {
	
	public static void main(String[] args) throws IOException {
		
		Aeroporto ae = new Aeroporto();
		
		ae.lerCompanhias("companhias.txt");
		
		ae.lerVoos("voos.txt");
		
		ae.printVoos();
		
		ae.printAtrasosCompanhia();
		
		ae.saveVoos("Infopublico.txt");
		
		ae.saveVoosCidade("cidades.txt");
		
	}
}
