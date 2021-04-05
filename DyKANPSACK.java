// JAVA program to implement 0/1 Knapsack problem using Dynamic Programming method.
package Prg6A;
import java.util.*;

public class DyKNAPSACK 
{
	static int DyKanpsack(int n,int[] weights,int[] profits,int c)
	{
		if (n == 0 || c == 0)
			return 0;
		
		// If weight of the nth item is more than Knapsack capacity W, then this item cannot be
		// included in the optimal solution. 
		if (weights[n - 1] > c)
			return DyKanpsack(n-1, weights, profits, c);
		// Return the maximum of two cases:
		// (1) nth item included
		// (2) not included 
		else
			return max(profits[n - 1] + DyKanpsack(n - 1, weights, profits, c - weights[n - 1]),DyKanpsack(n - 1, weights, profits, c));
	}
	
	
	static int max(int a, int b) 
	{
		if (a > b)
			return a;
		else
			return b;
	}

		
	public static void main(String[] args) 
	{
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the number of items: ");
		int n = s.nextInt();
		int[] weights = new int[n]; 
		int[] profits = new int[n];
		int i;
		
		System.out.println("Enter the weights and corresponding profits: ");
		for (i = 0; i < n; i++)
		{
			weights[i] = s.nextInt(); 
			profits[i] = s.nextInt();
		}
		
		System.out.println("Enter the capacity: ");
		int c = s.nextInt();
		
		int totprofit = DyKanpsack(n,weights,profits,c);
		
		System.out.println("\nMaximum Profit: " + totprofit);
		s.close();
	}
}
