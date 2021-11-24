package pattern.creation.factory;

import java.io.File;

public class Demo {

	public static void main(String[] args) {
		
		Archiver rar = ArchiverFactory.getArchiver("rar");
		Archiver zip = ArchiverFactory.getArchiver("zip");
		Archiver rar1 = ArchiverFactory.getArchiver("rar");
		
		rar.archive(new File(" "));
		zip.archive(new File(" "));
		rar1.archive(new File(" "));
		
		System.out.println(rar == rar1);

	}
}
