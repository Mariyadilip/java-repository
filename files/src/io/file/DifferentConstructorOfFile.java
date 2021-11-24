package io.file;

import java.io.File;
import java.io.IOException;

public class DifferentConstructorOfFile {

	public static void main(String[] args) throws IOException {
		
		/* File f = new File(String name);
		 * name => directory or file
		 */
		
		
		// File f = new File(String directory, String name);
		// we can create file in sub directory (or) in another directory		
		File file = new File("dir\\subdir");
		
		File f = new File("dir\\subdir", "demo.txt");
		f.createNewFile();
		//"C:\\Users\\mdilip\\eclipse-workspace\\files\\dir\\subdir"
		
		//File file = new File(File f, String name);
		//It is same as the above 
		//If we want to create file inside the directory that f is pointed
		
		File f1 = new File(file, "demo1.txt");
		f1.createNewFile();
	}
}
