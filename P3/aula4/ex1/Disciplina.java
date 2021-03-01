package aula4.ex1;

import java.util.Arrays;

public class Disciplina {

	private String nomeDis, areaCien;
	private int ects, n;
	private Professor responsavel;
	private Estudante[] alunos;
	
	public Disciplina(String nomeDis, String areaCien, int ects, Professor responsavel) {
		this.nomeDis = nomeDis;
		this.areaCien = areaCien;
		this.ects = ects;
		this.responsavel = responsavel;
		this.alunos = new Estudante[9];
		this.n = 0;
	}

	public Professor getResponsavel() {
		return responsavel;
	}

	public void setResponsavel(Professor responsavel) {
		this.responsavel = responsavel;
	}

	public String getNomeDis() {
		return nomeDis;
	}

	public String getAreaCien() {
		return areaCien;
	}

	public int getEcts() {
		return ects;
	}

	public Estudante[] getAlunos() {
		return alunos;
	}
	
	public int numAlunos() {
		return n;
	}
	
	public Estudante[] getAlunos(String tipo) {
		
		int num=0, l=0;
		
		for(int i =0; i< n ; i++) {
			if(alunos[i].getClass().getSimpleName().equals(tipo))
				num++;
		}
		
		Estudante[] aux = new Estudante[num];
		
		for(int i =0; i< n ; i++) {
			if(alunos[i].getClass().getSimpleName().equals(tipo))
				aux[l++]= alunos[i];
		}
		
		return aux;
	}
	
	public boolean addAluno(Estudante e) {
		
		Estudante[] tmp = new Estudante[n+1];
		
		if(n==0) {
			tmp[n] = e;
			n++;
			alunos = tmp;
			return true;
		}
		
		for(int i =0; i < n; i++) {
			if(alunos[i].equals(e))
				return false;
		}
		
		System.arraycopy(alunos, 0, tmp, 0, n);
		tmp[n]=e;
		alunos = tmp;
		n++;
		return true;
	}
	
	public boolean delAluno(int nMec) {
		int i;
		for(i = 0; i < n; i++) {
			if(alunos[i].getNumMec()==nMec)
				break;
		}
		if(i== n)
			return false;
		
		for(int j=i; j<n-1; j++) {
			alunos[j]=alunos[j+1];
		}
		n--;
		return true;

	}

	@Override
	public String toString() {
		return "Disciplina: " + nomeDis + ", areaCien= " + areaCien + ", ects= " + ects + "\nResponsavel: "
				+ responsavel.toString() + ", alunos= " + Arrays.toString(alunos) + "\nExistem " + 
				this.numAlunos() + " Alunos inscritos.";
	}

	public boolean alunoInscrito(int numMec) {
		for(int i = 0; i < n; i++) {
			if(alunos[i].getNumMec()==numMec)
				return true;
		}
		return false;
	}
}
