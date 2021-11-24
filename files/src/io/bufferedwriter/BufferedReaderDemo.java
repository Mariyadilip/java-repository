package io.bufferedwriter;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class BufferedReaderDemo {
 
	public static void main(String[] args) throws IOException {
		
		FileWriter fw = new FileWriter("dir\\abc.txt", true);
		BufferedWriter bw = new BufferedWriter(fw);
		bw.write('a');
		bw.newLine();
		bw.write("24-12-1998".toCharArray());
		bw.newLine();
		bw.write("Mariya Dilip");
		bw.newLine();
		bw.write(112);
		bw.newLine();
		bw.flush();
		bw.close();
}
}
