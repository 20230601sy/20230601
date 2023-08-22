package N02_다형성;

public class S05_Main {

	public static void main(String[] args) {
		
		S05_Player p = new S05_Player();
		
		p.attack();
		System.out.println("===플레이어 공격");
		
		System.out.println("기사로 전직했음");
		p = new S05_Knight();
		p.attack();
		System.out.println("===플레이어 공격");
		
		System.out.println("법사로 전직했음");
		p = new S05_Mage();
		p.attack();
		System.out.println("===플레이어 공격");
	}

}
