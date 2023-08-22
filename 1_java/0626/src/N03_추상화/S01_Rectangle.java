package N03_추상화;

public class S01_Rectangle extends S01_Shape {
	
	private double width, height;
	
	public S01_Rectangle(double width, double height) {
		this.width = width;
		this.height = height;
	}

	@Override
	public double calcArea() {
		return width * height;
	}

}
