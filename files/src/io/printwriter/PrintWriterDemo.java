package io.printwriter;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

/*
 * It is best option write data in the file
 * Using Printwriter we can write specific datatype data in the file, which is not possible in the
 *    FileWriter and BufferedWriter, In FW and BW we can only able to put character data;
 * 
 * In PW we can directly communicate with file or using Writer object also;
 */
public class PrintWriterDemo {
	
	public static void main(String[] args) throws FileNotFoundException {
		
		PrintWriter pw = new PrintWriter("dir\\dilip.txt");
		//PrintWriter pw = new PrintWriter(new FileWriter(new File("dir\\dilip.txt")));
		
        pw.write(100);
        pw.println();
        pw.println(100);
        pw.println(true);
        pw.println('A');
        pw.println("Mariya Dilip");
        pw.println("24-12-1998".toCharArray());
        pw.println(new int[] {1, 2, 3, 4, 5});
        pw.close();
	}

}
