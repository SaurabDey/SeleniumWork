package com.collect;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

public class MapClass {

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
/////////////HashMap//////////////////
//HashMap<Integer, String> map1= new HashMap<Integer, String>();   //Can also be written as
		//Map<Integer, String> map1= new HashMap<>();
		
////////////LinkedHashMap/////////////
		LinkedHashMap<Integer, String>map1= new LinkedHashMap<>();
///////////Treemap///////////////////
//		TreeMap<Integer, String>map1=new TreeMap<>();
		
														//putting
		map1.put(2, "Rahul");
		map1.put(1, "Saurab");
		map1.put(4, "Vijay");
		map1.put(3, "Jeet");

		System.out.println("First map"+map1);  											//getting
		System.out.println(map1.get(1)); 									//retrive
		
		map1.put(1, "Sagar");  												//override
		
		System.out.println("Second map"+map1);
		
for (Integer key : map1.keySet()) {
			
			String value=map1.get(key);
			
			System.out.println("Key is :"+key+" : "+"Value is : "+value);
		}
		
		
		
	}

}
