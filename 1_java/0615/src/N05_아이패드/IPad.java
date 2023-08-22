package N05_아이패드;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class IPad {
	int screen; // 화면 크기
	int color; // 색상, 컬러 종류가 많으면 보통은 배열로 만들고 인덱스로 뽑아오기도 한다심
	int memory; // 용량
	int network; // 네트워크
	String name; // 각인 설정 시 이름 저장
	String productDate; // 생산 일자, 객체 생성될 때 1번만 
	String serialNum; // 일련번호
	static int cnt = 0; // 생산 대수
	
	Scanner sc = new Scanner(System.in);
	
	public IPad(String name) {
		this.name = name;
		Date now = new Date(); // java.util.Date 사용
		SimpleDateFormat sdf = new SimpleDateFormat("yyMMdd");
		/*
		 * System.out.println(now); // → Thu Jun 15 14:33:40 KST 2023
		 * yyMMdd로 변경하려고 할 때 SimpleDateFormat 사용, 생성할 때 이미 형식을 지정해주넹
		 * 위의 MM의 M은 대문자인데, 분과 구분되기 위함임
		 * 둘다 import 해야 함
		 */
		productDate = sdf.format(now);
		cnt++;
	}
	
	// 제품 구입 여부 선택 메서드
	// iPad 제품 구입하기: Yes or No 선택 기능(반복구매 가능, while문 처리)
	public boolean continueOrder() {
		System.out.print("구매하시려면 yes, 아니면 no를 입력 : ");
		String isOrder = sc.next();
		if(isOrder.equalsIgnoreCase("yes")) // YES, yEs 같은 거 처리해주기 위한 메서드
			return true;
		else
			return false;
	}
	public void setScreen() {
		while(true) { // while 대신 setScreen() 재귀함수처럼 사용가능하긴 한데, return type이 void라... 보통은 return setScreen(); 그치만 재귀함수는 반복문이라는 대체제가 있기도 해서 사용빈도가 그렇게 높지 않음, 나중에 한 번 보긴 할거라심
			System.out.print("디스플레이 선텍 [1]11인치 [2]12.9인치 : ");
			screen = sc.nextInt();
			if(screen == 1 || screen == 2)
				return; // break;도 가능한데 그냥 메서드 종료해도 되니까~
			System.out.println("잘못 입력하셨습니다.");
		}
	}
	public void setColor() {
		while(true) {
			System.out.print("색상 선텍 [1]스페이스그레이 [2]실버 : ");
			color = sc.nextInt();
			if(color == 1 || color == 2)
				return;
			System.out.println("잘못 입력하셨습니다.");
		}
	}
	public void setMemory() {
		while(true) {
			System.out.print("용량 선텍 [1]128GB [2]256GB [3]512GB [4]1TB : ");
			memory = sc.nextInt();
			if(memory >= 1 && memory <= 4)
				return;
			System.out.println("잘못 입력하셨습니다.");
		}
	}
	public void setNetwork() {
		while(true) {
			System.out.print("네트워크 선텍 [1]WIFI [2]Wifi + Cellular : ");
			network = sc.nextInt();
			if(network == 1 || network == 2)
				return;
			System.out.println("잘못 입력하셨습니다.");
		}
	}
	public void setName() {
		System.out.print("각인 서비스 하시겠습니까 ? [yes/no] : ");
		String isService = sc.next(); // yes/no, on/off 같은 거 변수명을 보통 is붙여서 사용하기도 한다심
		if(isService.equalsIgnoreCase("yes")) {
			System.out.print("이름 입력 : ");
			name = sc.next();
		}
	}
	// iPad + 인치 + 메모리 + W/C + 제조일 + 생산댓수
	public void setSerialNum() {
		String screenStr = (screen == 1)? "11" : "13";
		String[] memStr = { "128", "256", "512", "1024" }; // -1 대신에 0번방에 ""를 추가해서 쓰는 거는 취향차이
		String netStr = (network == 1)? "W" : "C";
		serialNum = "iPad" + screenStr + memStr[memory-1] + netStr + productDate + cnt;
	}
	public void progress() throws Exception{
		int cnt = 0;
		int rapid = 10;
		while(true) {
			Thread.sleep(300*rapid); // millisecond 일시 정지 기능 메서드, 예외처리를 강요하는 놈이기 때문에 throws Exception을 넣어야 하는데 나중에 다 배울 거임 
			cnt++;
			System.out.println("제작중 입니다. [" + cnt*rapid + "%]"); // 이클립스에서는 캐리지리턴을 줄바꿈으로 처리되기 때문에 IDE의 한계로 계속 증가되는 것처럼은 못하고 계속 출력되게끔까지만 할 수 있음...
			if(cnt>=100/rapid)
				break;
		}
	}
	public void printOrder() {
		String[] scrType = { "11인치", "12.9인치" };
		String[] colType = { "스페이스그레이", "실버" };
		String[] memType = { "128GB", "256GB", "512GB", "1TB" };
		String[] netType = { "Wifi", "Wifi + Cellular" };
		System.out.println("====주문 정보 출력====");
		System.out.println("화면 크기 : " + scrType[screen-1]);
		System.out.println("제품 색상 : " + colType[color-1]);
		System.out.println("제품 용량 : " + memType[memory-1]);
		System.out.println("네트워크 : "+ netType[network-1]);
		System.out.println("이름 : " + name);
		System.out.println("일련번호 : " + serialNum);
	}
}
