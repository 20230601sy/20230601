package N01_캡슐화;

import java.util.Scanner;

public class S02_BankMain {

	public static void main(String[] args) {
		S02_BankAccount a = new S02_BankAccount("3333");
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.print("1. 입금 2. 출금 3. 잔액조회 4. 종료 : ");
			int choice = sc.nextInt();
			if(choice==4)
				break;
			switch(choice) {
				case 1:
					System.out.print("입금액 입력 : ");
					a.deposit(sc.nextInt());
					break;
				case 2:
					System.out.print("출금액 입력 : ");
					a.withdraw(sc.nextInt());
					break;
				case 3:
					System.out.println("잔액 : " + a.getMoney() + "원입니다.");
					break;
			}
			
		}
	}

}
