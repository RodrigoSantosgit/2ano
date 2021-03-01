package aula7;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

public class Aeroporto {

	private ArrayList<Voo> voos; 
	private Hashtable<String, String> companhias;
	private Map<String, AtrasosCompanhia> delays;
	private Hashtable<String, Integer> totalChegadas;
	
	public Aeroporto() {
		this.voos = new ArrayList<Voo>();
		this.delays = new HashMap<String, AtrasosCompanhia>();
		this.totalChegadas = new Hashtable<String, Integer>(10);
		this.companhias = new Hashtable<String,String>(10);
	}

	public Map<String, AtrasosCompanhia> getDelays() {
		return delays;
	}

	public ArrayList<Voo> getVoos() {
		return voos;
	}

	public Hashtable<String, String> getCompanhias() {
		return companhias;
	}

	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((companhias == null) ? 0 : companhias.hashCode());
		result = prime * result + ((delays == null) ? 0 : delays.hashCode());
		result = prime * result + ((totalChegadas == null) ? 0 : totalChegadas.hashCode());
		result = prime * result + ((voos == null) ? 0 : voos.hashCode());
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
		Aeroporto other = (Aeroporto) obj;
		if (companhias == null) {
			if (other.companhias != null)
				return false;
		} else if (!companhias.equals(other.companhias))
			return false;
		if (delays == null) {
			if (other.delays != null)
				return false;
		} else if (!delays.equals(other.delays))
			return false;
		if (totalChegadas == null) {
			if (other.totalChegadas != null)
				return false;
		} else if (!totalChegadas.equals(other.totalChegadas))
			return false;
		if (voos == null) {
			if (other.voos != null)
				return false;
		} else if (!voos.equals(other.voos))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Aeroporto: voos=" + voos;
	}
	
	public void lerVoos(String path) throws IOException{
		List<String> infoVoos = Files.readAllLines(Paths.get(path));
		
		for(int i = 1; i < infoVoos.size(); i++) {
			String[] info = infoVoos.get(i).split("\t");
			String[] hora = info[0].split(":");
			String[] atraso = info[3].split(":");
			Voo voo = new Voo(new Hora(Integer.parseInt(hora[0]), Integer.parseInt(hora[1])),
					new Hora(Integer.parseInt(atraso[0]), Integer.parseInt(atraso[1])),info[1], companhias.get(info[1].substring(0,1)), info[2], "");
			voos.add(voo);
			delays.get(companhias.get(info[1])).addAtraso(new Hora(Integer.parseInt(atraso[0]), Integer.parseInt(atraso[1])));
			totalChegadas.put(info[2], 1);
		}
		
	}
	
	
	public Hashtable<String, Integer> getTotalChegadas() {
		return totalChegadas;
	}

	public void printVoos(){
		System.out.println("Hora	Voo	Companhia	Origem	Atraso	Obs");
		voos.toString();
	}
	
	public void lerCompanhias(String path) throws IOException {
		
		List<String> comp = Files.readAllLines(Paths.get(path));
		
		for(int i =0; i< comp.size(); i++) {
			String[] info = comp.get(i).split("\t");
			companhias.put(info[0], info[1]);
			delays.put(info[1], new AtrasosCompanhia(info[0]));
		}
	}
	
	public void saveVoos(String path) throws IOException {
		
		Path file = Paths.get(path);

		try (BufferedWriter writer = Files.newBufferedWriter(file, StandardCharsets.UTF_8)) {
			writer.write("Hora	Voo	Companhia	Origem	Atraso	Obs\n");
			writer.write(voos.toString());
			
		} catch (IOException e) {
			System.err.println("IO Error");
		}
		
	}
	
	public void saveVoosCidade(String path) throws IOException {
		
		Path file = Paths.get(path);
		
		try (BufferedWriter writer = Files.newBufferedWriter(file, StandardCharsets.UTF_8)) {
			writer.write("Origem	Voos\n");
			for (String cidade: (String[])(totalChegadas.keySet().toArray())) {
				writer.write(cidade+ "\t" + totalChegadas.get(cidade));
			}
			
		} catch (IOException e) {
			System.err.println("IO Error");
		}
		
		
	}
	
	public void printAtrasosCompanhia() {
		
		System.out.println("Companhia	Atraso Medio");
		Collection<String> c = companhias.values();
		
		for (String comp : c) {
			System.out.println(comp + delays.get(comp).getAtrasomedio());
		}
	}
	
}
