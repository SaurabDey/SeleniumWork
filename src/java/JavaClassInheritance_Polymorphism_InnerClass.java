package java;

public class JavaClassInheritance_Polymorphism_InnerClass
{


	public static void main(String args[])
	{
		System.out.println("--------------------------");
		ClassB ref= new ClassB();
		ref.methodA();
		ref.methodB();
		
		
		System.out.println("--------------------------");
		ClassA ref1= new ClassA();
		ref1.methodA();
		
		System.out.println("--------------------------");//Run time Polymorphism
		ClassA ref2= new ClassB();
		ref2.methodA();
	
		
		System.out.println("--------------------------");//Inner Class
		ClassA ref3= new ClassA();
		ClassA.Inner in= ref3.new Inner();
		in.innnermethod();//member inner class
		
		ref3.methodlocalInnerClass();//local inner class
		
		System.out.println("--------------------------");//static nested class
		ClassA.Nested ref4= new ClassA.Nested();
		ref4.methodNested();//non static nested class method
		
		ClassA.Nested.staticmethodNested();//static nested class method
		
	}

}
