import java.io.*;
//Saketh Ayyagari
//Generates the nth Fibbonnaci Number without using recursion
public class Fibonnaci {
   static int fib(int n){
      MyStack stack = new MyStack(1000); //Program doesn't work when the stack size is n
      int t=0;
      stack.push(n);
      while (!stack.isEmpty()){
         n = stack.pop();
         if (n <= 1){
            t+=n;
         }
         else{
            stack.push(n-1);
            stack.push(n-2);
         }
      }
      return t;
   }
   public static void main(String[] args){
      int input = Integer.parseInt(args[0]);
      System.out.println("nth Fibonnaci number: " + fib(input));
   }   
}
