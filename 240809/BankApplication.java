package day04;
import static java.lang.System.out;

import java.util.ArrayList;
import java.util.Scanner;

public class BankApplication {

	 static ArrayList<AccountExam> arrList = new ArrayList<>();
	    static Scanner sc = new Scanner(System.in);
	    
	    public static void main(String[] args) {
	        BankApplication ba = new BankApplication();        
	        while(true) {
	            ba.showMenu();
	            int no = sc.nextInt();
	            switch (no) {
	                case 1:
	                    ba.createAccount();
	                    break;
	                case 2: 
	                    ba.accountList();        
	                    break;
	                case 3:
	                    ba.deposit();
	                    break;
	                case 4:
	                    ba.withdraw();
	                    break;
	                case 5:
	                    out.println("프로그램을 종료합니다.");
	                    return;
	                default:
	                    out.println("잘못된 선택입니다. 다시 선택해주세요.");
	            }
	        }
	    }
	    
	    public void showMenu() {
	        out.println("---------------------------------------------------------");
	        out.println("1. 계좌 생성 | 2. 계좌 목록 | 3. 예금 | 4. 출금 | 5. 종료");
	        out.println("---------------------------------------------------------");
	        out.print("선택> ");
	    }
	    
	    public void createAccount() {
	        out.println("--------------");
	        out.println("-- 계좌생성 --");
	        out.println("--------------");
	        out.print("계좌번호: ");
	        String accountNumber = sc.next();
	        out.print("계좌주: ");
	        String owner = sc.next();
	        out.print("초기입금액: ");
	        int initialBalance = sc.nextInt();

	        AccountExam newAccount = new AccountExam();
	        newAccount.setAccountNumber(accountNumber);
	        newAccount.setOwner(owner);
	        newAccount.setBalance(initialBalance);

	        arrList.add(newAccount);
	        out.println("결과: 계좌가 생성되었습니다.");
	    }
	    
	    public void accountList() {
	        out.println("--------------");
	        out.println("-- 계좌목록 --");
	        out.println("--------------");
	        for (AccountExam account : arrList) {
	            out.println(account.getAccountNumber() + "   " + account.getOwner() + "   " + account.getBalance());
	        }
	    }
	    
	    public void deposit() {
	        out.println("--------------");
	        out.println("-- 예금 --");
	        out.println("--------------");
	        out.print("계좌번호: ");
	        String accountNumber = sc.next();
	        out.print("예금액: ");
	        int amount = sc.nextInt();

	        AccountExam account = findAccount(accountNumber);
	        if (account != null) {
	            account.setBalance(account.getBalance() + amount);
	            out.println("결과: 예금이 성공되었습니다.");
	        } else {
	            out.println("결과: 계좌번호가 없습니다.");
	        }
	    }
	    
	    public void withdraw() {
	        out.println("--------------");
	        out.println("-- 출금 --");
	        out.println("--------------");
	        out.print("계좌번호: ");
	        String accountNumber = sc.next();
	        out.print("출금액: ");
	        int amount = sc.nextInt();

	        AccountExam account = findAccount(accountNumber);
	        if (account != null) {
	            if (account.getBalance() >= amount) {
	                account.setBalance(account.getBalance() - amount);
	                out.println("결과: 출금이 성공되었습니다.");
	            } else {
	                out.println("결과: 잔액이 부족합니다.");
	            }
	        } else {
	            out.println("결과: 계좌번호가 없습니다.");
	        }
	    }
	    // findAccount 가 제일 중요해보임. 
	    // for문으로 list 의 값들을 입력받은 정보랑 비교하고 같으면 같은 list의 값을 리턴시킴.
	    private AccountExam findAccount(String accountNumber) {
	        for (AccountExam account : arrList) {
	            if (account.getAccountNumber().equals(accountNumber)) {
	                return account;
	            }
	        }
	        return null;
	    }
	}
