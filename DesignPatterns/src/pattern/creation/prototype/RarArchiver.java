package pattern.creation.prototype;

import java.io.File;

public class RarArchiver implements Archiver, Cloneable{

	public RarArchiver() {
	   System.out.println("Rar Archiver Constructor called ");
	}
	
	@Override
	public void archive(File file) {
		System.out.println("Rar file");
	}
	
	@Override
	public Archiver clone() throws CloneNotSupportedException {
		return (Archiver) super.clone();
	}
}
