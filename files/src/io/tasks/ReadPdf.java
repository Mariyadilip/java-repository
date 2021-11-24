package io.tasks;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStreamReader;

public class ReadPdf {

	public static void main(String[] args) throws Exception {
		
		//File pdf = new File("C:\\Users\\mdilip\\Desktop\\payslips\\August.pdf");
		File pdf = new File("dir\\final.txt");
		/*
		BufferedReader br = new BufferedReader(new FileReader(pdf));
		String line = "";
				
		while((line = br.readLine()) != null)System.out.println(line);
		*/
		
		FileInputStream fis = new FileInputStream(pdf);
		int i = fis.available();
		byte[] b = new byte[i];
		fis.read(b);
		String s = new String(b);
		System.out.println(s);
	}
}
