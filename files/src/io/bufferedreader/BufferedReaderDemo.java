package io.bufferedreader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/*
 * It is the enhanced reader to read character data from the file
 * It is used to read data line by line or character by character
 * It cannot directly communicate with the file, it needs Reader Object;
 */
public class BufferedReaderDemo {

	public static void main(String[] args) throws IOException {
		File file = new File("dir\\abc.txt");
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		String line = br.readLine();
		while( line != null) {
			System.out.println(line);
			line = br.readLine();
		}
		//br.lines().filter(line -> line.length() > 1).map(String::toUpperCase).forEach(System.out::println);
		br.close();
	}
}
