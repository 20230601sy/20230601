package N02_overriding;

public class S03_Cat extends S03_Animal {
	String color;
	
	public S03_Cat(String name, String color) {
		super(name);
		this.color = color;
	}

	public void showColor() {
		System.out.println(name + " " + color);
	}
	
	@Override
	public int getAge() {
//		return 6*age;
		if(age==1)
			return 15;
		else
			return 16+4*age;
	}
}
