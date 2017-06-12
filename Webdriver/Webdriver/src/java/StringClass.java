package java;

public class StringClass {

	public static void main(String[] args)
	{
		
		//------------Immutable
		String s= new String("Saurab");
		s.concat("Dey");
		
		StringBuffer sb= new StringBuffer("Saurab");
		sb.append("Dey");
		
		System.out.println("String "+s);
		
		System.out.println("String Buffer "+sb);
		
		
		//-------------equals method
		String ss= new String("Saurab");
		String ss1= new String("Saurab");
		
		System.out.println(ss==ss1);
		System.out.println(ss.equals(ss1));
		
		
		StringBuffer ssb= new StringBuffer("Saurab");
		StringBuffer ssb1= new StringBuffer("Saurab");
		
		System.out.println(ssb==ssb1);
		System.out.println(ssb.equals(ssb1));
		
		//-----------------Heap and SCP (String Constant Pool)
		//garbage collector doesnot have access to SCP only has access to Heap, so the object gets deleted on JVM shut down
		String snew= new String("Saurab");// 1 object in Heap and 1 object in SCP
		String snormal="Saurab";// 1object in SCP only
		
		System.out.println(snew);
		System.out.println(snormal);
		
		//-----------------3 objects are created 2 in Heap and 1 in SCP
		String sss= new String("Saurab");// 1object in Heap and 1 object in SCP
		String sss1= new String("Saurab");// 1object in Heap---0 object in SCP as 'Saurab' is already present because of the above line so no new object with the same content is created
		
		String ssnormal= "Saurab"; //points to object in SCP as 'Saurab' is already present because of the above line
		String ssnormal1= "Saurab";//points to object in SCP      --!!---

		//-------------Number of objects
		
		String ssobject= new String("Saurab");// 1object in Heap (Saurab) and 1 object in SCP (Saurab) 
		ssobject.concat("Dey");//1object in Heap (SaurabDey)--runtime operation::::
								//and 1 object in SCP (Dey)-- as Dey is a constant
		
		String ssobjectSecond= ssobject.concat("Gaurav");// 1object in Heap (SaurabGaurav) and 1 object in SCP (Gaurav)
		ssobject=ssobject.concat("Khushal"); // 1object in Heap (SaurabKhushal) and 1 object in SCP (Khushal)
		
		//Total 8 object got created- 4 in Heap and 4 in SCP [2 are ready for GC in Heap as no refernce i.e.'Saurab' and 'SaurabDey']
		//ssobject--->SaurabKhushal
		//ssobjectSecond--->SaurabGaurav
		System.out.println("ssobject---> "+ssobject);
		System.out.println("ssobjectSecond---> "+ssobjectSecond);
		
		
	}

}
