package aula12.ex1;

import java.util.Scanner;

public class Problema1 {

	public static void main(String args[]) throws ClassNotFoundException, InstantiationException, Exception {
	
		Scanner sc = new Scanner(System.in);
		ClassChecker cc = null;
		String name = "";
		try {
			System.out.print("Class a ler -> ");
			name = sc.nextLine();
			cc = new ClassChecker(name);
			System.out.println("\n" + cc.getSuperClass() + "\n" + cc.getInterfaces() +
					"\n" + cc.getFields() + "\n" + cc.getConstructor() +
					"\n" + cc.getMethods());
		}
		catch(ClassNotFoundException e) {
			System.err.println("Class Not Found");
		}
		
		sc.close();
		
		cc.createObject(name);
		
	}
	
}
