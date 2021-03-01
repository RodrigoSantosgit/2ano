package aula7;

public class AtrasosCompanhia {

	private int totalatraso;
	private int numVoos;
	private int atrasomedio;
	private String companhia;
	
	public AtrasosCompanhia(String companhia) {
		this.totalatraso = 0;
		this.numVoos = 0;
		this.atrasomedio =0;
		this.companhia = companhia;
	}
	
	public void addAtraso(Hora atraso) {
		totalatraso += atraso.toMinutos();
		numVoos++;
		atrasomedio = totalatraso/numVoos;
	}

	public int getTotalatraso() {
		return totalatraso;
	}

	public int getNumVoos() {
		return numVoos;
	}

	public int getAtrasomedio() {
		return atrasomedio;
	}

	public String getCompanhia() {
		return companhia;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + atrasomedio;
		result = prime * result + ((companhia == null) ? 0 : companhia.hashCode());
		result = prime * result + numVoos;
		result = prime * result + totalatraso;
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
		AtrasosCompanhia other = (AtrasosCompanhia) obj;
		if (atrasomedio != other.atrasomedio)
			return false;
		if (companhia == null) {
			if (other.companhia != null)
				return false;
		} else if (!companhia.equals(other.companhia))
			return false;
		if (numVoos != other.numVoos)
			return false;
		if (totalatraso != other.totalatraso)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "AtrasosCompanhia [totalatraso=" + totalatraso + ", numVoos=" + numVoos + ", atrasomedio=" + atrasomedio
				+ ", companhia=" + companhia + "]";
	}
	
	
	
}
