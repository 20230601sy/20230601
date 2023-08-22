package N01_은행관리;

import java.util.Scanner;

public class BankMain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//		System.out.println("최대 계좌 수량 입력 : ");
//		int maxSize = sc.nextInt();
		int maxSize = 4; 						// 테스트용 초기 입력
		String[] fName = {"김", "이", "박"};		// 테스트용 초기 입력
		String[] Name = {"현", "수", "찬"};		// 테스트용 초기 입력
		Bank b = new Bank(maxSize);
		b.numAccounts = 3;						// 테스트용 초기 입력
		for(int i=0; i<b.numAccounts; i++) {	// 테스트용 초기 입력
			b.accounts[i] = new BankAccount();
			b.accounts[i].accountNumber = "a" + i; // 입력 귀찮 "1002-980-898-00" + i;
			b.accounts[i].ownerName = fName[(int)(Math.random()*3)] + Name[i%3] + Name[(i+1)%3];
			b.accounts[i].money = (int)(Math.random()*100)*10000;
			b.accounts[i].password = (int)(Math.random()*10000);
		}
		b.accounts[0].numPwError=4;
		System.out.println("**테스트용 초기입력");
		b.getAllAccounts();
		
		int choice = 1;
		String accountNumber, fromAccount, toAccount;
		String ownerName;
		int money;
		int password;
		while(choice != 0) { // true
			System.out.print("1.계좌생성 2.계좌삭제 3.입금 4.출금 5.계좌조회 6.전체조회 7.송금 0.종료 : ");
			choice = sc.nextInt();
			if(choice == 0) {
				break;
			}
			switch(choice) {
				case 1: // 1.계좌생성
					if(!b.createPossible()) {
						System.out.println("신규계좌 생성불가");
						break;
					}
//					System.out.print("계좌번호 : ");
//					accountNumber = sc.next(); 
					accountNumber = b.setAccountNumber(true, "신규 ", "해당 계좌번호 사용중, 신규 생성불가");
					System.out.print("예금주명 : ");
					ownerName = sc.next();
					System.out.print("password : ");
					password = sc.nextInt();
					System.out.print("money : ");
					money = sc.nextInt();
					BankAccount account = new BankAccount(accountNumber, ownerName, money, password);
					b.createAccount(account);
					break;
				case 2: // 2.계좌삭제
					accountNumber = b.setAccountNumber("삭제할 ");
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
