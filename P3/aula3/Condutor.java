package aula3;

import java.util.Arrays;
import java.util.LinkedList;
import aula3.veiculos.Vehicle;

public class Condutor extends Pessoa {
	
	private int n=0;
	private LinkedList<Vehicle> vehicles;
	private char[] licencas;
	
	public Condutor(String nome, int numcc, Data dataNasc) {
		super(nome, numcc, dataNasc);
		this.vehicles = new LinkedList<>();
		this.licencas = new char[4];
	}

	public LinkedList<Vehicle> getVehicles() {
		return vehicles;
	}

	public char[] getLicencas() {
		return licencas;
	}

	public boolean addLicenca(char l) {
		if(n!=0) {
			for (int i =0; i< n; i++) {
				if(licencas[i]==l)
					return false;
			}
			if(n!=4) {
				licencas[n]=l;
			}
		}
		else
			licencas[n]=l;
		
		n++;
		return true;	
	}
	
	@Override
	public String toString() {
		return super.toString() + "veículos=" + vehicles + ", licencas=" + Arrays.toString(licencas);
	}

	public boolean addVehicle(Vehicle vehicle) {
		boolean canDrive = canDrive(vehicle);
		if (canDrive) {
			vehicles.add(vehicle);
		}
		return canDrive;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!super.equals(obj)) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		return true;
	}
	
	private boolean canDrive(Vehicle vehicle) {
		for (int i =0; i< n; i++) {
			if(licencas[i]==vehicle.getTipo())
				return true;
		}
		return false;
	}
}
