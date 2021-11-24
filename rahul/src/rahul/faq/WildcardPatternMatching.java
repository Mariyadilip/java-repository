package rahul.faq;

public class WildcardPatternMatching {

	public static void main(String[] args) {
		
		String str = "baaabab";
       // String pattern = "*****ba*****ab";
       //  String pattern = "ba*****ab";
      //   String pattern = "ba*ab";
        // String pattern = "a*ab";
        // String pattern = "a*****ab";
       //  String pattern = "*a*****ab";
        // String pattern = "ba*ab****";
        // String pattern = "****";
        // String pattern = "*";
        // String pattern = "aa?ab";
		//String pattern = "ba**?b";
        // String pattern = "b*b";
         //String pattern = "a*a";
       //  String pattern = "baaabab";
       // String pattern = "?baaabab";
       //  String pattern = "*baaaba*";
		//String pattern = "b??*?*c";
		//String pattern = "b*cd";
		String pattern = "b**?c*b";
        
        System.out.println(wildCardMatch(str, pattern));
//		System.out.println(wildCardMatch("baaabab", "*****ba*****ab")); //true
//		System.out.println(wildCardMatch("baaabab", "baaa?ab")); // true
//		System.out.println(wildCardMatch("baaabab", "ba*a?")); //true
//		System.out.println(wildCardMatch("baaabab", "a*ab")); //false
//		System.out.println(wildCardMatch("baaabab", "b*?")); //true
//		System.out.println(wildCardMatch("baaabab", "*"));//true
//		System.out.println(wildCardMatch("baaabab", "*??")); //true
//		System.out.println(wildCardMatch("baaabab", "ba*********abb")); //false
	}
	
	private static boolean wildCardMatch(String text, String pattern) {	

		if(pattern.equals("*"))return true;
		if(text.equals("") && pattern.equals("")) return true;
		if(text.length() < 1 || pattern.length() < 1) return false;        
	
		if(pattern.charAt(0) != '*') {
			if(pattern.charAt(0) == text.charAt(0) || pattern.charAt(0) == '?') 
				{ if(wildCardMatch(text.substring(1, text.length()), pattern.substring(1, pattern.length()))) return true; }
			else
				return false;
		}	
		else {
			for(int j=0 ;j<text.length() ;j++) 
			if(wildCardMatch(text.substring(j), pattern.substring(1)))return true;
		}
		
		return false;
	}
}
