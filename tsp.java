/* JAVA program to implement Traveling Sales Person Problem using Dynamic Programming.
*/

package TSP;

import java.util.Scanner;

class tsmp
{

	static int MinCost(int n, int[][] cost, int[] path, int start) 
	{
		int[] minpath = new int[n + 1]; // Intermediate minimum path discovered. 
		int[] temp = new int[n + 1]; // Intermediate path to discover minimum path. 
		int mincost = 999, curcost, i, j, k;
		// When we reach the second last node. 
		if (start == n - 1) 
		{
			// Sum of Cost of second last node to last node and cost of last node to first
			// node.(Exit point for recursion)
			return (cost[path[n - 1]][path[n]] + cost[path[n]][1]);
		}
		// 1 iteration per node to be added in the TSP. 
		for (i = start + 1; i <= n; i++) 
		{
			for (j = 1; j <= n; j++) 
			{
				temp[j] = path[j];
			}
			// Interchanging nodes to discover new paths.
			temp[start + 1] = path[i]; 
			temp[i] = path[start + 1];
			// Finding out the cost of the new found path to the remaining nodes and check if it
			// is less than minimum cost.
			if ((cost[path[start]][path[i]] + (curcost = MinCost(n, cost, temp, start + 1))) <mincost)
			{
			mincost = cost[path[start]][path[i]] + curcost; // Assigning the newcalculated
			// minimum cost.
				for (k = 1; k <= n; k++) // Recording the new found minimum path.
					minpath[k] = temp[k];
			}
		}
		for (i = 1; i <= n; i++)
			path[i] = minpath[i]; // Copy the final minimum path to path.
		return mincost;
	}
}


class tsp 
{ 

	public static void main(String[] args) 
	{
		Scanner s = new Scanner(System.in); 
		System.out.println("Enter the number of cities: ");
		int n = s.nextInt();
		if (n == 1) 
		{
			System.out.println("Only one city is present!!!");
			return;
		}
		
		int i, j;
		int[][] cost = new int[n + 1][n + 1];
		int[] path = new int[n + 1];
		
		System.out.println("Enter the cost adjacency matrix: ");
		for (i = 1; i <= n; i++)
			for (j = 1; j <= n; j++)
				cost[i][j] = s.nextInt();
		
		for (i = 1; i <= n; i++)
			path[i] = i;
		
		int mincost = tsmp.MinCost(n, cost, path, 1); 
		
		System.out.println("\nThe minimum cost path is: ");
		for (i = 1; i <= n; i++)
			System.out.print(path[i] + " ---- >");
		System.out.println("1");System.out.println("\nThe mincost is " + mincost);
		s.close();
	}
}
	

/*RESULT
Enter the number of cities: 
4
Enter the cost adjacency matrix: 
0 10 15 20
5 0 9 10
6 13 0 12
8 8 9 0

The minimum cost path is: 
1 ---- >2 ---- >4 ---- >3 ---- >1

The mincost is 35
*/
