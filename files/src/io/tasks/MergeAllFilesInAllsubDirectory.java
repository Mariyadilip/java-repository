package io.tasks;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

/*
 * Given a source directory which may contain subdirectories and those subdirectories may contains multiple directories
 * we have copy all files in every directory and add to output.txt;
 * 
 */
public class MergeAllFilesInAllsubDirectory {

	public static void main(String[] args) throws IOException {
		
		String sourceDirectory = "dir\\subdir5";
		File srcDirectory = new File(sourceDirectory);
		
		File destFile = new File(sourceDirectory, "output.txt");
		destFile.createNewFile();
		
		PrintWriter pw = new PrintWriter(destFile);
		addFile(pw, srcDirectory);		
		
		pw.flush();
		pw.close();
		
		System.out.println("Completed ");
	}
	
	private static void addFile(PrintWriter pw, File directory) throws IOException {
		
		String[] list = directory.list();
		for(String file : list) {
		
			File f = new File(directory, file);
			if(f.exists() && f.isDirectory())
			 addFile(pw, f);
			else {
				BufferedReader br = new BufferedReader(new FileReader(f));
				String lines = "";
				
				pw.println(f.getParentFile().getName()+" is the directory");
				pw.println("-----------------------------");
				while((lines = br.readLine()) != null)
					pw.println(lines);
				
				pw.println("\n");
				pw.flush();
				br.close();
			}
		}
	}
}
