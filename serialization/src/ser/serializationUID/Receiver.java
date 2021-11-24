package ser.serializationUID;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class Receiver {

public static void main(String[] args) throws Exception {
		
		File file = new File("dir\\serialversionUid\\Dog.txt");
		FileInputStream fos = new FileInputStream(file);
		ObjectInputStream oos = new ObjectInputStream(fos);
		Dog dog = (Dog) oos.readObject();
		
		System.out.println(dog);
		System.out.println("DeSerialized ");
		oos.close();
	}
}
