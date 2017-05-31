package java;

public class ClassB extends ClassA
{
	
	
	public void methodB()
	{
		System.out.println("methodB of Class B");
		
		super.methodA();
	
		number=1000;
		
		System.out.println(number);
		
		
	}
	
	
	public void methodA()
	{
		System.out.println("methodA of Class B- Shivani");
		
		
	}
//	public void methodA()
//	{
//		System.out.println("methodA of Class B- Shivani");
//	}


}
