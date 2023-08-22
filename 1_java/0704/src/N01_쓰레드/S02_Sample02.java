package N01_쓰레드;

import java.util.ArrayList;

class Table{
	String[] dishNames = {"donut","donut","burger"};
	final int MAX_FOOD=6;
	private ArrayList<String> dishes = new ArrayList<>();
	
	public synchronized void add(String dish) {
		if(dishes.size() >= MAX_FOOD)
			return;
		dishes.add(dish);
		System.out.println("Dishes : " + dishes.toString()); // toString 생략가능
	}
	
	public boolean remove(String dishName) {
		synchronized (this) {
			while(dishes.size() == 0) {
				String name = Thread.currentThread().getName();
				System.out.println(name + " is waiting");
				try { Thread.sleep(500); }catch(Exception e) { }
			} // while 종료
			for(int i=0; i<dishes.size(); i++) {
				if(dishName.equals(dishes.get(i))) {
					dishes.remove(i);
					return true;
				}
			}
		} // synchronized 종료
		return false;
	}
	
	public int dishNum() { // 메뉴판 개수 넘겨주는 메서드
		return dishNames.length;
	}
}

class Cook implements Runnable{
	private Table table;

	Cook(Table table) {
		this.table = table;
	}

	@Override
	public void run() {
		while(true) {
			int idx = (int)(Math.random()*table.dishNum());
			table.add(table.dishNames[idx]);
			try { Thread.sleep(100); }catch(Exception e) { }
		}
	}
	
}

class Customer implements Runnable{
	private Table table;
	private String food;
	
	public Customer(Table table, String food) {
		this.table = table;
		this.food = food;
	}
	
	boolean eatFood() {
		return table.remove(food);
	}
	
	@Override
	public void run() {
		while(true) {
			try { Thread.sleep(100); }catch(Exception e) { }
			String name = Thread.currentThread().getName();
			if(eatFood())
				System.out.println(name + " ate a " + food);
			else
				System.out.println(name + " failed to eat");
		}
	}
	
}

public class S02_Sample02 {

	public static void main(String[] args) {
		Table table = new Table();
		new Thread(new Cook(table),"COOK").start();
		new Thread(new Customer(table, "donut"), "손님1").start();
		new Thread(new Customer(table, "burger"), "손님2").start();
		try { Thread.sleep(2000); }catch(Exception e) { }
		System.exit(0);
	}
}
