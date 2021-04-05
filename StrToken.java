package P4;
import java.util.*;
/*Scanner, SringTokenizer*/

class cust
{
	String name,dob;
	public void read()
	{
		Scanner s = new Scanner(System.in);
		System.out.println("Enter name & DOB in dd/mm/yy format :");
		name = s.nextLine();
		dob = s.nextLine();
		s.close();		
	}
	public void write()
	{
		StringTokenizer st = new StringTokenizer(dob,"/");
		System.out.println("name :"+name);
		System.out.println("DOB :");
		while(st.hasMoreTokens())
			System.out.println(st.nextToken());
	}
}

public class StrToken {
	public static void main(String[] args)
	{
		cust c = new cust();
		c.read();
		c.write();
	}

}
