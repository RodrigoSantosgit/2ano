package aula3.figuras;

public class Rectangulo extends Figura{

	private double larg, comp;

	public Rectangulo(Ponto centro, double larg, double comp) {
		super(centro);
		this.larg = larg;
		this.comp = comp;
	}
	
	public Rectangulo(double x, double y, double larg, double comp) {
		this(new Ponto(x,y), larg, comp);
	}

	public Rectangulo(double x, double y) {
		this(new Ponto(0,0), x, y);
	}
	
	public Rectangulo(Rectangulo r) {
		this(r.getCentro(), r.getLarg(), r.getComp());
	}
	
	public double getLarg() {
		return larg;
	}

	public void setLarg(double larg) {
		this.larg = larg;
	}

	public double getComp() {
		return comp;
	}

	public void setComp(double comp) {
		this.comp = comp;
	}
	
	@Override
	public double getArea() {
		return larg*comp;
	}
	
	@Override
	public double getPerimetro() {
		return larg * 2 + comp * 2;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Rectangulo other = (Rectangulo) obj;
		if (Double.doubleToLongBits(comp) != Double.doubleToLongBits(other.comp))
			return false;
		if (Double.doubleToLongBits(larg) != Double.doubleToLongBits(other.larg))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return super.toString() + "; Rectangulo; largura = " + larg + ", comprimento = " + comp;
	}
}
