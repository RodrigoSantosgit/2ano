package MPEI_Proj;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class ContadorEstocastico {
	
	private double countProb;
	private int counter=0;
	private int FinalCount;
	private int RealCount;
	
	public ContadorEstocastico(double countProb, String path) throws IOException {
		this.countProb = countProb;
		
		countElements(path);
		calculateFinalCount();
	}
	
	public ContadorEstocastico(double countProb, Path path) throws IOException {
		this.countProb = countProb;
		
		countElements(path);
		calculateFinalCount();
	}
	
	public int getCounter() {
		return counter;
	}
	
	public double getCountProb() {
		return countProb;
	}
	
	public int getFinalCount() {
		return FinalCount;
	}
	
	public int getRealCount() {
		return RealCount;
	}
	
	@SuppressWarnings("unused")
	private void countElements(String path) throws IOException {
		
		List<String> elementsList = Files.readAllLines(Paths.get(path), StandardCharsets.ISO_8859_1);
		this.RealCount = elementsList.size();
		
		double value;
		
		for (String element: elementsList) {
			value = Math.random();
			if(value<countProb)
				counter++;
		}
	}
	
	@SuppressWarnings("unused")
	private void countElements(Path path) throws IOException {
		
		List<String> elementsList = Files.readAllLines(path, StandardCharsets.ISO_8859_1);
		this.RealCount = elementsList.size();
		
		double value;
		
		for (String element: elementsList) {
			value = Math.random();
			if(value<countProb)
				counter++;
		}
	}
	
	private void calculateFinalCount() {
		FinalCount = (int) (counter * (1/countProb));
	}

	@Override
	public String toString() {
		return "Contador Estocastico [Probabilidade = " + countProb + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + FinalCount;
		long temp;
		temp = Double.doubleToLongBits(countProb);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + counter;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ContadorEstocastico other = (ContadorEstocastico) obj;
		if (FinalCount != other.FinalCount)
			return false;
		if (Double.doubleToLongBits(countProb) != Double.doubleToLongBits(other.countProb))
			return false;
		if (counter != other.counter)
			return false;
		return true;
	}
	
}
