package io.file;

import java.io.File;

public class ImportantFileMethods {

	public static void main(String[] args) {
		
		File f = new File("dir");
		String[] names = f.list();
		
		//list() method will display all file name and directory name in current directory
		//for(String name : names)System.out.println(name);
		
		//if I want only file names inside the current directory
		for(String name : names)
		if(new File(f, name).isFile())System.out.println(name);
		
		//if i want only directory names inside the current directory
		for(String name : names)
			if(new File(f, name).isDirectory())System.out.println(name);
		
		
		File abc = new File("dir", "abc.txt");
		System.out.println(abc.length());
	}
}
