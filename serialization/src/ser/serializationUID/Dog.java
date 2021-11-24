package ser.serializationUID;

import java.io.Serializable;

public class Dog implements Serializable{

	/**
	 * 
	 */
	int i = 10;
	int j = 20;
    int k = 30;
    
	@Override
	public String toString() {
		return "Dog [i=" + i + ", j=" + j + "]";
	}
	
    public static void main(String[] args) {
		System.out.println("compiled ");
	}
	
}
