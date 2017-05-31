package com.collect;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetClass {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
//	Set<String> animals=new HashSet<>();  		// Gives random order of elements which are added
	
//	Set<String> animals=new LinkedHashSet<>();	// Order in which elements are added
	
	Set<String> animals=new TreeSet<>();		// Natural Order alphabetical order
	animals.add("cat");
	animals.add("dog");
	animals.add("mouse");

	animals.add("elephant");
	animals.add("cat");
	System.out.println("Set 1 is : "+animals);
	
	////////iteration///
	for (String string : animals) {
		System.out.println(string);
	}

	///////contains////
	 if (animals.contains("cat")) 
	 {
		System.out.println("Elemenet is avaiblable ");
	}
	 ///////isEmpty////
	 if (animals.isEmpty()) 
	 {
		System.out.println("Set is empty");
	}
	 
	 
	 ///////intersection/////	 
	 Set<String> animals2=new TreeSet<>();		// Natural Order alphabetical order
	 animals2.add("cat");
	 animals2.add("cat");
	 animals2.add("hen");
	 animals2.add("cook");
	 animals2.add("dog");
		System.out.println("Set 2 is : "+animals2);
		
		
	Set<String> intersections=new HashSet<>(animals);
		
		intersections.retainAll(animals2); 		// keep elements of both the sets i.e. Common
		System.out.println("Common is : "+intersections);
		
		
	Set<String> diffrence = new HashSet<>(animals2);
		
		diffrence.removeAll(animals);			// elemnet not in animals
		System.out.println("Diffrence is : "+diffrence);
		
	}

}
