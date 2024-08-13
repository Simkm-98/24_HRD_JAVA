package day06;

class Account {

	private long balance;
	
	public Account() {	 }
	
	public long getBalance() {
		return balance;
	}
	
	public void deposit(int money) {
		balance += money;
	}
	
	public void withdraw(int money) throws InsufficientException {
		if (balance < money) {
			throw new InsufficientException("잔고 부족: " + (money-balance)+" 모자람.");
		}
		balance -= money;
		System.out.println("잔여금액 : " + balance);
	}
}


public class AccountExample {

	public static void main(String[] args) {
		Account account = new Account();
		
		account.deposit(10000);;
		System.out.println("예금액: " + account.getBalance());
		
		try {
			account.withdraw(10000);
		} catch (InsufficientException e) {
			String message = e.getMessage();
			System.out.println(message);
		}
	}
}
