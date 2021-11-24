package pattern.creation.builder;


// shift + tab => to move multiple selected items backward
// tab         => to move multiple selected items forward

public class BuilderChaining {
	public static void main(String[] args) {
		
		Account account1 = Account.buildAccount()
									.setAccountId(101)
									.setAccountType("savings")
									.build();

		Account account2 = Account.buildAccount()
									.setAccountId(105)
									.setAccountType("current")
									.build();

		System.out.println(account1);
		System.out.println(account1.accountType());
		System.out.println("---------------------");
		System.out.println(account2);
		System.out.println(account2.accountType());
		System.out.println("----------------------");
		System.out.println((account1 == account2) + " " + (account2.equals(account1)));
	}

	public String toString() {
		return "Main method";
	}
}

class Account {

	int accId;
	String accountType;

	public String toString() {
		return accId + " " + accountType;
	}

	public String accountType() {
		return accountType;
	}

	public static Builder buildAccount() {
		return new Account().new Builder();
	}

	class Builder {

		public Builder setAccountId(int id) {
			Account.this.accId = id;
			return this;
		}

		public Builder setAccountType(String type) {
			Account.this.accountType = type;
			return this;
		}

		public Account build() {
			return Account.this;
		}
	}
}