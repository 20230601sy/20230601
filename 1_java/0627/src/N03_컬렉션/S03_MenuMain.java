package N03_컬렉션;

import java.util.ArrayList;

public class S03_MenuMain {

	public static void main(String[] args) {
		ArrayList<S03_MenuInfo> al = new ArrayList<>();
		al.add(new S03_MenuInfo("아이스크림", 4000, false));
		al.add(new S03_MenuInfo("밀크티", 5800, true));
		al.add(new S03_MenuInfo("딸기무스", 6500, true));
//		System.out.println(al);
		
//		for(int i=0; i<al.size(); i++)
//			System.out.println(al.get(i).totalPrice());
		
		System.out.println(al);
	}

}
