package ser.customizedserialization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/*
 * If we use default serialization we may loss data while deserializing because of transient keyword
 * So to avoid this issue we have to use customized serialization
 *    private void writeObject(ObjectOuputStream oss);
 *    private void readObject(ObjectInputStream ois);
 *  which class needs to serialize that class has to implement this 2 methods,
 *  This is executed automatically by JVM, and this is called Callback Methods
 *   
 */
public class CustomizedSerializatiion {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		
		Account a1 = new Account();
		System.out.println(a1);
		
		FileOutputStream fos = new FileOutputStream("dir\\customizedSer.txt");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(a1);
		//When we call writeObject() JVM checks the Account class if private void WriteObject(OOS oos) or not,
		//it yes then it executes that method
		
		FileInputStream fis = new FileInputStream("dir\\customizedser.txt");
		ObjectInputStream ois = new ObjectInputStream(fis);
		Account a2 = (Account)ois.readObject();
		//When we call readObject() JVM checks the Account class if private void readObject(OIS ois) or not,
		//it yes then it executes that method
		
		System.out.println(a2);
		ois.close();
		oos.close();
	}
}

class Account implements Serializable{
	
	String name = "mariya dilip";
	transient String pwd = "abc123";
	transient String ifsc = "HDFC";
	transient int no = 999;
	
	
	@Override
	public String toString() {
		return "Account [name=" + name + ", pwd=" + pwd + ", ifsc=" + ifsc + ", no=" + no + "]";
	}

	private void writeObject(ObjectOutputStream oos) throws IOException {
		oos.defaultWriteObject(); 
		//it performs defaultSerialization means saving noraml value in file and default value(0, null,..) if it transient
		
		String encryptedPassword = "xyz"+pwd;
		int encryptedNo = 444 + no;
		//performing encryption so that, the same value we can get after deserializing in the case of transient
		
		oos.writeObject(encryptedPassword);
		oos.writeObject(encryptedNo);
		//saving the encrypted data in the file
	}
	
	private void readObject(ObjectInputStream ois) throws ClassNotFoundException, IOException {
		ois.defaultReadObject();
		//performing default serialization
		
		String decryptPassword = (String) ois.readObject();
		int decryptNo = (int)ois.readObject(); //we can also use ois.readInt(), ois.readBoolean()..., but that should have been writen in same format not as oos.writeObject() but as oos.writeInt()
		//getting the encrypted data from the file
		
		decryptPassword = decryptPassword.substring(3);
		 decryptNo = decryptNo - 444;
		//decrypting the data
		 
		pwd = decryptPassword;
		no = decryptNo;
	}
}
