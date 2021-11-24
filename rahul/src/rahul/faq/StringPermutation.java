package rahul.faq;


public class StringPermutation {

	public static void main(String[] args) {
		
	permute("abc");
		//System.out.println(swap("dilip", 0, 3));
	}
	
	public static void permute(String str) {
		
		permuteString(str.toCharArray(), 0);
	}
	
	private static void permuteString(char[] str, int index) {
		
		if(index == str.length) {System.out.println(str);return;}
		
		for(int i = index ; i<str.length ; i++) {
			
			permuteString(str, i + 1);
			  swap(str, index, i);

		    permuteString(str, i + 1);
		}
	}
	
	private static void swap(char[] str, int i, int j) {
		
		char t = str[i];
		str[i] = str[j];
		str[j] = t;
	}
}
