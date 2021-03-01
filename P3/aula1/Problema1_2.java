package aula1;

import java.util.Scanner;


public class Problema1_2 {
	
	public static void main(String[] args) {
		
		Lista list = new Lista(50);
		Scanner op = new Scanner(System.in);
		int option = 0;
		
		do {
			System.out.println();
			System.out.println("  -- Gestão da Lista de Pessoas : ");
			System.out.println("\t1. Adicionar Pessoa");
			System.out.println("\t2. Remover Pessoa");
			System.out.println("\t3. Imprimir Lista de Pessoas");
			System.out.println("\t4. Ordenar Lista por Nomes");
			System.out.println("\t5. Ordernar Lista por Numero de CC");
			System.out.println("\t6. Terminar");
			
		
			option = op.nextInt();
				
			switch (option) {
					case 1:
						String name = op.nextLine();
						System.out.println("Nome: ");
						name = op.nextLine();
							
						System.out.println("Numero de CC: ");
						int num = op.nextInt();
						
						String data = op.nextLine();
						System.out.println("Data de Nascimento (dd-mm-aa): ");
						data = op.nextLine();
							
						String[] comp = data.split("-");
						Data d = new Data(Integer.parseInt(comp[0]),Integer.parseInt(comp[1]),Integer.parseInt(comp[2]));
							
						list.add(new Pessoa(name, num, d));
							
						break;
							
					case 2:
							
						System.out.println("Numero de CC a remover: ");
						int numcc = op.nextInt();
							
						list.remove(numcc);
						System.out.println("Concluido ");
						break;
						
					case 3:
						System.out.print(list);
						break;
						
					case 4:
						list.ordenarNome();
						System.out.println("Concluido ");
						break;
						
					case 5:
						list.ordenarNum();
						System.out.println("Concluido ");
						break;
							
					case 6:
						break;
							
					default:
						System.err.println("Opcao invalida!");
						break;

				}
			
		} while(option!=6);
		
		op.close();
	}
}
