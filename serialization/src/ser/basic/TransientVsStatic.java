package ser.basic;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/*
 * Static values cannot be serialized 
 * static are related to class level and serliazation is the process for object (means static cannot participate)
 * so declaring static as transient will give the same value(not the default value);
 * 
 */
public class TransientVsStatic {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		
		D p1 = new D();
		System.out.println(p1);
		
		FileOutputStream fos = new FileOutputStream("dir\\staticVstransient.ser");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(p1);
		
		FileInputStream fis = new FileInputStream("dir\\staticVstransient.ser");
		ObjectInputStream ois = new ObjectInputStream(fis);
		D p2 = (D)ois.readObject();
		
		System.out.println(p2);
		oos.close();
		ois.close();
	}

}

class D implements Serializable{
	
	int i = 44;
	transient int j = 22;
	static int n = 11;
	transient static int k = 33;
	@Override
	public String toString() {
		return "D [i=" + i + ", j=" + j + ", n = "+n+", k = "+k+"]";
	}
	
	
}
