package N05_내부클래스;

public class S02_BtnMain {

	public static void main(String[] args) {
		S02_Button btn = new S02_Button();
		btn.setListener(new S02_Call()); // Call implements Button.OnClick으로 다형성 적용이 되었기 때문에, 자동형변환 됨~ 
		btn.touch();
		btn.setListener(new S02_Message());
		btn.touch();
	}

}
