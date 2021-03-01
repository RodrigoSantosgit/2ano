package aula7;

public class Hora{
	
	private int hora;
	private int minuto;
	
	public Hora(int hora, int minuto) {
		if(horaValida(hora, minuto)) {
			this.hora = hora;
			this.minuto = minuto;
		}
	}
	
	private boolean horaValida(int hora, int minuto) {
		return hora > 0 && hora < 24 && minuto > 0 && minuto <60;
	}

	@Override
	public String toString() {
		return hora + ":" + minuto;
	}

	public int getHora() {
		return hora;
	}

	public void setHora(int hora) {
		this.hora = hora;
	}

	public int getMinuto() {
		return minuto;
	}

	public void setMinuto(int minuto) {
		this.minuto = minuto;
	}
	
	public int toMinutos() {
		return this.hora * 60 + this.minuto;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + hora;
		result = prime * result + minuto;
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
		Hora other = (Hora) obj;
		if (hora != other.hora)
			return false;
		if (minuto != other.minuto)
			return false;
		return true;
	}
	
	
	
}
