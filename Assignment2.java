package com.assignment.ineuron;

public class Assignment2 {

	public static void main(String[] args) 
	{
		int n = 4;
		
		for(int i = 1; i <= n; i++)
		{
			for(int j = 0; j < n; j++)
			{
				System.out.print(i);
			}
			System.out.println();
		}
		
		System.out.println();
		
		n = 15;
		
		for(int i = 0; i < n; i++)
		{
			for(int j = 0; j < n; j++)
			{
				if(i == 0 || j == 0| i == n-1 || j == n-1 || i+j <= (n-1)/2 ||  j-i >= (n-1)/2)
					System.out.print("* ");
				else
					System.out.print("  ");
			}
			System.out.println();
		}
		
		
		for(int i = 0; i < n; i++)
		{
			for(int j = 0; j < n; j++)
			{
				if(i-j >= (n-1)/2 || i+j >= (n-1) + ((n-1)/2))
					System.out.print("* ");
				else
					System.out.print("  ");
			}
			System.out.println();
		}
		
		System.out.println();
		
		for(int i = 0; i < n; i++)
		{
			for(int j = 0; j < n; j++)
			{
				if(i == 0 || i == n-1 || j== 0 || i+j <= (n-1)/2 || i-j >= (n-1)/2)
					System.out.print("* ");
				else
					System.out.print("  ");
			}
			System.out.println();
		}
	}

}
