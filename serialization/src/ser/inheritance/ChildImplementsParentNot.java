package ser.inheritance;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/* 1. If the parent not implements serializable, though child can perform serialization.
 * 			Eg. Object class is not implementing Serializable, but the class we implement can do serialization
 * 
 * 2. At the time serialization JVM checks if any parent not implementating serializable is there or not, if yes then 
 *    JVM ignore the value of parent data and the store the default value of it.     
 * 
 * 3. At the time of DeSerialization JVM checks if any parent not implementating serializable is there or not, if yes then 
 *    JVM executes the Instance control flow : replace the default value with the instance variable assignment, 
 *    then executes parent class No-Args Constructor;
 *    
 * 4. It is compulsory to have no-arg constructor in parent which is not implementing serializable interface.
 * 
 */

public class ChildImplementsParentNot {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		
		Child1 c1 = new Child1();
		c1.child = 222;
		c1.parent = 111;		
		System.out.println(c1);
		
		FileOutputStream fos = new FileOutputStream("dir\\inheritance\\ChildImplementParentNot.txt");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(c1);
		
		FileInputStream fis = new FileInputStream("dir\\inheritance\\ChildImplementParentNot.txt");
		ObjectInputStream ois = new ObjectInputStream(fis);
		Child1 c2 = (Child1)ois.readObject();
		
		System.out.println(c2);
		System.out.println(c2.child +"......."+c2.parent);
		oos.close();
		ois.close();
	}
}

class Parent1{
	 int parent = 11;
	Parent1(){
		System.out.println("Parent class constructor");
	}
	@Override
	public String toString() {
		return "Parent1 [parent=" + parent + "]";
	}
	{
		System.out.println("Parent instance block ");
	}
}

class Child1 extends Parent1 implements Serializable{
	int child = 22;
	Child1(){
		System.out.println("Child class constructor");
	}
	@Override
	public String toString() {
		return "Child1 [child=" + child + "] "+super.toString();
	}
}