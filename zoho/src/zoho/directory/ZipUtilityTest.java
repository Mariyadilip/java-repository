package zoho.directory;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class ZipUtilityTest {
    public static void main(String[] args) throws IOException {
    	
    	File file=new File("C:\\Users\\mdilip\\Desktop\\file1.txt");  

    	FileReader fr=new FileReader(file);  
    	
    	
    	BufferedReader br=new BufferedReader(fr);  
    	
    	String line;  
        List<File> files = new ArrayList<>();
        
    	while((line=br.readLine())!=null)  
         files.add(new File(line));
    	
    	fr.close();     
        fr.close();   

        long time = file.lastModified();
        
        DateFormat sdf
        = new SimpleDateFormat("MMMM dd yyyy hh:mm");
        
       
//        System.out.println(sdf.format(time));
//        
//        String date = sdf.format(time);       
//       System.out.println("Date "+date);
    
        //System.out.println(files);
        String zipFile = "C:\\Users\\mdilip\\Desktop\\backup_17_05.zip";
        ZipUtility zipUtil = new ZipUtility();
        try {
            zipUtil.zip(files, zipFile);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
