import java.util.*;

//FizzBuzz say fizz on multiples of x, buzz on multiples of y, fizzbuzz on multiples of both x and y

public class FizzBuzz {

   public static void multiples(int w, int x, int y){
      //first check if w is a multiples of x and y
      if( (w%x == 0) && (w%y == 0) ){
         System.out.println("FizzBuzz");
      } else if(w%x == 0){      
      //check if x is a multiple of x
         System.out.println("Fizz");
      } else if(w%y == 0){
      //check if x is a multiple of x
         System.out.println("Buzz");
      } else {
         System.out.println(w);
      }
   }
   
   public static void main(String[] args) {
      //get values of x and y
      Scanner input = new Scanner(System.in);
      System.out.println("Enter in an x value and a y value.");
      int x = input.nextInt();
      int y = input.nextInt();
      int i = 0;
      System.out.println("x = " + x + "\ny = " + y );
      //call multiples(int x, int y) 
      for(; i < 100; i++){
         multiples(i, x, y);
      }
   }
}