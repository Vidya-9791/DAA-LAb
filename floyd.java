/*
10.a. Write Java programs to Implement All-Pairs Shortest Paths problem using Floyd's algorithm.
*/
package floyd;
import java.util.Scanner;

class floyd {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter Number of Vertices");
        int n = scanner.nextInt();
        int[][][] D = new int[n + 1][n][n];

        System.out.println("Enter Distance Matrix");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                D[0][i][j] = scanner.nextInt();
            }
        }

        for (int k = 1; k <= n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    D[k][i][j] = Math.min(D[k - 1][i][j], D[k - 1][i][k - 1] + D[k - 1][k - 1][j]);
                }
            }
        }

        System.out.println("Shortest Distance Matrix");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(D[n][i][j] + " ");
            }
            System.out.println();
        }
    }
}

/*RESULTS
Enter Number of Vertices
4
Enter Distance Matrix
0 999 3 999
2 0 999 999
999 7 0 1
6 999 999 0
Shortest Distance Matrix
0 10 3 4 
2 0 5 6 
7 7 0 1 
6 16 9 0 
*/
