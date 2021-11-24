package zoho.directory;
import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipUtility {
    
    private static final int BUFFER_SIZE = 4096;

		static File fileName = new File("C:\\Users\\mdilip\\Desktop\\back_log\\");
        static FileWriter fw = null;
		static boolean time = true;
		
    public void zip(List<File> listFiles, String destZipFile) throws FileNotFoundException,
            IOException {
        ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(destZipFile));
        for (File file : listFiles) {
            if (file.isDirectory()) {
                zipDirectory(file, file.getName(), zos);
            } else {
                zipFile(file, zos);
            }
        }
        zos.flush();
        zos.close();
    }
      
    private void zipDirectory(File folder, String parentFolder,
            ZipOutputStream zos) throws IOException {
      
    	if(parentFolder != null) {
   		  fw = new FileWriter(fileName+"//"+parentFolder+".txt", true);
   		  time = false;
    	}
    	
    	try {
        for (File file : folder.listFiles()) {
        	fw.append(file.getAbsolutePath()+"\n");
            if (file.isDirectory()) {
                zipDirectory(file, parentFolder + "/" + file.getName(), zos);
                continue;
            }
            zos.putNextEntry(new ZipEntry(parentFolder + "/" + file.getName()));
            BufferedInputStream bis = new BufferedInputStream(
                    new FileInputStream(file));
            long bytesRead = 0;
            byte[] bytesIn = new byte[BUFFER_SIZE];
            int read = 0;
            while ((read = bis.read(bytesIn)) != -1) {
                zos.write(bytesIn, 0, read);
                bytesRead += read;
            }
            zos.closeEntry();
        }
    	}

        catch(Exception e) {}
        
    }
    
    private void zipFile(File file, ZipOutputStream zos)
            throws FileNotFoundException, IOException {
        zos.putNextEntry(new ZipEntry(file.getName()));
   
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(
                file));
        long bytesRead = 0;
        byte[] bytesIn = new byte[BUFFER_SIZE];
        int read = 0;
        while ((read = bis.read(bytesIn)) != -1) {
            zos.write(bytesIn, 0, read);
            bytesRead += read;
        }
        zos.closeEntry();
        bis.close();
    }
     
}