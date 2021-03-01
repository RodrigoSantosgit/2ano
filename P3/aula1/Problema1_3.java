package aula1;

import java.util.Scanner;

public class Problema1_3 {
	
	public static void main(String[] args) {
		
		Scanner op = new Scanner(System.in);
		int option = 0;
		
		System.out.println("Figuras: ");
		System.out.println("\t1. Quadrado");
		System.out.println("\t2. Rectangulo");
		System.out.println("\t3. Circulo");
		
		option = op.nextInt();
		
		switch (option) {
			case 1:
				System.out.println("Lado: ");
				double lado = op.nextDouble();
				Quadrado q = new Quadrado(lado);
				System.out.println("Area: " + q.area());
				System.out.println("Perimetro: " + q.perimetro());
				break;
			case 2: 
				System.out.println("Largura: ");
				double l = op.nextDouble();
				System.out.println("Comprimento: ");
				double c = op.nextDouble();
				Rectangulo r = new Rectangulo(c, l);
				System.out.println("Area: " + r.area());
				System.out.println("Perimetro: " + r.perimetro());
				break;
			case 3:
				System.out.println("Raio: ");
				double raio = op.nextDouble();
				System.out.println("Centro (x): ");
				double x = op.nextDouble();
				System.out.println("y: ");
				double y = op.nextDouble();
				Circulo cir = new Circulo(x, y, raio);
				System.out.println("Area: " + cir.area());
				System.out.println("Perimetro: " + cir.perimetro());
				
				System.out.println("\n1. Verificar intersecao com outro circulo");
				System.out.println("2. Verificar igualdade com outro circulo");
				int option2 = op.nextInt();
				
				switch (option2) {
					case 1:
						System.out.println("Raio 2: ");
						double raio2 = op.nextDouble();
						System.out.println("Centro (x2): ");
						double x2 = op.nextDouble();
						System.out.println("y2: ");
						double y2 = op.nextDouble();
						Circulo cir2 = new Circulo(x2, y2, raio2);
						
						System.out.println("Intersecao: " + cir.intersecao(cir2));
						break;
					case 2:
						System.out.println("Raio 2: ");
						double r3 = op.nextDouble();
						System.out.println("Centro (x2): ");
						double x3 = op.nextDouble();
						System.out.println("y2: ");
						double y3 = op.nextDouble();
						Circulo cir3 = new Circulo(x3, y3, r3);
						
						System.out.println("Igualdade: " + cir.equals(cir3));
						break;
					default:
						System.out.println("Opcao invalida");
						break;
				}
				break;
			default:
				System.out.println("Opcao invalida");
				break;
		}
		
		op.close();
	}
}
