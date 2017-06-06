package com.collect;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class ListClass {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
//////  Array  ///////////
		
		int[] arrayvalues=new int[10]; 				//can have Primitive types
		arrayvalues[2]=20; 							//add values to the Array 
													//getting the value using indexes in Array
		System.out.println("Array value "+ arrayvalues[2]);
		
		System.out.println(arrayvalues.length); 	//getting the lenght in the Array
		
		
		
////// List- ArrayList  ///////////
		
		ArrayList<Integer> number=new ArrayList<>();//default length value is 10, cannot have Primitive types
		
													//add values to the Array List
		number.add(10);
		number.add(200);
		number.add(300);
		number.add(300);

	
		System.out.println(number.size()); 			//getting the lenght in the List
		
		System.out.println(number.get(1)); 			//getting the value using indexes
		
		System.out.println("Using For Loop"); 		//getting the value using for loop
		for (int i = 0; i < number.size(); i++) {
			System.out.println(number.get(i));
			
		}
		
		System.out.println("Using For Each");		//getting the value using for- each loop
		for (Integer integer : number) {
			System.out.println(integer);
		}
													//removing values from the Array List
		
		number.remove(number.size()-1);//This is very FAST
		 
		number.remove(0);//This is very SLOW as this will copy the entire array into a new Array

		System.out.println("Using For Each");
		for (Integer integer : number) {
			System.out.println(integer);
		}
	
////// List- ArrayList and Linkedlist ///////////		
		
		List<Integer> arraylist= new ArrayList<>(); 	// good for retrieval operations
		//[0][1][2][3][4][5][6]...
		
		List<Integer> linkedlist= new LinkedList<>();	// good for insertions and deletion in the middle of the list
		//[0]<->[1]<->[2]<->[3]<->[4]<->[5]<->[6]...
		
		timing("arraylist", arraylist);
		timing("linkedlist", linkedlist);
		
		
		
////////Sorting list ////////////////////
		
	List<String> animal=new ArrayList<>();
	
	animal.add("Cat");
	animal.add("Dog");
	animal.add("Giraffe");
	animal.add("Zebra");
	animal.add("Cat");
	
	
	System.out.println(animal);
	Collections.sort(animal);
	System.out.println(animal);
	
	if (animal.contains("Giraffe")) { 						//Use of contains in List
		System.out.println("Element is present");
	}
}
	
	private static void timing(String type, List<Integer> list)
	{
		
		//ADDs values 
		for (int i = 0; i <1E5; i++) 
		{
			list.add(0,i);
			
		}
		System.out.println(list.size());
		
					long start=System.currentTimeMillis();
					
					//ADDs values at the beginning
					for (int i = 0; i <100000; i++) 
					{
						list.add(100,i);
					}
					
					long end=System.currentTimeMillis();
		
		System.out.println("Timing is :"+ ( end - start)+" for "+type);
		
		
		
		
	}
	
	
}
