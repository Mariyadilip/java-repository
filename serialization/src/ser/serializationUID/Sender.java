package ser.serializationUID;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class Sender {

public static void main(String[] args) throws Exception {
		
	    Dog dog = new Dog();
	    dog.i = 2222;
	    dog.j = 3333;
	    
	 		System.out.println(dog);
	 		
		File file = new File("dir\\serialversionUid\\Dog.txt");
		FileOutputStream fos = new FileOutputStream(file);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(dog);
     
		System.out.println("Serialized ");
		oos.close();
	}
}
