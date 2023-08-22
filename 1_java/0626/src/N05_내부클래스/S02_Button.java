package N05_내부클래스;

public class S02_Button {
	private OnClick listener; // OnClick은 인터페이스이기 때문에 인스턴스 생성불가, 인터페이스와 관련된 인스턴스만 담을 수 있음, 여기서는 Call과 Message
	/*
	 * 화면을 클릭하거나 키보드를 누르거나 하는 거를 이벤트라고 하는데,
	 * 특정 이벤트가 작동되었을 때 기능을 하는 것을 이벤트리스너라고 함
	 * interface와 변수 순서가 상관 없는 것은 class가 이미 메모리에 올라가있기 때...문
	 */
	public void setListener(OnClick listener) {
		this.listener = listener;
	}
	public void touch() {
		listener.click(); // listener의 형태가 뭐가 됐든, 거기에 맞는 click() 메서드를 호출함!
	}
	interface OnClick{
		public void click(); // OnClick을 구현한 클래스들은 무조건 click() 메서드를 포함하고 있음!
	}

}
