package Prg5;

import java.util.*;


class sort
{
	static void MS(int[] a, int low,int high)
	{
		int mid;
		if(low<high)
		{
			mid = (low+high)/2;
			MS(a,low,mid);
			MS(a,mid+1,high);
			merge(a,low,mid,high);
		}
	}
	
	static void merge(int[] a,int low,int mid,int high)
	{
		int i,j,k,n1;
		
		n1 = high-low+1;
		int[] temp = new int[n1];
		
		i=low;
		j=mid+1;
		k=0;
		
		while((i<=mid) && (j<=high))
		{
			if(a[i] <= a[j])
			{
				temp[k]=a[i];
				i++;
			}
			else
			{
				temp[k]=a[j];
				j++;
			}
			k++;
		}
		
		while(i<=mid)
		{
			temp[k] = a[i];
			i++;
			k++;
		}
		
		while(j<=high)
		{
			temp[k] = a[j];
			j++;
			k++;
		}
		
		for(k=0;k<n1;k++)
			a[low+k]=temp[k];
	}
}


public class Mergesort 
{
	public static void main(String[] args)
	{
		
		Scanner s = new Scanner(System.in);
		
		System.out.println("Enter the number of elements");
		int n = s.nextInt();
		int[] a = new int[n];
		
		
		System.out.println("Quick Sort");
        System.out.println("1. Best case");
        System.out.println("2. Avg. case");
        System.out.println("3. Worst case");
        System.out.println("Eneter your choice : ");
        int ch = s.nextInt();
        System.out.println("Generating elements......");
        switch (ch) 
        {
        	case 1:
        		for (int i = 0; i < n; i++) 
        			a[i] = i + 1;
                break;
        	case 2:
        		Random random = new Random();
                for (int i = 0; i < n; i++) 
                    a[i] = random.nextInt();
                break;
        	case 3:
        		//The worst case of merge sort will be the one where 
        		//merge sort will have to do maximum number of comparisons. Reason: 
        		//Every element of array will be compared at least once.
        		for (int i = 0; i < n; i++) 
        			a[i] = n - i;
                break;
         }
        
        System.out.println("\nElements generated are: ");
        for (int i = 0; i < n; i++) 
            System.out.println(a[i]);
        
        long start = System.currentTimeMillis();
        sort.MS(a,0,n-1);
        long end = System.currentTimeMillis();
        
        
        System.out.println("Sorted Array");
        for (int i = 0; i < n; i++) 
            System.out.println(a[i]);
    

        System.out.println("Time taken: " + (end - start)+"ms");
        System.out.println("Done");
        s.close();
    }
}
	
        
