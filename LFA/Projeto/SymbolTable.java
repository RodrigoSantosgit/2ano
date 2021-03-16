import java.util.*;
import org.opencv.core.*;
public class SymbolTable
{

	private Map<String, Mat> t;

	public SymbolTable(){
	
		this.t = new HashMap<>();
	
	}

	public Mat get(String key){
		assert key != null;
		assert exists(key);
		
		return t.get(key);
	}
	
	public boolean exists(String key){
		assert key != null;
		
		return t.containsKey(key);
	} 

	public void put(String key, Mat mat){
	
		assert key != null;
		assert mat != null;
	
		t.put(key , mat);
		
	}

}
