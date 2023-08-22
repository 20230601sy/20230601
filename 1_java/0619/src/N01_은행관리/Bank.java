/*
 * Bank 은행클래스
 * accounts 배열 : 가입된 계좌들을 저장
 * numAccounts : 가입된 전체 계좌수
 * 최대 관리 계좌수는 정해져있지 않음
 * createAccount : 신규 계좌 생성(추가)
 * closeAccount : 계좌 폐쇄(삭제)
 * deposit : 선택한 계좌에서 입금하는 메서드
 * withdraw : 선택한 계좌에서 출금하는 메서드
 * getAccountInfo : 선택한 계좌 정보 조회
 * getAllAccounts : 전체 계좌 정보 조회
 * 계좌간 송금 할래? ㄴㄴ 했다 결국 ㅡㅡ
 */
package N01_은행관리;

import java.util.Scanner;

public class Bank {
	BankAccount[] accounts;
	int numAccounts;
	Scanner sc = new Scanner(System.in);
	
	public Bank(int maxSize) {
		accounts = new BankAccount[maxSize];
		numAccounts = 0;
	}
	public boolean createPossible() {
		if(numAccounts < accounts.length)
			return true;
		return false;
	}
	public void createAccount(BankAccount account) {
//		if(!createPossible()) {
//			System.out.println("신규계좌 생성불가");
//			return;
//		}
//		int index = findAccount(account.getAccountNumber());
//		if(index != -1) {
//			System.out.println("해당 계좌번호 사용중, 신규 생성불가");
//			return;
//		}
		accounts[numAccounts++] = account;
		System.out.println("신규계좌 생성완료");
	}
	public int findAccount(String accountNumber) {
		for(int i=0; i<numAccounts; i++) {
			if(accountNumber.equalsIgnoreCase(accounts[i].getAccountNumber())) {
				return i;
			}
		}
//		System.out.println("해당입력 계좌없음");
		return -1;
	}
	public void closeAccount(String accountNumber) {
		int index = findAccount(accountNumber);
//		if(index == -1)
//			return;
		for(int i=index; i<numAccounts-1; i++)
			accounts[i] = accounts[i+1];
		numAccounts--;
		System.out.println("해당계좌 삭제완료");
	}
	public void deposit(String accountNumber, int money) {
		int index = findAccount(accountNumber);
//		if(index == -1)
//			return;
		System.out.print(accountNumber + " 계좌 ");
		accounts[index].deposit(money);
	}
	public void withdraw(String accountNumber, int money, int password) {
		int index = findAccount(accountNumber);
		if(index == -1)
			return;
		if(!accounts[index].validAccount())
			return;
		System.out.print(accountNumber + " 계좌 ");
		accounts[index].withdraw(money, password);
	}
	public void transfer(String fromAccount, String toAccount, int money, int password) {
		int indexFromAccount = findAccount(fromAccount);
		if(indexFromAccount == -1)
			return;
		if(!accounts[indexFromAccount].validAccount())
			return;
		int indexToAccount = findAccount(toAccount);
		if(indexToAccount == -1)
			return;
		if(!accounts[indexFromAccount].withdraw2(money, password))
			return;
		accounts[indexToAccount].deposit2(money);
		System.out.println("송금완료");
	}
	public void getAccountInfo(String accountNumber) {
		int index = findAccount(accountNumber);
		if(index == -1)
			return;
		accounts[index].printAccount();
	}
	public void getAllAccounts() {
		if(numAccounts == 0) {
			System.out.println("현재 등록계좌 없음");
			return;
		}
		System.out.println("===================================");
		System.out.println("no  예금주  잔액       비밀번호(오류횟수)");
		for(int i=0; i<numAccounts; i++) {
			accounts[i].printAccount();
		}
		System.out.println("===================================");
	}
	public String setAccountNumber(Boolean isNew, String msg1, String msg2) {
		String accountNumber;
		Boolean checkNew;
		while(true) {
			System.out.print(msg1 + "계좌번호 : ");
			accountNumber = sc.next();
			checkNew = (findAccount(accountNumber)==-1);
			if(checkNew == isNew)
				break;
			System.out.println(msg2);
		}
		return accountNumber;
	}
	public String setAccountNumber(String msg) {
		return setAccountNumber(false, msg, "해당입력 계좌없음, 다시 입력하세요.");
	}
	public int checkPassword(String accountNumber) {
		int password;
		int index = findAccount(accountNumber);
		while(accounts[index].validAccount()) {
			System.out.print("비밀번호 : ");
			password = sc.nextInt();
			if(accounts[index].validPassword(password))
				return password;
		}
		return -1;
	}
}
