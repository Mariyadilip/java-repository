package io.file;

import java.io.File;
import java.io.IOException;

public class CreatingNewFileAndDirectory {

	public static void main(String[] args) throws IOException {
		
		//New File
		File f = new File("demo.txt");
		f.createNewFile();
	    System.out.println(f.exists());
	    
	    //New Directory or Folder
	    File dir = new File("dir");
	    dir.mkdir();
	    System.out.println(dir.exists());
	}
}
