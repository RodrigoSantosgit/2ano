package aula11.ex2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import aula11.utils.*;
public class Problema11_2 {

	public static void main(String[] args) throws ClassNotFoundException {
		
		List<Figura> list = new ArrayList<Figura>();
		list.add(new Circulo(1));
		list.add(new Circulo(2));
		list.add(new Quadrado(3));
		list.add(new Rectangulo(2,1));
		list.add(new Rectangulo(1,3));
		
		System.out.println("Maior figura: "+ maiorFiguraJ7(list));
		System.out.println("Figura com maior perimetro: "+ maiorPerimetroJ7(list));
		System.out.println("Area total: "+ areaTotalJ8(list));
		System.out.println("Area total dos circulos: "+ areaTotalJ8(list,"Circulo"));
	}

	private static Figura maiorFiguraJ7(List<Figura> figs) {
		return (Figura)figs.stream().max(new Comparator<Figura>() {
			@Override
			public int compare(Figura arg0, Figura arg1) {
				return arg0.compareTo(arg1);
			}
		}).get();
	}
	
	private static Figura maiorPerimetroJ7(List<Figura> figs) {
		return (Figura)figs.stream().max(new Comparator<Figura>() {
			@Override
			public int compare(Figura arg0, Figura arg1) {
				double dif = arg0.getPerimetro()-arg1.getPerimetro();
				if(dif > 0) 
					return 1;
				else if(dif < 0) 
					return -1;
				else 
					return 0;
			}
		}).get();
	}
	
	private static double areaTotalJ8(List<Figura> figs) {
		return figs.stream().mapToDouble(f -> f.getArea()).sum();
	}
	
	private static double areaTotalJ8(List<Figura> figs, String subtipoNome) throws ClassNotFoundException {
		return figs.stream()
				.filter(f -> f.getClass().getSimpleName().equals(subtipoNome))
				.mapToDouble(f -> f.getArea())
				.sum();
	}
}
