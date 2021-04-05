package P3;

import java.util.Scanner;

class staff
{
	String sid, name;
	long ph;
	int sal;
	
	public void read()
	{
		Scanner s = new Scanner(System.in);
		System.out.println("Enter StaffId, Name, Phone, Salary: ");
		sid = s.nextLine();
		name = s.nextLine();
		ph = s. nextLong();
		sal = s.nextInt();
	}
	
	
	public void write()
	{
		System.out.println(sid+"\t"+name+"\t"+ph+"\t"+sal);
	}
	
}

class Teaching extends staff
{
	String domain;
	int pub;
	public void read()
	{
		Scanner s = new Scanner(System.in);
		super.read();
		System.out.println("Enete Domain & No. of Publications : ");
		domain = s.nextLine();
		pub = s.nextInt();
	}
	public void write()
	{
		super.write();
		System.out.println(domain+"\t"+pub);
	}
}

class Technical extends staff
{
	String skills;
	public void read()
	{
		Scanner s = new Scanner(System.in);
		super.read();
		System.out.println("Enter the skills");
		skills = s.nextLine();
	}
	public void write()
	{
		Scanner s = new Scanner(System.in);
		super.write();
		System.out.println("Skills "+skills);
	}
}

class contract extends staff
{
	int contract;
	public void read()
	{
		super.read();
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the Contract in  years :");
		contract = s.nextInt();
	}
	public void write()
	{
		super.write();
		System.out.println("Contract"+"\t"+contract);
	}
}


public class ORG
{
	public static void main(String[] args)
	{
		Scanner s = new Scanner(System.in);
		
		
		while(true)
		{
			System.out.println("OBJECT CREATION");
			System.out.println("1: Teaching \n2: Technical \n3: Contract \n4: Exit"); 
			System.out.println("Eneter your choice");
			int ch = s.nextInt();
			
		switch (ch)
		{
		case 1:
			staff sf1 = new Teaching();
			sf1.read();
			sf1.write();
			break;
		case 2:
			staff sf2 = new Technical();
			sf2.read();
			sf2.write();
			break;
		case 3:
			staff sf3 = new contract();
			sf3.read();
			sf3.write();
			break;
		case 4:
			return;
		default:
			System.out.println("Invalid choice");
		}
		}
	}
	

}
