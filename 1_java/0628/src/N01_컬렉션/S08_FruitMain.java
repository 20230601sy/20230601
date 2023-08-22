package N01_컬렉션;

import java.util.TreeSet;

public class S08_FruitMain {

	public static void main(String[] args) {
		TreeSet<S08_Fruit> fd = new TreeSet<>(new S08_DescComparator());
		fd.add(new S08_Fruit("수박", 16000));
		fd.add(new S08_Fruit("딸기", 10000));
		fd.add(new S08_Fruit("포도", 20000));
		System.out.println(fd);
		// [Fruit [name=복숭아, price=25000], Fruit [name=수박, price=18000], Fruit [name=키위, price=10000]]
		
		
		TreeSet<S08_Fruit> fa = new TreeSet<>(new S08_AscComparator());
		fa.add(new S08_Fruit("멜론", 15000));
		fa.add(new S08_Fruit("복숭아", 25000));
		fa.add(new S08_Fruit("키위", 10000));
		System.out.println(fa);
		// [Fruit [name=키위, price=10000], Fruit [name=수박, price=18000], Fruit [name=복숭아, price=25000]]

	}

}
