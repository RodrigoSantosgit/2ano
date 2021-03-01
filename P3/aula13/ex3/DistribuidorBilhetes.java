package aula13.ex3;

import java.util.LinkedList;
import java.util.List;

public class DistribuidorBilhetes {

	private static int index=0;
	private String[] funcionarios;
	private List<String> bilhetes;
	
	public DistribuidorBilhetes(String[] funcionarios) {
		this.funcionarios = funcionarios;
	}
	
	public List<String> darBilhete(int numBilhetes) {
		bilhetes = new LinkedList<String>();
		for(int i = 0; i< numBilhetes; i++) {
			bilhetes.add(funcionarios[index++]);
			if(index==funcionarios.length)
				index = 0;
		}
		return bilhetes;
		
	}
}
