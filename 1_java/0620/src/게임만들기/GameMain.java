package 게임만들기;

import java.util.Scanner;

public class GameMain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("최대 계좌 수량 입력 : ");
		int maxSize = sc.nextInt();
		Behavior b = new Behavior(maxSize);
		
		int choice = 1;
		String job;
		
		while(true) {
			System.out.print("1.캐릭터생성 2.캐릭터삭제 3.캐릭터목록 4.캐릭터속성조회 5.캐릭터이동 6.캐릭터공격 0.종료 : ");
			choice = sc.nextInt();
			if(choice == 0) {
				break;
			}
			switch(choice) {
				case 1:
					if(!b.mkPossible()) {
						System.out.println("신규캐릭터 생성불가");
						break;
					}
					b.mkChar();
					break;
				case 2:
					
					b.closeAccount(accountNumber);
					break;
				case 3: // 3.입금
					accountNumber = b.setAccountNumber("입금할 ");
					System.out.print("money : ");
					money = sc.nextInt();
					b.deposit(accountNumber, money);
					break;
				case 4: // 4.출금
					accountNumber = b.setAccountNumber("출금할 ");
//					System.out.print("password : ");
//					password = sc.nextInt();
					password = b.checkPassword(accountNumber);
					if(password == -1) {
						choice = 0;
						break;
					}
					System.out.print("money : ");
					money = sc.nextInt();
					b.withdraw(accountNumber, money, password);
					break;
				case 5: // 5.계좌조회
					accountNumber = b.setAccountNumber("조회할 ");
					b.getAccountInfo(accountNumber);
					break;
				case 6: // 6.전체조회
					b.getAllAccounts();
					break;
				case 7: // 7.송금
					fromAccount = b.setAccountNumber("송금할 ");
//					System.out.print("password : ");
//					password = sc.nextInt();
					password = b.checkPassword(fromAccount);
					if(password == -1) {
						choice = 0;
						break;
					}
					toAccount = b.setAccountNumber("송금받을 ");
					System.out.print("money : ");
					money = sc.nextInt();
					b.transfer(fromAccount, toAccount, money, password);
					break;
				default:
					System.out.println("잘못 입력하셨습니다.");
			}
		}
	}
}

	}

}
