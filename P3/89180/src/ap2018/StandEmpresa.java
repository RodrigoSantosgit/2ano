package ap2018;

import java.util.LinkedList;
import java.util.List;

public class StandEmpresa extends Stand{

	private List<Participante> membros;
	
	
	public StandEmpresa(String codigo, String nome, Participante responsavel) {
		super(codigo, nome, responsavel);
		membros = new LinkedList<>();
	}
	
	public StandEmpresa(String codigo, String nome, Participante responsavel, List<Participante> list) {
		super(codigo, nome, responsavel);
		membros = list;
	}


	@Override
	public String toString() {
		return "StandEmpresa [membros=" + membros + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((membros == null) ? 0 : membros.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		StandEmpresa other = (StandEmpresa) obj;
		if (membros == null) {
			if (other.membros != null)
				return false;
		} else if (!membros.equals(other.membros))
			return false;
		return true;
	}

	public void add(Participante p) {
		membros.add(p);
	}
	
	public List<Participante> membros(){
		return membros;
	}
	
	
}
