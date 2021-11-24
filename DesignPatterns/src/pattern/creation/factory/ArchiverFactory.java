package pattern.creation.factory;

import java.util.HashMap;
import java.util.function.Supplier;

public class ArchiverFactory {

	private static HashMap<String, Supplier<Archiver>> map;
	
	static {
		map = new HashMap<String, Supplier<Archiver>>();
		map.put("rar", ()->new RarArchiver());
		map.put("zip", ZipArchiver::new); // we can also use method Reference
	}
	
	public static Archiver getArchiver(String type) {
		
		return (Archiver) map.get(type).get() == null ? null :
									map.get(type).get();
	}
}
