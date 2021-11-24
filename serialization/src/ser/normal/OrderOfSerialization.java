package ser.normal;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class OrderOfSerialization {

	/*
	 * we can serialize  many objects 
	 * But the order of deserialization must be same of serialization 
	 */
	
	//This is to use when we know the order of serialization
	/*
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		
		Dog d1 = new Dog();
		Rat r1 = new Rat();
		Cow c1 = new Cow();
		
		FileOutputStream fos = new FileOutputStream("dir\\orderofserialization.txt");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(d1);
		oos.writeObject(r1);
		oos.writeObject(c1);
		
		FileInputStream fis = new FileInputStream("dir\\orderofserialization.txt");
        ObjectInputStream ois = new ObjectInputStream(fis);
        
        Dog d2 = (Dog)ois.readObject();
        Rat r2 = (Rat)ois.readObject();
        Cow c2 = (Cow)ois.readObject();
        
        System.out.println(d2);
        System.out.println(r2);
        System.out.println(c2);
        
        ois.close();
        oos.close();
	}
	*/
	
	//This is to use when don't know the order of serialization;
	public static void main(String[] args) throws ClassNotFoundException, IOException {
		Dog d1 = new Dog();
		Rat r1 = new Rat();
		Cow c1 = new Cow();
		
		FileOutputStream fos = new FileOutputStream("dir\\orderofserialization.txt");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(c1);
		oos.writeObject(d1);
		oos.writeObject(r1);
		
		FileInputStream fis = new FileInputStream("dir\\orderofserialization.txt");
        ObjectInputStream ois = new ObjectInputStream(fis);
        
        Dog d2 = null;
        Rat r2 = null;
        Cow c2 = null;
        
        try {
        Object obj = ois.readObject();
        while(obj != null) {
        	if(obj instanceof Dog)
        		d2 = (Dog)obj;
        	else if(obj instanceof Rat)
        		r2 = (Rat)obj;
        	else if(obj instanceof Cow)
        		c2 = (Cow)obj;
        	obj = ois.readObject();
        }
        }
        catch(Exception e) {}
        
        System.out.println(d2);
        System.out.println(r2);
        System.out.println(c2);
        
        ois.close();
        oos.close();
	}
}

class Dog implements Serializable{
	String name = "dog";
	transient int id = 111;
	@Override
	public String toString() {
		return "Dog [name=" + name + ", id=" + id + "]";
	}
	
}

class Rat implements Serializable{
	String rat = "rat";
	transient int id = 222;
	@Override
	public String toString() {
		return "Rat [rat=" + rat + ", id=" + id + "]";
	}
	
}

class Cow implements Serializable{
	String name = "cow";
	transient int id = 333;
	@Override
	public String toString() {
		return "Cow [name=" + name + ", id=" + id + "]";
	}
}