package N02_상속;

public class S02_SmartTv extends S02_Tv{
	boolean caption;
	public void displayCaption(String text) {
		if(caption)
			System.out.println(text);
	}
}
