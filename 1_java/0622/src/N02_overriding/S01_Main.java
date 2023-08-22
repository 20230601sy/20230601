package N02_overriding;

public class S01_Main {

	public static void main(String[] args) {
		S01_Parent p = new S01_Parent();
		S01_Child c = new S01_Child();
		p.showInfo(30);
		c.showInfo(10); // 
	}

}
