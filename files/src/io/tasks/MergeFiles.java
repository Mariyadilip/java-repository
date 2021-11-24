package io.tasks;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/*
 * Given a text file with mulitple file locations in it, we need to merge all the files into a file 
 */
public class MergeFiles {

	public static void main(String[] args) throws IOException {

		String destination = "dir\\final.txt";
		File source = new File("filelocations.txt");
		File dest = new File(destination);
		dest.createNewFile();

		BufferedReader br = new BufferedReader(new FileReader(source));
		PrintWriter pw = new PrintWriter(new FileWriter(dest, true));
		String file = "";

		while ((file = br.readLine()) != null) {
			File newfile = new File(file);

			if (newfile.exists() && newfile.isFile()) {

				BufferedReader newBr = new BufferedReader(new FileReader(newfile));
				String line = "";
				while ((line = newBr.readLine()) != null)
					pw.println(line);
				pw.println("--------------------------------");
				newBr.close();
			}
		}

		pw.flush();
		br.close();
		pw.close();

		System.out.println("Completed ");
	}
}
