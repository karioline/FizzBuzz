//Kari Shelton
// CMPS390
// Programming Assignmnent #3: Fibonacci.java
// Complete 2 methods for Fibonacci functions: recursive and iterative versions

/*
Fibonacci sequence are the numbers in the following integer sequence:
1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, ...
F(n) = F(n-1) + F(n-2)
F(1) = 1, F(2) = 1
 */

import java.util.Scanner;

public class Fibonacci {
	public static void main(String args[]) {
		System.out.print("Enter an positive integer to calculate Fibonacci number: ");
		Scanner input = new Scanner(System.in);
		long n = input.nextLong();
		if (n <= 0)
			System.out.println("Number should be positive integer.");
		else {
			long start = System.currentTimeMillis();
			System.out.println("Iterative: Fibonacci number F(" + n + ") = " + fibonacciIterative(n));
			long end = System.currentTimeMillis();
			System.out.println("Iterative: execution time = " + (end - start));
			start = System.currentTimeMillis();
			System.out.println("Recursive: Fibonacci number F(" + n + ") = " + fibonacciRecursive(n));
			end = System.currentTimeMillis();
			System.out.println("Recursive: execution time = " + (end - start));
		}
	}//end of main

	public static long fibonacciIterative(long n) {
		long a = 1, b = 1, result = 0;
      
      if(n == 1 || n == 2){
         result = 1;
         return result;
      }else{
       
         for(int i=2; i<n; i++){
           result = a + b;
           a = b;
           b = result;    
         }
         return result;
      }//end else
	}//end of fibonacciIterative

	public static long fibonacciRecursive(long n) {
		if(n == 1 || n == 2){
         return 1;
      }else{
         return ( fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2) );
      }//end of fibonacciRecursive
	}
}//end of class
	/*
	 * Sample run Enter an positive integer to calculate Fibonacci number: 50
	 * Iterative: Fibonacci number F(50) = 12586269025 Iterative: execution time = 0
	 * Recursive: Fibonacci number F(50) = 12586269025 Recursive: execution time =
	 * 98361
	 */
