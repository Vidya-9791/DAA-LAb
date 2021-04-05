package P2;
import java.util.*;
class stk
{
	int[] sc;
	int max,top;
	public stk(int n) {
		// TODO Auto-generated constructor stub
		max=n;
		sc= new int[n];
		top = -1;
	}

	
	
	public void push(int ele)
	{
		if(top == max-1)
			System.out.println("Stack overflow");
		else
			sc[++top]=ele;
	}
	
	public int pop()
	{
		if(top == -1)
		{
			System.out.println("Stack Underflow");
			return(-1);
		}
		
		else
			return(sc[top--]);
	}
	
	public void display()
	{
		if(top == -1)
			System.out.println("Stack is Empty");
		else
			System.out.println("The elements of the stack are :");
			for(int i=0;i<max;i++)
				System.out.println(sc[i]+" ");
	}
}

public class stack {
	public static void main(String[] args)
	{
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the size of the stack : ");
		int n = s.nextInt();
		stk sk = new stk(n);
		while(true)
		{
			System.out.println("1.push\n2.pop\n3.dispaly\n4.exit");
			System.out.println("Enter your choice : ");
			int nu = s.nextInt();
			
			switch(nu)
			{
			case 1:
				System.out.println("Eneter an element");
				int e = s.nextInt();
				sk.push(e);
				break;
			case 2:
				int p = sk.pop();
				if(p!=-1)
					System.out.println("The element popped is"+p);
				break;
			case 3:
				sk.display();
				break;
			case 4:
				return;
			default:
				System.out.println("Invalid Choice!!!");
			}
			
		}
		
	}

}
