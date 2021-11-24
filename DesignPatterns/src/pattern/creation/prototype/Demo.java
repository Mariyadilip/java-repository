package pattern.creation.prototype;

import java.io.File;

public class Demo {

	public static void main(String[] args) throws Exception {
		
		String rar = "rar";
		String zip = "zip";
		
		Archiver archiver1 = ArchiverFactory.getPrototypeOfType(rar);
		Archiver archiver2 = ArchiverFactory.getPrototypeOfType(zip);
	
		archiver1.archive(new File(" "));
		archiver2.archive(new File(" "));
		
		System.out.println(archiver1 == ArchiverFactory.getPrototypeOfType(rar));
	}
}
