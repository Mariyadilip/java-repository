package ser.basic;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/*
 * If we don't want to store some sensitive information, then we can use transient
 * transient can only be used with variables;
 */

public class Transient {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		
		Person p1 = new Person();
		System.out.println(p1);
		
		FileOutputStream fos = new FileOutputStream("dir\\person.ser");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(p1);
		
		FileInputStream fis = new FileInputStream("dir\\person.ser");
		ObjectInputStream ois = new ObjectInputStream(fis);
		Person p2 = (Person)ois.readObject();
		
		System.out.println(p2);
		oos.close();
		ois.close();
	}
}

class Person implements Serializable{
	String name = "Mariya Dilip";
	transient String password = "90252324";
	int age = 22;
	transient int pin = 444;
	boolean flag = true;
	boolean flag1 = false;
	transient boolean flagTrue = true;
	transient boolean flagFalse = false;
	
	@Override
	public String toString() {
		return "Person [name=" + name + ", password=" + password + ", age=" + age + ", pin=" + pin + ", flag=" + flag
				+ ", flag1=" + flag1 + ", flagTrue=" + flagTrue + ", flagFalse=" + flagFalse + "]";
	}
	
	
}
