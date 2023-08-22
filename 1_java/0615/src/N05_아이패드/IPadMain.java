package N05_아이패드;

public class IPadMain {

	public static void main(String[] args) throws Exception {
		while(true) {
			IPad ipad = new IPad("ipad");
			if(!ipad.continueOrder())
				break;
			ipad.setScreen();
			ipad.setColor();
			ipad.setMemory();
			ipad.setNetwork();
			ipad.setName();
			ipad.setSerialNum();
			ipad.progress();
			ipad.printOrder();
		}
	}

}
