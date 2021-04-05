/*
4. Sort a given set of n integer elements using Quick Sort method and compute its time
complexity. Run the program for varied values of n> 5000 and record the time taken to sort.
Plot a graph of the time taken versus non graph sheet. The elements can be read from a file or
can be generated using the random number generator. Demonstrate using Java how the divide-and-conquer
method works along with its time complexity analysis: worst case, average case and best case.
*/

package Prg4;
import java.util.*;
//Random & Scanner



class Qsort
{
	
	static void QS(int[] a,int low,int high)// DAndC strategy
	{
		if(low<high)
		{
			int mid = partition(a,low,high);
			QS(a,low,mid-1);
			QS(a,mid+1,high);
		}
		
	}
	
	static int partition(int[] a,int low,int high)//Partition 
	{
		// Select the pivot element-right most element
	    int pivot = a[high];
	    int i = (low - 1); //i=-1 (index of smaller element)

	    // Put the elements smaller than pivot on the left and 
	    // greater than pivot on the right of pivot
	    for (int j = low; j < high; j++) 
	    {
	      if (a[j] <= pivot)
	      {
	        i++; //increment the index of smaller element
	        int temp = a[i];
	        a[i] = a[j];
	        a[j] = temp;
	      }
	    }
	    int temp = a[i + 1];
	    a[i + 1] = a[high];
	    a[high] = temp;
	    
	    return (i + 1);				
	}
}


public class Qicksort {
	public static void main(String[] args)
	{
		Scanner s = new Scanner(System.in);
		
		System.out.println("Enter the number of elements");
		int n = s.nextInt();
		int[] a = new int[n];
		
		
		System.out.println("Quick Sort");
        System.out.println("1. Best/Average Case");
        System.out.println("2. Worst Case");
        System.out.println("Eneter your choice : ");
        int ch = s.nextInt();
        System.out.println("Generating elements......");
       switch (ch) 
        {
        	case 1:
        		Random random = new Random();
        		for (int i = 0; i < n; i++)
        			a[i] = random.nextInt(100000);
                break;
        	case 2:
        		for (int i = 0; i < n; i++) 
        			a[i] = i + 1;
                break;
        }
        
        
        
       /* System.out.println("\nElements generated are: ");
        for (int i = 0; i < n; i++) 
            System.out.println(a[i]);*/
        
                
        long start = System.currentTimeMillis();
        Qsort.QS(a,0,n-1);
        long end = System.currentTimeMillis();
        
        /*System.out.println("Sorted Array");
        for (int i = 0; i < n; i++) {
            System.out.println(a[i]);
        }*/

        System.out.println("Time taken: " + (end - start)+"ms");
        System.out.println("Done");
        s.close();
		
	}
}
