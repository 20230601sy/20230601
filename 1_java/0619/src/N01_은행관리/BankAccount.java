/*
 * BankAccount 계좌클래스
 * accountNumber : 계좌번호
 * ownerName : 예금주명
 * money : 잔액
 * 생성자 구현 알아서
 * 계좌에서 입금 메서드 : deposit
 * 계좌에서 출금 메서드 : withdraw
 * 비밀번호 할래? ㄴㄴ 했다 결국 ㅡㅡ
 */
package N01_은행관리;

public class BankAccount {
	String accountNumber;
	String ownerName;
	int money;
	int password;
	int numPwError;
	public BankAccount() {
		accountNumber = "";
		ownerName = "";
		money = 0;
		password = 0;
		numPwError = 0;
	}
	public BankAccount(String accountNumber, String ownerName, int money, int password) {
		this.accountNumber = accountNumber;
		this.ownerName = ownerName;
		this.money = money;
		this.password = password;
		numPwError = 0;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public String getOwnerName() {
		return ownerName;
	}
	public int getMoney() {
		return money;
	}
	public int getPassword() {
		return password;
	}
	public void deposit(int money) {
		this.money += money;
		System.out.println(money + "원 입금완료");
	}
	public void deposit2(int money) {
		this.money += money;
	}
	public void withdraw(int money, int password) {
		if(!validPassword(password))
			return;
		if(this.money < money) {
			System.out.println("잔액부족, 출금불가");
			return;
		}
		this.money -= money;
		System.out.println(money + "원 출금완료");
	}
	public boolean withdraw2(int money, int password) {
		if(!validPassword(password))
			return false;
		if(this.money < money) {
			System.out.println("출금계좌 잔액부족, 출금불가");
			return false;
		}
		this.money -= money;
//		System.out.println(money + "원 출금완료");
		return true;
	}
	public void printAccount() {
		System.out.printf("%s  %s  %,7d원   %04d   (%d)\n", accountNumber, ownerName, money, password, numPwError);
	}
	public boolean validPassword(int password) {
		if(this.password != password) {
			System.out.println("비밀번호 오류");
			numPwError++;
			return false;
		}
		return true;
	}
	public boolean validAccount() {
		if(numPwError >= 5) {
			System.out.println("비밀번호 오류 5회이상, 은행을 방문하세요.");
			return false;
		}
		return true;
	}
}
