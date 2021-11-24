package ser.basic;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class Dog implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int i = 1;
	int j = 2;
	
	public String toString() {
		return i+" "+j;
	}
	
}

public class SerializationAndDeSerializationDemo {

	public static void main(String[] args) throws Exception {
		
		Dog d1 = new Dog();
		
		File file = new File("dir\\demo.txt");
		file.createNewFile();
		
		FileOutputStream fos = new FileOutputStream(file);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(d1);
		
		FileInputStream fis = new FileInputStream(file);
		ObjectInputStream ois = new ObjectInputStream(fis);
		Dog d2 = (Dog)ois.readObject();
		
		System.out.println(d2);
		oos.close();
		ois.close();
	}
}
