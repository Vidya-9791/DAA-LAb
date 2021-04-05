package Hamilton;

import java.util.Scanner;

public class hamilton 
{
	static int p[];
	static int flag = 0;
	public static void main(String[] args) 
	{ 
		Scanner s = new Scanner(System.in);
		
		System.out.println("Enter the number of vertices: ");
		int n = s.nextInt();
		int[][] a = new int[n + 1][n + 1];
		p = new int[n + 1];
		int i, j;
		System.out.println("Enter the adjacency matrix: \n(Enter 0 - Not Connected 1 - Connected)");
		for (i = 1; i <= n; i++)
		for (j = 1; j <= n; j++)
			a[i][j] = s.nextInt();
		p[1] = 1; // Mark vertex 1 as visited.
		
		System.out.print("\nHamiltonian Cycle ");
		
		HCycle(n, a, 2);
		
		if (flag == 0)
			System.out.print("does not exist!!!"); 
		s.close();
	}
	//Function to print hamiltonian cycle. 
	static void HCycle(int n, int[][] a, int next) 
	{
		while (true) 
		{
			NextVertex(n, a, next);
			if (p[next] == 0)
			return;
			if (next == n)
			{
				System.out.println();
				for (int i = 1; i <= n; i++)
				System.out.print(p[i] + " -----> ");
				System.out.println(p[1]);
				flag = 1; // Cycle exists.
			} 
			else
				HCycle(n, a, next + 1);
		}
	}


	//Function to find the next vertex in the cycle. 
static void NextVertex(int n, int[][] a, int next) 
{
	int j;
	while (true) 
	{
		p[next] = (p[next] + 1) % (n + 1); // Finds the next vertex.
		if (p[next] == 0)
			return;
		//Check if the next node is connected to previous node(next-1).
		//If true then only cycle is formed. 
		if (a[p[next - 1]][p[next]] != 0) 
		{
			for (j = 1; j <= next - 1; j++) 
			{
				//Check if the new vertex is already there in the cycle. 
				if (p[j] == p[next])
				break;
			}
			//Check if vertex is distinct. 
			if (j == next) 
			{
			//Check if all the vertices are included and check if the last vertex
			//is connected to 1st vertex. Only then cycle is complete. 
			if ((next < n) || ((next == n) && (a[p[n]][p[1]] != 0)))
			return;
			}
		}
	}
}

}

/*RESULTS
Enter the number of vertices: 
5
Enter the adjacency matrix: 
(Enter 0 - Not Connected 1 - Connected)
0 1 0 1 0
1 0 1 1 1
0 1 0 0 1
1 1 0 0 1
0 1 1 1 0

Hamiltonian Cycle 
1 -----> 2 -----> 3 -----> 5 -----> 4 -----> 1

1 -----> 4 -----> 5 -----> 3 -----> 2 -----> 1

Enter the number of vertices: 
5
Enter the adjacency matrix: 
(Enter 0 - Not Connected 1 - Connected)
0 1 0 1 0
1 0 1 1 1
0 1 0 0 1
1 1 0 0 0
0 1 1 0 0

Hamiltonian Cycle does not exist!!!
*/
