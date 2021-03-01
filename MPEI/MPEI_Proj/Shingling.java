package MPEI_Proj;

public class Shingling {
	
	public Shingling () {
		
	}
	
	public static String[] getShingle(String toShingle, int length) {
	
		String in = toShingle.replaceAll("\\s","").replaceAll(",", "");
		
		String[] result = new String[in.length()-(length-1)];
		for(int i=0;i<in.length()-(length-1);i++) {
			result[i] = in.substring(i, i+length);
		}
		return result;	
	}
}
