package MPEI_Proj;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class TesteGlobal {

	
	public static void main(String args[])throws IOException {
		
		Scanner read = new Scanner(System.in);
		// colocar localização correta phone_dataset:
		String p = "C:\\Users\\Utilizador\\Desktop\\P3\\MPEI_Proj\\src\\MPEI_Proj\\phone_dataset.csv";
		Path pathTo = Paths.get(p);
		ContadorEstocastico ce = new ContadorEstocastico(0.5, pathTo.toAbsolutePath());
	
		CountingBloomFilter cbf = new CountingBloomFilter(ce.getFinalCount(), 0.05);
		String modelo = "";
		
		while(!modelo.toUpperCase().equals("EXIT")){
			System.out.println("\n>> Introduza Modelo de Telemóvel/Especificações a procurar:");
			modelo = read.nextLine();
			String[] specsToLook = modelo.split(",");
			
			switch (specsToLook.length) {
				case 0:
					System.err.println("ERRO: Input Inválido");
					break;
					
				case 1:
					if(modelo.toUpperCase().equals("EXIT"))
						break;
					
					System.out.println("A procurar Modelo...");
				
					File fic = new File(p);
					Scanner readFile = new Scanner(fic);
					
					@SuppressWarnings("unused") String specs = readFile.nextLine();
					
					while(readFile.hasNextLine()) {
						String elems[] = readFile.nextLine().split(",");
						cbf.insert(elems[1].toUpperCase());
					}
					
					if(cbf.contains(modelo.toUpperCase()))
						System.out.printf("Telemóvel: %s -> pertence á Base de Dados \n", modelo);
					else
						System.out.printf("Telemóvel: %s -> não pertence á Base de Dados \n", modelo);
					break;
					
				default:
					System.out.println("A procurar telemóveis similares...");
					
					List<String> phones = Files.readAllLines(Paths.get(p));
				
					List<String> dados = new ArrayList<>();
					
					int i=1;
					for(String line : phones) {
						if(i==1) {
							i++;
						}
						else {
							String[] spec = line.split(",");
							String spec2 = spec[0]+","+spec[1]+","+spec[16]	//0-Brand, 1-Model, 16-Disp.Size, 18-OS, 19-CPU
									+","+spec[18]+","+spec[19]+","+spec[23] //23-Int.memory, 24-RAM, 25-Prim.Cam, 26-Sec.Cam				
									+","+spec[24]+","+spec[25]+","+spec[26]
									+","+spec[36]+","+spec[37];				//36-Battery,37-color
							dados.add(spec2);
							i++; 
						}
					
					}
					i=i-1;
					
					Set<String> set1 = new HashSet<String>();
					
					for (int k = 0; k < specsToLook.length; k++)
						set1.add(specsToLook[k].toUpperCase());
					
					LinkedList<String> list = new LinkedList<String>();
					
					int index=0;
					int count=0;
					while(index< dados.size()) {
						Set<String> set2 = new HashSet<String>();
						String[] x = dados.get(index).split(",");
						for(int t=0; t < x.length; t++) {
							set2.add(x[t].toUpperCase());
						}
						
						SimilarityFinder sf = new SimilarityFinder(set1.size() + set2.size());
						if(sf.getSimilarity(set1, set2) > 0.5){
							count++;
							list.add(x[0] + ": " + x[1]);
						}
						set2=null;
						index++;
					}
					System.out.println("Número de telemóveis similares na base de dados: " + count);
					for(String item : list) {
						System.out.println(item);
					}
					break;
			}
		}
		
		System.out.println("Terminando...");
		
		read.close();
	}
		
}