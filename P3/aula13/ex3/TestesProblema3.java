package aula13.ex3;

public class TestesProblema3 {
	
	public static void main(String args[]) {
		
		String[] funcionarios = {"Jose", "Ana", "Carlos", "Jose"};
		String[] brinquedos = {"bola","corda","plasticina"};
		ListaNomes lista = new ListaNomes();
		ListaFunc_Brinq list = new ListaFunc_Brinq();
		ContadorNomes cNomes = new ContadorNomes();
		DistribuidorBilhetes db = new DistribuidorBilhetes(funcionarios);
		
		for(int i = 0; i< brinquedos.length; i++) {
			list.addBrinquedo(brinquedos[i], funcionarios[i]);
		}
		
		System.out.println("Brinquedos de cada funcionario:\n"+list.toString());
		
		list.removeBrinquedo(funcionarios[1]);
		list.addBrinquedo(brinquedos[1], funcionarios[0]);
		
		System.out.println("\nBrinquedos de cada funcionario:\n" + list.toString());
		
		for(int i = 0; i< funcionarios.length; i++) {
			lista.addFuncionario(funcionarios[i]);
		}
		
		System.out.println("\n"+funcionarios[1] +" removido: " + lista.removeFunc(funcionarios[1]));
		System.out.println(funcionarios[1] + " removido: " + lista.removeFunc(funcionarios[1]));
		
		System.out.println("\nNomes dos Funcionarios:");
		for(int i = 0; i< funcionarios.length; i++) {
			cNomes.addNome(funcionarios[i]);
			System.out.println(funcionarios[i] + ": " + cNomes.getCount(funcionarios[i]));
		}
		
		System.out.println("\nBilhetes dados a: " + db.darBilhete(3));
		
		
		
		
	}
	

}
