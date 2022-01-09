package ap2018;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Feira {

	private String nome, local;
	private List<Expositor> stands;
	private List<Visitante> visitantes;
	
	public Feira(String nome, String local) {
		this.nome = nome;
		this.local = local;
		visitantes = new LinkedList<>();
		stands = new LinkedList<>();
	}
	
	
	public String getLocal() {
		return local;
	}


	public void add(Stand s) {
		if(!stands.contains(s))
			stands.add(s);
	}
	
	public void add(Visitante v) {
		visitantes.add(v);
	}


	public String getNome() {
		return nome;
	}


	public List<String> emailsDosResponsaveis() {
		return stands.stream().map(x -> x.responsavel().getEmail()).collect(Collectors.toList());
	}


	public List<Expositor> getServico(Servico servico) {
		return stands.stream().filter(x -> x instanceof StandServicos)
				.collect(Collectors.toList()).stream()
				.filter(x -> ((StandServicos) x).getTipo().equals(Servico.RESTAURANTE))
				.collect(Collectors.toList());
				
	}


	public String visitantesEntreDatas(String dataInicio, String dataFim) {
		String[] data1 = dataInicio.split(":");
		String[] data2 = dataFim.split(":");
		
		
		
		return null;
	}


	@Override
	public String toString() {
		return "Feira [nome=" + nome + ", local=" + local + ", stands=" + stands + ", visitantes=" + visitantes + "]";
	}


	public Set<Expositor> getStandsOrderedByCodigo() {
		Collections.sort(stands, Comparator.comparing(s -> s.codigo()));
		return  stands.stream().collect(Collectors.toSet());
	}

}
