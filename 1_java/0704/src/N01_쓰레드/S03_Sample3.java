package N01_쓰레드;

import java.util.ArrayList;

class Table1{
	String[] dishNames = {"donut","donut","burger"};
	final int MAX_FOOD=6;
	private ArrayList<String> dishes = new ArrayList<>();
	
	public synchronized void add(String dish) {
		while(dishes.size() >= MAX_FOOD) {
			String name = Thread.currentThread().getName();
			System.out.println(name + " is waiting...");
			try {
				wait();
				Thread.sleep(500);
			} catch(Exception e) {
			}
		}
//		if(dishes.size() >= MAX_FOOD)
//			return;
		dishes.add(dish);
		notify();
		System.out.println("Dishes : " + dishes.toString()); // toString 생략가능
	}
	
	public void remove(String dishName) {
		synchronized (this) {
			String name = Thread.currentThread().getName();
			while(dishes.size() == 0) {
				System.out.println(name + " is waiting");
				try { 
					wait();
					Thread.sleep(500);
				} catch(Exception e) {
				}
			} // while 종료
			while(true) {
				for(int i=0; i<dishes.size(); i++) {
					if(dishName.equals(dishes.get(i))) {
						dishes.remove(i);
						notify();
						return;
					}
				}
				try {
					System.out.println(name + " is waiting...");
					wait();
					Thread.sleep(500);
				} catch(Exception e) {
				}
			}
		} // synchronized 종료
//		return false;
	}
	
	public int dishNum() { // 메뉴판 개수 넘겨주는 메서드
		return dishNames.length;
	}
}

class Cook1 implements Runnable{
	private Table1 table;

	Cook1(Table1 table) {
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

class Customer1 implements Runnable{
	private Table1 table;
	private String food;
	
	public Customer1(Table1 table, String food) {
		this.table = table;
		this.food = food;
	}
	
//	boolean eatFood() {
//		return table.remove(food);
//	}
	
	@Override
	public void run() {
		while(true) {
			try { Thread.sleep(100); }catch(Exception e) { }
			String name = Thread.currentThread().getName();
			table.remove(food);
//			if(eatFood())
				System.out.println(name + " ate a " + food);
//			else
//				System.out.println(name + " failed to eat");
		}
	}
	
}

public class S03_Sample3 {

	public static void main(String[] args) {
		Table1 table = new Table1();
		new Thread(new Cook1(table),"COOK").start();
		new Thread(new Customer1(table, "donut"), "손님1").start();
		new Thread(new Customer1(table, "burger"), "손님2").start();
		try { Thread.sleep(5000); }catch(Exception e) { }
		System.exit(0);
	}
}
