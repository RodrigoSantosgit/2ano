package aula5.ex1;

public class ColecaoFiguras {

	private Figura[] figuras;
	private double maxArea;
	private int numFig = 0;
	
	public ColecaoFiguras(double maxArea) {
		this.maxArea = maxArea;
	}
	
	public boolean addFigura(Figura f) {
		
		if (this.areaTotal() + f.getArea() > maxArea)
			return false;
		
		Figura[] tmp = new Figura[numFig+1];
		
		if(numFig == 0) {
			tmp[numFig++] = f;
			figuras = tmp;
			return true;
		}
		
		for(int i =0; i < numFig; i++) {
			if(figuras[i].equals(f))
				return false;
		}
		
		System.arraycopy(figuras, 0, tmp, 0, numFig);
		tmp[numFig] = f;
		figuras = tmp;
		numFig++;
		return true;
	}
	
	public boolean delFigura(Figura f) {
		int i;
		for(i = 0; i < numFig; i++) {
			if(figuras[i].equals(f))
				break;
		}
		if(i == numFig)
			return false;
		
		for(int j = i; j < numFig-1; j++) {
			figuras[j] = figuras[j+1];
		}
		numFig--;
		return true;
	}
	
	public double areaTotal() {
		double soma=0;
		for (int i = 0; i< numFig; i++) {
			soma += figuras[i].getArea();
		}
		return soma;
	}
	
	public boolean exists(Figura f) {
		for (int i = 0; i < numFig; i++) {
			if(figuras[i].equals(f))
				return true;
		}
		return false;
	}
	
	public Figura[] getFiguras() {
		return figuras;
	}
	
	public Ponto[] getCentros() {
		Ponto[] centros = new Ponto[numFig];
		
		for (int i = 0; i < numFig; i++) {
			centros[i] = figuras[i].getCentro();
		}
		
		return centros;	
	}

	@Override
	public String toString() {
		return "ColecaoFiguras: Area maxima = " + maxArea + ", numero de Figuras = " + numFig;
	}
	
	
}
