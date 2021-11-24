package ser.serializationUID;

/*
 * The sender and receiver
 * 		need not be same
 * 		need not use the same machine (os)
 * 		need not use same JVM version
 *
 * At the time of serialization Senders JVM will add UniqueIdentifier to every Object that serialize's.
 * While Deserializeing the based on .class the UID will be compared with Objects(deserilizing object) Uid, if matches it
 * perform serialization otherwise throw InvalidClassException
 * 
 *  
 */
public class SerializationUID {

	public static void main(String[] args) {
		
	}
}
