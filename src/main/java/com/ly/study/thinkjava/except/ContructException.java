package com.ly.study.thinkjava.except;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ContructException {

}

class InputFile {
	private BufferedReader in;
	public InputFile(String fname) throws Exception {
		try {
			in = new BufferedReader(new FileReader(fname));
		} catch (FileNotFoundException e) {
			System.out.println("could not open " + fname);
			throw e;
		} catch (Exception e) {
			try {
				in.close();
			} catch (IOException e2) {
				System.out.println("in.close() unsuccessful");
			}
			throw e;
		} finally {
			
		}
	}
	
	public String getLine() {
		String s;
		try {
			s = in.readLine();
		} catch (IOException e) {
			throw new RuntimeException("readLine() failed");
		}
		return s;
	}
	
	public void dispose() {
		try {
			in.close();
			System.out.println("dispose() successful");
		} catch (IOException e) {
			throw new RuntimeException("in.close() failed");
		} 
	}

	public static void main(String[] args) {
		try {
			InputFile in = new InputFile("cleanup.java");
			try {
				String s = null;
				int i = 1;
				while ((s = in.getLine()) != null) {
					;
				}
			} catch (Exception e) {
				System.out.println("caught exception in main");
				e.printStackTrace(System.out);
			} finally {
				in.dispose();
			}
		} catch (Exception e) {
			System.out.println("inputfile constructor failed.");
		}
	}
}