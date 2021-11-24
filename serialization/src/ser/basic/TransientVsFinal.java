package ser.basic;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/*
 * Every final variable must participate in serialization,
 * It's value will be Pirectlly replaceP in compile time itself(whereas noraml variable value change in runtime)
 */
public class TransientVsFinal {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		
		P p1 = new P();
		System.out.println(p1);
		
		FileOutputStream fos = new FileOutputStream("dir\\finalVstransient.ser");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(p1);
		
		FileInputStream fis = new FileInputStream("dir\\finalVstransient.ser");
		ObjectInputStream ois = new ObjectInputStream(fis);
		P p2 = (P)ois.readObject();
		
		System.out.println(p2);
		oos.close();
		ois.close();
	}
}

class P implements Serializable{
	int i = 22;
	transient int j = 33;
	@Override
	public String toString() {
		return "P [i=" + i + ", j=" + j + "]";
	}
}