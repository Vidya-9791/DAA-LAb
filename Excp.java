package P3A;

import java.util.*;

public class Excp {
	public static void main(String[] args)
	{
		Scanner s = new Scanner(System.in);
		int a,b;
		System.out.println("Enter the values of a & b : ");
		a = s.nextInt();
		b = s.nextInt();
		
		try
		{
			float c = a/b;
			System.out.println("a/b = "+c);
		}
		catch(Exception e)
		{
			//e.printStackTrace();
			System.out.println(e);
		}
		s.close();
	}
}
