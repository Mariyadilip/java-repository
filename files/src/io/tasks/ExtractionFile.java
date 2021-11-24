package io.tasks;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

/*
 * Two files will be given file1 contains all the contact numbers and file2 contains some blocked contacts numbers
 *  we have to find the number such that the number should not be in blocked contact 
 *  
 *  output = file1 - file2
 *  
 *  file1    file2       result
 *  111       222          111
 *  222       555          444
 *  333		  333          666
 *  444
 *  555
 *  666
 */
public class ExtractionFile {

	public static void main(String[] args) throws IOException {
		
		String sourceDirectory = "dir\\subdir3"; 
		File fullContact = new File(sourceDirectory, "fullcontactnumbers.txt");
		File blockedContact = new File(sourceDirectory, "blockedcontactnumbers.txt");
		
		PrintWriter pw = new PrintWriter(new File(sourceDirectory, "result.txt"));
		BufferedReader fullBR = new BufferedReader(new FileReader(fullContact));
		
		String fullList = "";
		
		while((fullList = fullBR.readLine()) != null) {
			
			BufferedReader blockBR = new BufferedReader(new FileReader(blockedContact));
			String blockList = "";
			boolean blocked = false;
			
			while((blockList = blockBR.readLine()) != null) {
               if(fullList.equals(blockList)) {
            	   blocked = true;
            	   break;
               }
			}
			
			if(!blocked)
				pw.println(fullList);
			
			blockBR.close();
		}
		
		fullBR.close();
		pw.flush();
		pw.close();
		
		System.out.println("Completed");
	}
}
