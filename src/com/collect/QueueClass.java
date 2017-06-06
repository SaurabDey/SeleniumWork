package com.collect;

import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class QueueClass {

	public static void main(String[] args) 
	{
		Queue<Integer> numbers= new ArrayBlockingQueue<>(4);
		// <-000000000000<-
//		System.out.println("Number in queue: "+numbers.element()); //Check the elements presents in queue
//		
//		numbers.add(10);										//Adding value to the Queue
//		numbers.add(20);
//		numbers.add(30);
//		numbers.add(40);
//		
//		System.out.println("Number in queue: "+numbers.element());
//		
//		try {													//Check the exception when we enter value beyond the capacity
//			numbers.add(50);
//		} catch (Exception e) {
//			System.out.println("Trying to add 5th number");
//		}
//		
//		
//		System.out.println(numbers);
//		
//		Integer value= numbers.remove();						//Remove and store the value which is being removed 
//		System.out.println("Removed : "+ value);
//		Integer value1= numbers.remove();
//		System.out.println("Removed : "+ value1);
//		
//		numbers.remove();
//		
//		System.out.println("Number in queue: "+numbers.element());
//		numbers.remove();
//		numbers.remove();
//		numbers.remove();
//		
//		System.out.println(numbers);
//		
		
		Queue<Integer> numbers2= new ArrayBlockingQueue<>(4);
		
		numbers2.offer(10);							//Adding value to the Queue using offer
		numbers2.offer(20);
		numbers2.offer(30);
		numbers2.offer(40);
		numbers2.offer(50);
	
		System.out.println("Values are "+numbers2);
		
//		for (int i = 0; i < numbers2.size(); i++) {
//			System.out.println("For loop :"+numbers2.);
//			
//		}
		
		for (Integer value : numbers2) {
			System.out.println("Values using for each are:" + value);
		}
		
		
		Iterator<Integer> num=numbers2.iterator();
		
		while (num.hasNext()) {
			
			Integer value=num.next();
			System.out.println("Using Iterator :"+value);
			
		}
		
		
		
		
//		Iterator<Integer> it=numbers2.iterator();// For loop uses this intenally
//		while (it.hasNext()) {
//		Integer value=it.next();
//			System.out.println(value);
//		
//		if (value==20) {
//			it.remove();
//		}
//	}
		
		
		
		System.out.println(numbers2);
		System.out.println("First Value :"+numbers2.peek());
		numbers2.poll();							//removing value using poll
		numbers2.poll();
		numbers2.poll();
		numbers2.poll();
		numbers2.poll();
		
		
		System.out.println(numbers2);
		
		
		System.out.println("First Value :"+numbers2.peek());  //Checking the first value using peek
	}

}
