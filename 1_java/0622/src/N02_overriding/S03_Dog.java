package N02_overriding;

public class S03_Dog extends S03_Animal {
	String breed;

	public S03_Dog(String name, String breed) {
		super(name);
		this.breed = breed;
	}
	
	public void showBreed() {
		System.out.println(name + " " + breed);
	}

	@Override
	public int getAge() {
//		return 5*age;
		return 31 + (int) (16*Math.log(age));
	}

}
