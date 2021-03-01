package MPEI_Proj;

public class CountingBloomFilter {
	
	private int m,n,k;
	private double PfalsPos;
	private int[] vetor;
	
	public CountingBloomFilter(int m, double p) {
		this.m=m; 
		this.PfalsPos=p;
		this.n=calcularN();
		this.vetor = new int[n];
		this.k = calcularK();
	}
	
	private int calcularN() {
		return (int)(((Math.log10((1/PfalsPos))/Math.log10(2)) / Math.log(2))*m);
	}
	
	private int calcularK() {
		return (int)((n/m)*Math.log(2));
	}
	
	public void insert(String s) {
		int h;
		h = hashCode(s);
		vetor[h] = vetor[h] + 1;
	}

	public boolean contains(String s) {
		int h;
		h = hashCode(s);
		if(vetor[h] == 0)
			return false;
		return true;
	}
	
	public int getCountOfElem(String s) {
		int h = hashCode(s);
		return vetor[h];
	}
	
	private int hashCode(String s) { // Universal Hashing
		int h = 5381;
		for (int i=0 ; i < s.length() ; ++i)
			h = ((h*33) + s.charAt(i)) % this.n;
		return h;
	}

	@Override
	public String toString() {
		return "Counting Bloom Filter [m = " + m + ", n = " + n + ", k = " + k 
				+ ", P(falsos Positivos)= " + PfalsPos + "]";
	}

	public int getM() {
		return m;
	}

	public int getN() {
		return n;
	}

	public int getK() {
		return k;
	}
	
	public int[] vetor() {
		return vetor;
	}

	public double getPfalsPos() {
		return PfalsPos;
	}
}