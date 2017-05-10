package java;

public class ClassA
{
	public int number= 100;
	
	public void methodA()
	{
		 
		System.out.println("methodA of Class A");
		System.out.println(number);
	}
//----------------------------------------------------------//
	class Inner// Member inner Class
	{
		public void innnermethod()
		{
		System.out.println("Inner Class");
		}
	}
	
	public void methodlocalInnerClass()
	{
		
		class Local //Local inner Class
		{
			public void innermethodlocal()
			{
				System.out.println("innermethodlocal");
			}
		}
		
		Local ref= new Local();
		ref.innermethodlocal();
	}
//----------------------------------------------------------//
	static int data=1000;
	static class Nested
	{
		void methodNested()//non-static method
		{
			System.out.println("methodNested "+ data);
		}
		static void staticmethodNested()//static method
		{
			System.out.println("StaticmethodNested "+ data);
		}
	}
}
