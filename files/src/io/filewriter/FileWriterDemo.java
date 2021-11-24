package io.filewriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/*
 * FileWriter is used to write text data / character;
 * 
 * Four Constructors in FileWriter
 * 
 * 1 FW fw = new FW(String name);
 * 2 FW fw = new FW(File f);
 * 
 * The above File Writers will override the contents of the existing file
 * If we want to append the contents to the file
 *  
 *3 FW fw = new FW(String name, Boolean b); 
 *4 FW fw = new FW(File f, Boolean b);
 *
 *  If the file is not present all the constructors creates the new File		 *  
 */
public class FileWriterDemo {

	public static void main(String[] args) throws IOException {
		
		File file = new File("dir\\abc.txt");
		FileWriter fw = new FileWriter(file, true);
		
		fw.write(98); //writes single char
		fw.write('\n');
		fw.write("Mariya Dilip \n AIHT");
		char[] c = {'2', '2',};
		fw.write(c);
		fw.write('k');
		
		fw.flush();
		fw.close();
	}
}
