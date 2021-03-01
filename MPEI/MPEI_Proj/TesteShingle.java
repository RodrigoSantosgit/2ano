package MPEI_Proj;

public class TesteShingle {

	public static void main(String[] args) {
		
		String [] str = Shingling.getShingle("uma string,para, testar o shingling", 5);
		
		for(int i=0; i<str.length;i++) {
			System.out.println(str[i]);
		}
	}
}
