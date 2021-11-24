package pattern.creation.prototype;

import java.io.File;

public class ZipArchiver implements Archiver, Cloneable{

	public ZipArchiver() {
	 System.out.println("Zip Archiver Constructor called ");
	}
	
	@Override
	public void archive(File file) {
		System.out.println("Zip file");
	}
	
	@Override
	public Archiver clone() throws CloneNotSupportedException {
		return (Archiver) super.clone();
	}
}
