package zoho;

public class SubsetStrings {

	// a - 97
	// z - 122
	// A - 65
	// Z - 90

	public static void main(String[] args) {

		int[] string1 = new int[123];
		int[] string2 = new int[123];

		String s1 = "acdz";
		String s2 = "az";

		if (s2.length() > s1.length()) {
			System.out.println("Can't Form");
			return;
		}

		update(s1, string1);
		update(s2, string2);

		int drop = 0;

		for (int i = 65; i < 122; i++) {
			if (string1[i] < string2[i]) {
				System.out.println("Can't Form");
				return;
			}

			if (string1[i] > string2[i])
				drop += string1[i] - string2[i];

		}

		System.out.println("Droped character's : " + drop);
	}

	public static void update(String s, int[] a) {

		for (int i = 0; i < s.length(); i++)
			a[s.charAt(i)]++;
	}

}
