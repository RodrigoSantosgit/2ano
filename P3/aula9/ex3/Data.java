package aula9.ex3;

import java.util.Calendar;

public class Data {

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ano;
		result = prime * result + dia;
		result = prime * result + mes;
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
		Data other = (Data) obj;
		if (ano != other.ano)
			return false;
		if (dia != other.dia)
			return false;
		if (mes != other.mes)
			return false;
		return true;
	}

	private int dia, mes, ano;
	
	public Data(int dia, int mes, int ano) {
		if(dataValida(dia , mes, ano)) {
			this.dia = dia;
			this.mes = mes;
			this.ano = ano;
		}
		
	}
	
	public static Data today() {
		Calendar today = Calendar.getInstance();
		return new Data(today.get(Calendar.DAY_OF_MONTH), today.get(Calendar.MONTH)+1, today.get(Calendar.YEAR));
	}
	
	public boolean dataValida(int dia, int mes, int ano) {
		return (dia >= 1 && dia <= numDias(mes, ano)) && (mes >= 1 && mes <= 12);
		
	}
	
	public int numDias(int mes, int ano) {
		int dias = 31;
		
		if(mes == 2)
			if(anoBissexto())
				dias = 29;
			else
				dias = 28;
		
		else if(mes == 4 || mes==6 || mes==9 || mes==11)
			dias=30;
		
		return dias;
	}
	
	public boolean anoBissexto() {
		return (ano % 400 == 0) || (ano % 4 ==0 && ano % 100 !=0);
	}
	
	public int getDia() {
		return dia;
	}
	
	public int getMes() {
		return mes;
	}
	
	public int getAno() {
		return ano;
	}
	
	public String toString() {
		return dia + " - " + mes + " - " + ano;
	}
}
