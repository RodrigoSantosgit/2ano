package aula4.ex3;

public class Student extends Partner{
	
	private int numMec;
	private String course;
	
	public Student(String nome, int numcc, Data dataNasc, Data enrDate, int numMec, String course) {
		super(nome, numcc, dataNasc, enrDate);
		this.numMec = numMec;
		this.course = course;
	}

	public int getNumMec() {
		return numMec;
	}

	public String getCourse() {
		return course;
	}

	@Override
	public String toString() {
		return "Student [numMec = " + numMec + ", course = " + course + "]";
	}
}
