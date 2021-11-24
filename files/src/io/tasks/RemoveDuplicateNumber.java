package io.tasks;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

/*
 * A file contains some duplicate numbers we have to remove the duplicates and print the unique numbers
 * 
 * file      output
 * 
 * 222        222
 * 333		  333
 * 444        444
 * 222		  555
 * 555
 * 333
 */
public class RemoveDuplicateNumber {

	public static void main(String[] args) throws IOException {
		
		String sourceDirectory = "dir\\subdir4";
		File  list = new File(sourceDirectory, "list.txt");
		File result = new File(sourceDirectory, "uniqueList.txt");
		result.createNewFile();
		
		PrintWriter pw = new PrintWriter(result);
		BufferedReader listBr = new BufferedReader(new FileReader(list));
		String listNumber = "";
		
		while((listNumber = listBr.readLine()) != null) {
			
			BufferedReader resultBr = new BufferedReader(new FileReader(result));
			String resultNumber = "";
			boolean found = false;
			
			while((resultNumber = resultBr.readLine()) != null)
			if(resultNumber.equals(listNumber)) {
				found = true;
				break;
			}
			
			if(!found) {
				pw.println(listNumber);
				pw.flush();
			}
			
			resultBr.close();
		}
		
		listBr.close();
		pw.flush();
		pw.close();
		
		System.out.println("Completed");
	}
}
