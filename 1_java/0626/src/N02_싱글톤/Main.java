package N02_싱글톤;

public class Main {

	public static void main(String[] args) {
		
		Singleton s1 = Singleton.getInstance();
		Singleton s2 = Singleton.getInstance();
		System.out.println("s1 : "+s1+"\ns2 : "+s2); // s1과 s2 같다!!! 객체를 생성한 게 아니라(new를 사용한 게 아니잖슴) 이미 최초에 생성한 애를 가져온 거라는 거! 
	}

}
