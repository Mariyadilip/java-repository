package ser.externalization;

import java.io.Externalizable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

/*
 * In Serialzation every thing is taken care by JVM, programmer doesn't have any control over the process
 * And it is not possible to store part of an object, always we have to store the full object;
 * 
 * In Externalization progammer have the control, JVM doesn't have control
 * And we can store part of an object or full object;
 * 
 * it has two methods 
 *   1 writeExternal();
 *   2 readExternal();
 *   
 * But at the time of Deserializing the object there may be a part of object also, but it always return the object
 * this object is  created by JVM and will call readExternal() on this object, 
 * so it is compulsory to have no-args constructor in Externalizable class;
 * 
 * 
 * Transient keyword don't play any role in externalization because  in this process the programmer can save the required
 * data in the file, so if the programmer want's to hide some data he/she can do it without using transient keywordc, so 
 * there is any use;
 *  
 */
public class ExternalizationDemo {

	public static void main(String[] args) throws Exception {
		
		Animal animal = new Animal("Dog", 11, 22.44);
		System.out.println(animal);
		File file = new File("dir\\externalization\\file1.txt");
		FileOutputStream fos = new FileOutputStream(file);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(animal);
		//It will check the class that has implemented Exteranalizable interaface or not
		//if Yes, then it execute writeExternal() and serialize only the properties which we use in this method;
		
		FileInputStream fis = new FileInputStream(file);
		ObjectInputStream ois = new ObjectInputStream(fis);
		Animal animal1 = (Animal)ois.readObject();
		System.out.println(animal1);
		//It will check the class that has implemented Exteranalizable interaface or not
		//if Yes, then it execute readExternal() and ""create the new object"" and put the corressponding value coming from file
		//and return this object to the user;
		//NO-args constructor must have been used;
		
		oos.close();
		ois.close();
	}
}

class Animal implements Externalizable{
	
	String name;
	int id;
	double weight;	
	
	public Animal(String name, int id, double weight) {
		super();
		this.name = name;
		this.id = id;
		this.weight = weight;
	}
	
	public Animal() {
		System.out.println("no-args constructor of animal ");
	}
	@Override
	public String toString() {
		return "Animal [name=" + name + ", id=" + id + ", weight=" + weight + "]";
	}
	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		out.writeInt(id);		
	}
	@Override
	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
       id = in.readInt();		
	}
	
	
}
