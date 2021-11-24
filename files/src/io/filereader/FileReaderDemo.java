package io.filereader;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/*
 * It reads text data / character from the file
 * 
 * FR fr = new FR(String fname);
 * FR fr = new FR(File f);
 * 
 */
public class FileReaderDemo {

	public static void main(String[] args) throws IOException {
		
		File f = new File("dir\\abc.txt");
		FileReader fw = new FileReader(f);
		
		//System.out.println((char)fw.read()); //It returns unicode value of single character
		int i = fw.read();
		
		while(i != -1) {
			System.out.print((char)i);
			i = fw.read();
		}
		
		fw.close();
		
		System.out.println("\n ------------------------");
		
		FileReader fw1 = new FileReader(f);
		char[] ch = new char[(int)f.length()];
		
		//this method copies the character from file to char array
		fw1.read(ch);
		
		for(char c : ch)System.out.print(c);
		fw1.close();
		
		//If the content of files exceeds int range, don't use this (read(char[])) method, better to go read() method;
	}
}
