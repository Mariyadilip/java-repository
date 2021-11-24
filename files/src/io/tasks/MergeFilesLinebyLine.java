package io.tasks;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/*
* Given a text file with mulitple file locations in it, we need to merge all the files into a file, where 
* lines should be added line by line (1st line from file1, 1st line from file2, 1st line from fileN, 2nd line from file1, ...) 
*/

public class MergeFilesLinebyLine {

	public static void main(String[] args) throws IOException {

		String destination = "dir\\mergedfileslinebyline.txt";
		File source = new File("filelocations.txt");
		File dest = new File(destination);
		dest.createNewFile();
		List<List<String>> files = new ArrayList<>();
		BufferedReader br = new BufferedReader(new FileReader(source));
		PrintWriter pw = new PrintWriter(dest);

		int len = -1;
		String loc = "";
	    while((loc = br.readLine()) != null) {
	    	List<String> temp = new ArrayList<>();
	    	BufferedReader br1 = new BufferedReader(new FileReader(loc));
	    	String line = "";
	    	while((line = br1.readLine()) != null)
	    		temp.add(line);
	    	len = Math.max(len, temp.size());
	    	files.add(temp);
	    	br1.close();
	    }
	    
	    System.out.println(files);
	    int pos = 0;
	    for(int i=0 ; i<len ; i++) {
	    	for(int j=0 ; j<files.size() ; j++) {
	    		if(files.get(j).size() > pos) {
	    			pw.println(files.get(j).get(pos));
	    		}
	    	}
	    	pos++;
	    }
	    
	    br.close();
	    pw.flush();
	    pw.close();
	    
	    System.out.println("Completed");
	}
	
}
