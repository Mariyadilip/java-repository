package pattern.creation.prototype;

import java.util.HashMap;

public class ArchiverFactory implements Cloneable {

	static HashMap<String, Archiver> map;
	
	static {
		map = new HashMap<>();
		map.put("rar", new ZipArchiver());
		map.put("zip", new RarArchiver());
	}
	
	public static Archiver getPrototypeOfType(String archiver) throws Exception {
		return map.get(archiver).clone();
	}
}
