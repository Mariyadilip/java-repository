package zoho;

import java.util.HashMap;
import java.util.Map;

public class StringDuplication {

	public static void main(String[] args) {

		String[] s = { "abcd", "ade", "abcd", "def", "efg", "ABCD" };
		boolean found = false;

		if (s.length == 0) {
			System.out.println("Array is Empty");
			return;
		}

		Map<String, Integer> map = new HashMap<>();

		for (String str : s) {

			if (map.containsKey(str.toLowerCase())) {
				map.put(str.toLowerCase(), map.get(str.toLowerCase()) + 1);
			} else
				map.put(str.toLowerCase(), 1);
		}

		for (Map.Entry<String, Integer> result : map.entrySet()) {

			if (result.getValue() > 1) {
				System.out.println(result.getKey() + " " + result.getValue());
				found = true;
			}
		}

		if (!found)
			System.out.println("No Duplicates");
	}
}
