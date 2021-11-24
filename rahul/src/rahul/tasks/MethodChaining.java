package rahul.tasks;

public class MethodChaining {

	public static void main(String[] args) {
		
		int result = Chain.number(2)
						.add(4)
						.sub(2)
						.add(6)
						.multiply(2)
						.divide(2)
						.get();
		
		System.out.println(result);
	}
}

class Chain{
	
	private int result;
	private Chain chain;
	
	static Chain number(int n) {
		Chain c = new Chain();
		c.result = n;
		c.chain = c;
		return c.chain;
	}
	
	Chain add(int n) {
		result += n;
		return chain;
	}
	
	Chain sub(int n) {
		result -= n;
		return chain;
	}
	
	Chain multiply(int n) {
		result *= n;
		return chain;
	}
	
	Chain divide(int n) {
		result /= n;
		return chain;
	}
	
	int get() {
		return result;
	}
}