package N01_컬렉션;

public class S08_Fruit {
	String name;
	int price;
	public S08_Fruit(String name, int price) {
		this.name = name;
		this.price = price;
	}
	@Override
	public String toString() {
		return "Fruit [name=" + name + ", price=" + price + "]";
	}
}
