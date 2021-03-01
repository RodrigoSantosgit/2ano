package aula7;

public class Voo {

	private Hora hora, atraso;
	private String voo, companhia, origem, obs;
	
	public Voo(Hora hora, Hora atraso, String voo, String companhia, String origem, String obs) {
		this.hora = hora;
		this.atraso = atraso;
		this.voo = voo;
		this.companhia = companhia;
		this.origem = origem;
		this.obs = obs;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((companhia == null) ? 0 : companhia.hashCode());
		result = prime * result + ((obs == null) ? 0 : obs.hashCode());
		result = prime * result + ((origem == null) ? 0 : origem.hashCode());
		result = prime * result + ((voo == null) ? 0 : voo.hashCode());
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
		Voo other = (Voo) obj;
		if (companhia == null) {
			if (other.companhia != null)
				return false;
		} else if (!companhia.equals(other.companhia))
			return false;
		if (obs == null) {
			if (other.obs != null)
				return false;
		} else if (!obs.equals(other.obs))
			return false;
		if (origem == null) {
			if (other.origem != null)
				return false;
		} else if (!origem.equals(other.origem))
			return false;
		if (voo == null) {
			if (other.voo != null)
				return false;
		} else if (!voo.equals(other.voo))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return hora + "\t" + voo + "\t" + companhia + "\t" + origem + "\t" + atraso + "\t" + obs + "\n";
	}
	public Hora getHora() {
		return hora;
	}
	public Hora getAtraso() {
		return atraso;
	}
	public String getVoo() {
		return voo;
	}
	public String getCompanhia() {
		return companhia;
	}
	public String getOrigem() {
		return origem;
	}
	public String getObs() {
		return obs;
	}
	
}
