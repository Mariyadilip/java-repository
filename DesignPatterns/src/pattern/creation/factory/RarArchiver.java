package pattern.creation.factory;

import java.io.File;

public class RarArchiver implements Archiver{

	@Override
	public void archive(File file) {
      System.out.println("Rar Archiver ");		
	}

}
