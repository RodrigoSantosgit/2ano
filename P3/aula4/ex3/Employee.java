package aula4.ex3;

public class Employee extends Partner{

	private int numEmp, nif;

	public Employee(String nome, int numcc, Data dataNasc, Data enrDate, int numEmp, int nif) {
		super(nome, numcc, dataNasc, enrDate);
		this.numEmp = numEmp;
		this.nif = nif;
	}

	public int getNumEmp() {
		return numEmp;
	}

	public int getNif() {
		return nif;
	}

	@Override
	public String toString() {
		return "Employee [numEmp = " + numEmp + ", nif = " + nif + "]";
	}
}
