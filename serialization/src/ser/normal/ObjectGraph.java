package ser.normal;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/*
 * If one object is serialized then all the objects which are reachable from that object will also be serialized
 * This group of object is called ObjectGraph
 * so internally all objects( which are reachable), are serializing so that classes should implement serializable interface
 * while deserialization all the serialized objects are deserialized
 */
public class ObjectGraph {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		
		Dog1 d = new Dog1();
		
		FileOutputStream fos = new FileOutputStream("dir\\objectgraph.txt");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(d);		
		
		FileInputStream fis = new FileInputStream("dir\\objectgraph.txt");
        ObjectInputStream ois = new ObjectInputStream(fis);
        Dog1 d1 = (Dog1)ois.readObject();
        
        System.out.println(d1);
        System.out.println(d1.r.c.j);
	}
}

class Dog1 implements Serializable{
	Rat1 r = new Rat1();

	@Override
	public String toString() {
		return "Dog [r=" + r + "]";
	}
}

class Rat1 implements Serializable{
	Cow1 c = new Cow1();

	@Override
	public String toString() {
		return "Rat [c=" + c + "]";
	}
}

class Cow1 implements Serializable{
	int j = 10;

	@Override
	public String toString() {
		return "Cow [j=" + j + "]";
	}
}