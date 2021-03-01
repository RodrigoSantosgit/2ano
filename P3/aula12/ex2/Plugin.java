package aula12.ex2;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

public class Plugin {
	
	public static void main(String[] args) throws Exception {
		File proxyList = new File("src/aula12/ex2");
		ArrayList<IPlugin> plgs = new ArrayList<IPlugin>();
		for (String f: proxyList.list()) {
			try {
				plgs.add(PluginManager.load("aula12.ex2."+f.substring(0,f.lastIndexOf('.'))));
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		Iterator<IPlugin> it = plgs.iterator();
		while (it.hasNext()) {
			it.next().fazQualQuerCoisa();
		}
	}
}