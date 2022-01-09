package ap2018;

public class Visitante {

	
	private static int numero=0;
	private String dataHora;

	public Visitante(String dataHora) {
		numero++;
		this.dataHora = dataHora;
	}
	
	public String getDataHora() {
		return dataHora;
	}

	public void setDataHora(String dataHora) {
		this.dataHora = dataHora;
	}

	public static int getNumero() {
		return numero;
	}

	@Override
	public String toString() {
		return "Visitante [dataHora=" + dataHora + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dataHora == null) ? 0 : dataHora.hashCode());
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
		Visitante other = (Visitante) obj;
		if (dataHora == null) {
			if (other.dataHora != null)
				return false;
		} else if (!dataHora.equals(other.dataHora))
			return false;
		return true;
	}
	
}
