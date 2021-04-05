package Prg7;
//JAVA program to find shortest path from given vertex to all other vertices using Dijkstra's Algorithm

import java.util.*;

public class Dijkstra 
{
	static int[] dijkstra(int adj[][], int src) 
	{
        int n = adj.length;
        int[] dist = new int[n];
        boolean[] visited = new boolean[n];
        int min_dist, unvis = -1;

        for (int i = 0; i < n; i++) 
        {
            dist[i] = adj[src - 1][i];
            visited[i] = false;
        }

        visited[src - 1] = true;

        for (int i = 1; i < n; i++) 
        {
            min_dist = 999;
            for (int j = 0; j < n; j++) 
            {
                if (!visited[j] && dist[j] < min_dist) 
                {
                    unvis = j;
                    min_dist = dist[j];
                }
            }

            visited[unvis] = true;

            for (int v = 0; v < n; v++) 
            {
                if (!visited[v] && dist[unvis] + adj[unvis][v] < dist[v]) 
                    dist[v] = dist[unvis] + adj[unvis][v];
            }
        }
        return dist;
    }
	
	
	
	public static void main(String[] args) 
	{
        Scanner s = new Scanner(System.in);
        
        System.out.println("Enter Number of Vertices");
        int n = s.nextInt();

        int adj[][] = new int[n][n];

        System.out.println("Enter cost Matrix : ");
        System.out.println("NOTE : Enter '999' for infinity");
        for (int i = 0; i < n; i++) 
            for (int j = 0; j < n; j++) 
                adj[i][j] = s.nextInt();
       
        System.out.println("Enter Source vertex");
        int src = s.nextInt();

        int[] dist = dijkstra(adj, src);

        for (int i = 0; i < n; i++) 
        {
            if ((src - 1) == i) 
                continue;
            System.out.println("Shortest Distance from " + src + " to " + (i + 1) + " is " + dist[i]);
        }
        s.close();
    }
	
}


/*RESULT
Enter Number of Vertices
6
Enter cost Matrix : 
NOTE : Enter '999' for infinity
999 15 10 999 45 999
999 999 15 999 20 999
20 999 999 20 999 999
999 10 999 999 35 999
999 999 999 30 999 999
999 999 99 4 999 999
Enter Source vertex
3
Shortest Distance from 3 to 1 is 20
Shortest Distance from 3 to 2 is 30
Shortest Distance from 3 to 4 is 20
Shortest Distance from 3 to 5 is 50
Shortest Distance from 3 to 6 is 999
*/
