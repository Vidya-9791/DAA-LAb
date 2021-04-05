package Programs;

import java.util.*;

class st
{
	String USN, Name, Branch;
	long Phone;
}

public class student 
{
	public static void main(String[] args)
	{
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the number of students: ");
		int n = s.nextInt();
		
		st[] stu_arr = new st[n];
		int i;
		
		for (i = 0; i < n; i++)
			stu_arr[i] = new st();
		
		for (i = 0; i < n; i++) 
		{
			System.out.println("\nEnter the USN, Name, Branch and Phone No. of student: ");
			stu_arr[i].USN = s.next();
			stu_arr[i].Name = s.next();
			stu_arr[i].Branch = s.next();
			stu_arr[i].Phone = s.nextLong();
		}
		
		System.out.println("\nThe details of Students are: ");
		for (i = 0; i < n; i++) 
		{
			System.out.println("USN: " + stu_arr[i].USN + "\nNAME: " + stu_arr[i].Name +"\nBRANCH: "+ stu_arr[i].Branch + "\nPHONE NO: "+ stu_arr[i].Phone + "\n");
		}
	}
}
