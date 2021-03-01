package aula9.ex1;

import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.Scanner;

public class ScannerAbeirense implements Closeable, Iterator<String> {

	private Scanner read;
	
	public ScannerAbeirense(File f) {
		try {
			read = new Scanner(f);
		}
		catch(IOException e){
			System.err.println("ERROR: Invalid File");
		}
	}
	
	public ScannerAbeirense(InputStream e) {
		this.read = new Scanner(e);
	}
	
	
	@Override
	public boolean hasNext() {
		return read.hasNext();
	}

	@Override
	public String next() {
		String s = read.next();
		s = s.replaceAll("v", "b");
		s = s.replaceAll("V", "B");
		return s;
	}

	@Override
	public void close() throws IOException {
		read.close();
	}

	public String nextLine() {
		String s = read.nextLine();
		s = s.replaceAll("v", "b");
		s = s.replaceAll("V", "B");
		return s;

	}
	
}
