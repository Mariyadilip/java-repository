package ser.inheritance;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/*
 * If parent class implements Serialization, but child doesn't 
 * If parent implements serialization then all child class of it also, because all the child inherit properties of parent
 * so child also implements
 */
public class ParentImplementChildNot {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		
		Child c1 = new Child();
		System.out.println(c1);
		
		FileOutputStream fos = new FileOutputStream("dir\\inheritance\\ParentImplementChildNot.txt");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(c1);
		
		FileInputStream fis = new FileInputStream("dir\\inheritance\\ParentImplementChildNot.txt");
		ObjectInputStream ois = new ObjectInputStream(fis);
		Child c2 = (Child)ois.readObject();
		
		System.out.println(c2);
	}
}

class Parent implements Serializable{
	transient int id = 111;
	String parent = "parent";
	@Override
	public String toString() {
		return "Parent [id=" + id + ", parent=" + parent + "]";
	}
}

class Child extends Parent{
	String child = "child";

	@Override
	public String toString() {
		return "Child [child=" + child + "] "+super.toString();
	}
}