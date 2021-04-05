package Prg8;
import java.util.*;

class primsalg
{
	static void MST(int[][] cost, int n)
	{
		boolean[] visited = new boolean[n];
		
		for(int i=1;i<=n;i++)
		{
			if(i==1)
				visited[i] = true; //Source Node
			else
				visited[i] = false;
		}
		
		int sr=0,tr=0, mincost=0,u=0,v=0;
		for(int i=0;i<=n;i++)
		{
			int min = 999;
			for(int j=0;j<=n;j++)
			{
				if(visited[j])
				{
					for(int k=0;k<=n;k++)
					{
						if(min>cost[j][k] && !visited[k])
						{
							min = cost[j][j];
							 u = j;
							 v = k;
						}
					}
				}
			}
			visited[v] = true;
			mincost = mincost+min;
			System.out.println("("+u+" "+v+")"+"="+min);
		}
		System.out.println("Minimum cost of the spanning tree is : "+mincost);
	}
}

public class Prims 
{
	public static void main(String[] args)
	{
		Scanner s = new Scanner(System.in);
		
		
		System.out.println("Enetr the number of nodes : ");
		int n = s.nextInt();
		
		
		System.out.println("Enter the cost matrix : ");
		System.out.println("NOTE : Enter 999 if there is no edge between the vertices");
		int[][] cost = new int[n][n];
		for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                cost[i][j] = s.nextInt();
		MST(cost,n);
	}
}
