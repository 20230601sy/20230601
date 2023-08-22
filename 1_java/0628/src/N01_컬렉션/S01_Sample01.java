package N01_컬렉션;

import java.util.ArrayList;
import java.util.LinkedList;

public class S01_Sample01 {

	public static void main(String[] args) {
		ArrayList<Integer> al = new ArrayList<>();
		LinkedList<Integer> ll = new LinkedList<>();
		
		long startTime, endTime;
		
		startTime = System.nanoTime();
		for(int i=0; i<10000; i++)
			al.add(0, i);
		endTime = System.nanoTime();
		System.out.println("ArrayList 추가 소요시간	: " + (endTime-startTime) + "ns");
		
		startTime = System.nanoTime();
		for(int i=0; i<10000; i++)
			al.add(i);
		endTime = System.nanoTime();
		System.out.println("ArrayList 순차추가 소요시간	: " + (endTime-startTime) + "ns");
		
		startTime = System.nanoTime();
		for(int i=0; i<10000; i++)
			ll.add(0, i);
		endTime = System.nanoTime();
		System.out.println("LinkedList 추가 소요시간	: " + (endTime-startTime) + "ns");
		
		startTime = System.nanoTime();
		for(int i=0; i<10000; i++)
			al.get(i);
		endTime = System.nanoTime();
		System.out.println("ArrayList 읽기 소요시간	: " + (endTime-startTime) + "ns");
		
		startTime = System.nanoTime();
		for(int i=0; i<10000; i++)
			ll.get(i);
		endTime = System.nanoTime();
		System.out.println("LinkedList 읽기 소요시간	: " + (endTime-startTime) + "ns");
		
		startTime = System.nanoTime();
		for(int i=9999; i>=0; i--)
			al.get(i);
		endTime = System.nanoTime();
		System.out.println("ArrayList 거꾸로 읽기	: " + (endTime-startTime) + "ns");
		
		startTime = System.nanoTime();
		for(int i=9999; i>=0; i--)
			ll.get(i);
		endTime = System.nanoTime();
		System.out.println("LinkedList 거꾸로 읽기	: " + (endTime-startTime) + "ns");
	}
}
