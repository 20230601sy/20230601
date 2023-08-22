package N01_캡슐화;

public class S02_BankAccount {
	
	private String accountNumber;
	private int money;
	
//	// 정기예금이라고 가정하면 set가 있으면 문제를 유발할 가능성이 높으므로 세터를 사용하지 못하게 미생성
//	public BankAccount(String accountNumber, int money) {
//		this.accountNumber = accountNumber;
//		this.money = money;
//	}
//	public int getMoney() {
//		return money;
//	}
	
	public S02_BankAccount(String accountNumber) {
		this.accountNumber = accountNumber;
		this.money = 0;
	}
	
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	
	public void deposit(int money) {
		if(money < 0) {
			System.out.println("입금액이 잘못되었습니다.");
//			return;
		} else {
			this.money += money;
			System.out.println(money + "원 입금했습니다.");
		}
	}
	public void withdraw(int money) {
		if(money > this.money || money < 0) {
			System.out.println("잔액이 부족하거나 출금액이 잘못되었습니다. 출금할 수 없습니다.");
//			return;
		} else {
			this.money -= money;
			System.out.println(money + "원 출금했습니다.");
		}
	}
}
