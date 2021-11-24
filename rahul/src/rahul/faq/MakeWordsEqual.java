package rahul.faq;

public class MakeWordsEqual {

	public static void main(String[] args) {

		System.out.println(minMove("ros", "horse"));
//		System.out.println(minMove("aa", "aa"));
//		System.out.println(minMove("aa", "aa"));
		//System.out.println(minMove("dp", "dilipf"));
		//System.out.println(minMove("abcd", "bbcd"));
		//System.out.println(minMove("abc", "bbd"));

	}

	private static int minMove(String target, String word) {

		return move(target, word, 0, 0);
	}

	private static int move(String target, String word, int move, int t1) {

		int min = Integer.MAX_VALUE;

		if(word.equals(target))	return move;

		for (int i = 0; i < word.length(); i++) {		
	    
			char c = word.charAt(i);
			
			if(t1 < target.length() && c == target.charAt(t1)) {
				min = Math.min(min, move(target, word, move, t1+1));
		    }
			else {
				StringBuilder sb = new StringBuilder();
				sb.append(word);
				sb.deleteCharAt(i);
				
				if(sb.length() >= target.length())
				min = Math.min(min, move(target, sb.toString(), move+1, t1));
				
				if(t1 < target.length()) {
				 sb = new StringBuilder();
				 sb.append(word);
				 sb.setCharAt(i, target.charAt(t1));
				 
				 min = Math.min(min, move(target, sb.toString(), move + 1, t1 + 1));
				}
			}
			
		}

		return min;
	}
}
