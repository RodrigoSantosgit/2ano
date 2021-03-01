package MPEI_Proj;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class TestBloomFilter {

	@SuppressWarnings("unused")
	public static void main(String[] args) throws IOException{
		
		CountingBloomFilter cbf = new CountingBloomFilter(8632, 0.05);
		
		// colocar localização correta de phone_dataset.csv:
		File fic = new File("C:\\Users\\Utilizador\\Desktop\\P3\\MPEI_Proj\\src\\MPEI_Proj\\phone_dataset.csv");
		Scanner read = new Scanner(fic);
		
		String specs = read.nextLine();
		
		while(read.hasNextLine()) {
			String elems[] = read.nextLine().split(",");
			cbf.insert(elems[0]);
		}
		
		System.out.println(cbf.toString() + ":\n");
		
		System.out.println("MarcaX pertence á Base de Dados -> " + cbf.contains("MarcaX")); // falso
		System.out.println("Samsung pertence á Base de Dados -> " + cbf.contains("Samsung")); // verdadeiro
		System.out.println("Xiaomi pertence á Base de Dados -> " + cbf.contains("Xiaomi")); // verdadeiro
		System.out.println("Huawei pertence á Base de Dados -> " + cbf.contains("Huawei")); // verdadeiro
		System.out.println("HuaweiWEI pertence á Base de Dados -> " + cbf.contains("HuaweiWEI")); // falso
		
		System.out.println();
		
		System.out.println("Numero de telémoveis da marca MarcaX: " + cbf.getCountOfElem("MarcaX")); // 0
		System.out.println("Numero de telémoveis da marca Samsung: " + cbf.getCountOfElem("Samsung")); // 1123
		System.out.println("Numero de telémoveis da marca Xiaomi: " + cbf.getCountOfElem("Xiaomi")); // 50
		System.out.println("Numero de telémoveis da marca Huawei: " + cbf.getCountOfElem("Huawei")); // 240
		System.out.println("Numero de telémoveis da marca HuaweiWEI: " + cbf.getCountOfElem("HuaweiWEI")); // 0
		
		read.close();
		
	}
	
}
