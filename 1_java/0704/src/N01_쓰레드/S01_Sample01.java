// 539p 예제
package N01_쓰레드;

class Account{
	private int balance = 1000;

	public int getBalance() {
		return balance;
	}
	public synchronized void withdraw(int money) {
		if(balance >= money) {
			try {
				Thread.sleep(1000);
			}catch(Exception e) {
			}
			balance -= money;
		}
	}
}

class RunnableEx implements Runnable {
	Account account = new Account();
	@Override
	public void run() {
		while(account.getBalance() > 0) {
			int money = (int)(Math.random()*3+1)*100;
			account.withdraw(money);
			System.out.println(Thread.currentThread().getName() + " 잔액 : " + account.getBalance());
		}
	}
}

public class S01_Sample01 {

	public static void main(String[] args) {
//		Thread t1 = new Thread(new RunnableEx());
//		Thread t2 = new Thread(new RunnableEx());
//		t1.start();
//		t2.start();
		Runnable r = new RunnableEx();
		new Thread(r).start(); // 이거는 인스턴스에 담지 않아서 start 시키고 끝, 그 이후엔 접근 불가 
		new Thread(r).start(); // account를 공용으로 사용하려고 이렇게 한 건가 ㄷㄷ
	}

}
