package N01_컬렉션;

import java.util.Comparator;

public class S08_DescComparator implements Comparator<S08_Fruit> {

	@Override
	public int compare(S08_Fruit o1, S08_Fruit o2) {
		if(o1.price < o2.price)
			return 1;
		else if(o1.price == o2.price)
			return 0;
		else
			return -1;
	}

}
