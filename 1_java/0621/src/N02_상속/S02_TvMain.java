package N02_상속;

public class S02_TvMain {

	public static void main(String[] args) {
		S02_SmartTv stv = new S02_SmartTv();
		stv.channel = 10;
		stv.channelUp();
		System.out.println(stv.channel);
		stv.displayCaption("hello1");
		stv.caption = true;
		stv.displayCaption("hello2");
	}

}
