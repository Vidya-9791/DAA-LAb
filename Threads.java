package P3B;

import java.util.Random;

class randomnum extends Thread
{
	int res;
	static int n;
	
	public synchronized int randomgen()
	{
		Random r = new Random();
		n=r.nextInt(5);
		System.out.println("Random number :"+n);
		return n;
	}
	
	public void run() //Override run method. Entry point for a thread
	{
		while(true)
		{
			try
			{
				res = randomgen();
				Thread.sleep(1000);
			}
			
			catch(InterruptedException e)
			{
				e.printStackTrace();
			}
		}
	}
	
}

class square extends Thread
{
	public void computesquare(int s1)
	{
		System.out.println("Squared number : " + (s1*s1));
	}
	public void run()
	{
		while(true)
		{
			try
			{
				computesquare(randomnum.n);
				Thread.sleep(1000);
			}
			catch(InterruptedException e)
			{
				e.printStackTrace();
			}
		}
	}
}

class cube extends Thread
{
	public void computecube(int c)
	{
		System.out.println("Cubed number :"+ (c*c*c));
	}
	
	public void run()
	{
		while(true)
		{
			try
			{
				computecube(randomnum.n);
				Thread.sleep(1000);
			}
			catch(InterruptedException e)
			{
				e.printStackTrace();
			}
		}
	}
	
}

public class Threads 
{
	public static void main (String[] args)
	{
		
		randomnum r = new randomnum();
		r.start();
		
		square sq = new square();
		sq.start();
		
		cube cb = new cube();
		cb.start();
		
		
	}

}
