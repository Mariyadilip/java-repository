package zoho.directory;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileAppending {

	public static void append(File path1, File path2) throws IOException {
	
    FileWriter fw = new FileWriter(path1, true);
	File folder = new File(path2.toString());
	
	File[] listOfFiles = folder.listFiles();

	for (File file : listOfFiles) {
	    if (file.isFile()) {
	      System.out.println(file.getAbsolutePath());
	      fw.append(file.getAbsolutePath()+"\n");
	    }
	}
	fw.close();
	}
	
	public static void main(String[] args) throws IOException {
		
		File path1 = new File("C:\\Users\\mdilip\\Desktop\\back_log\\bin.txt");
		File path_1 = new File("C:\\Apache-tomcat-9.0.30\\apache-tomcat-9.0.30\\bin");
		
		File path2 = new File("C:\\Users\\mdilip\\Desktop\\back_log\\sccm.txt");
		File path_2 = new File("c:\\sccm_logs");
		append(path1, path_1);
		append(path2, path_2);
	}
}
