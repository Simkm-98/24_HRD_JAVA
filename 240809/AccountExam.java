package day04;

public class AccountExam {
	// balance 필드 은닉화 하기
	
	private int balance;
	String accountNumber;
	String accOwner;
	public AccountExam() {
		
	}
	
	//상수 필드 정의하기
		
	static final int MIN_BALANCE = 0;
	static final int MAX_BALANCE = 1000000;
	
	// getter, setter 메소드 정의
	
	public int getBalance() {
		return balance;
	}
	
	public void setBalance(int balance) {
		
		if (balance < AccountExam.MIN_BALANCE || balance > AccountExam.MAX_BALANCE) {
			return;
		} else {
			this.balance = balance;
		}
	}
	
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	
	public String getAccountNumber() {
		return accountNumber;
	}
	
	public void setOwner(String owner) {
		this.accOwner = owner;
	}
	
	public String getOwner() {
		return accOwner;
	}
	
	
	void getInfo() {
		System.out.print(accountNumber + "\t" + accOwner + "\t" + balance);
	}
	
}
