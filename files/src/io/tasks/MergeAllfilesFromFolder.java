package io.tasks;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

/*
 * Given a directory which contains multiple files, we need to merge all the files in a single output.txt file in output directory
 */
public class MergeAllfilesFromFolder {

	public static void main(String[] args) throws IOException {
		
		String sourceFolder = "dir\\subdir2";
		String resultDirectoryLocation = "C:\\Users\\mdilip\\eclipse-workspace\\files\\dir"; //In which our directory going to be placed.
		String directoryName = "output";
		String resultFileName = "result.txt";
		
		File sourceDirectory = new File(sourceFolder);
		File destinationDirectory = new File(resultDirectoryLocation, directoryName);
		destinationDirectory.mkdir();
		File outputFile = new File(destinationDirectory, resultFileName);
		outputFile.createNewFile();
		
		PrintWriter pw = new PrintWriter(outputFile);
		
		String[] fileNames = sourceDirectory.list();
		
		for(String fileName : fileNames) {
			File file = new File(sourceFolder, fileName);
			if(file.exists() && file.isFile()) {
				
				BufferedReader br = new BufferedReader(new FileReader(file));
				String line = "";
				pw.println(file.getName());
				pw.println("------------------------");
				while((line = br.readLine()) != null)
					pw.println(line);
			
				pw.println("-------------------------");
				br.close();
			}
		}
		
		pw.flush();
		pw.close();
		
		System.out.println("completed");
	}
}
