package MPEI_Proj;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class TestContadorEstoc {

	public static void main(String args[])throws IOException {
		
		// colocar localização correta de phone_dataset.csv:
		String p = "C:\\Users\\Utilizador\\Desktop\\P3\\MPEI_Proj\\src\\MPEI_Proj\\phone_dataset.csv";
		Path path = Paths.get(p);
		ContadorEstocastico ce = new ContadorEstocastico(0.25,path);
		
		System.out.println(ce.toString());
		System.out.println("> Contagem [Texto1]: " + ce.getCounter() + " elementos");
		System.out.println("> Numero Elementos Estimado [Texto1]: " + ce.getFinalCount() + " elementos");
		System.out.println("> Numero Elementos Real [Texto1]: " + ce.getRealCount() + " elementos");
		System.out.println("> Erro de Contagem [Texto1]: " + (ce.getRealCount()-ce.getFinalCount()) + " elementos");
		
		System.out.println();
		
		// colocar localização correta de pg26017.txt:
		ContadorEstocastico ce2 = new ContadorEstocastico(0.5,
				"C:\\Users\\Utilizador\\Desktop\\P3\\MPEI_Proj\\src\\MPEI_Proj\\pg26017.txt");
		
		System.out.println(ce2.toString());
		System.out.println("> Contagem [Texto2]: " + ce2.getCounter() + " elementos");
		System.out.println("> Numero Elementos Estimado [Texto2]: " + ce2.getFinalCount() + " elementos");
		System.out.println("> Numero Elementos Real [Texto2]: " + ce2.getRealCount() + " elementos");
		System.out.println("> Erro de Contagem [Texto2]: " + (ce2.getRealCount()-ce2.getFinalCount()) + " elementos");
	
	}
	
}