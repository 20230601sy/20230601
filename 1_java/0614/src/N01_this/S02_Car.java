/* 
 * Car클래스 brand, model, maxSpeed를 가지고 있음
 * Car클래스를 이용해서 기능 수행
 * 1. setBrand(String brand) : 자동차 브랜드 설정
 * 2. setModel(String model) : 자동차 모델 설정
 * 3. setMaxSpeed(int maxSpeed) : 자동차 최고 속도 설정
 * 4. printInfo(): 자동차 정보를 출력
 * <결과 화면>
 * Brand: Tesla
 * Model: Model S
 * Max Speed: 250 km/h
 */
package N01_this;

public class S02_Car {
	String brand, model;
	int maxSpeed;
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public void setMaxSpeed(int maxSpeed) {
		this.maxSpeed = maxSpeed;
	}
	
	public void printInfo() {
		System.out.println("Brand: " + brand);
		System.out.println("Model: " + model);
		System.out.println("Max Speed: " + maxSpeed + " km/h");
	}
}
