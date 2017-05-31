package com.jdbc;

public class Normal 
{

	public static void main(String[] args) {
		
		
		String [] name= new String [2];
		name[0]="Saurab";
		name[1]="Dey";
		name[2]="Jest";
		
		System.out.println(name[2]);
		JDBCCON ref= new JDBCCON();
		ref.jdbcConnection();
		String fusername=ref.getUsername();
		String fpass=ref.getPass();
		
		System.out.println("In our normal class "+fusername +" "+fpass);
	}
}
