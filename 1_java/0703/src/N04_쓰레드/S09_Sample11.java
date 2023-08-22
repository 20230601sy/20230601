package N04_쓰레드;
class IThread extends Thread{

	@Override
	public void run() {
		try {
			int i=1;
			while(true) {
				System.out.println(i++);
				Thread.sleep(1000);
			}
		} catch (InterruptedException e) {
		}
		System.out.println("쓰레드 종료");
	}
	
}
public class S09_Sample11 {

	public static void main(String[] args) {
		Thread t = new IThread();
		t.start();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
		}
		t.interrupt();
		/* 
		 * InterruptedException을 발생시켜서 중지시키는 거, 그러니까 식당에서 저기요 같은 느낌!
		 * 그런데 잠깐이라도 멈춰 있어야 중단이 되는 거 (이런 조건이 걸림)
		 * 그래서 위에 sleep이 주석처리되어 있어서 계속 실행중인 거면 인터럽트 발생이 안됨
		 * "대기하는 도중에 생기는 문제"를 발생시키지 못함
		 * 데드락, 교착상태 기약없이 무한정 기다리는 상태
		 * 어쨌든 interrupt()는 안전하게 중지시킬 수 있는 방법 중 하나...sleep 같은 게 있어야 한다는 거 꼭 확인 필요!
		 * 메서드 이용 말고 flag를 이용해서 중지하는 방법도 있다심... 용어가 여기서도 나오는 건가 으으으
		 */
		System.out.println("메인 종료");
	}

}
