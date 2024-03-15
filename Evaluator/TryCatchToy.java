import java.io.*;
import java.util.Scanner;
import java.util.Stack;
import java.lang.Math;

public class TryCatchToy extends Throwable{
   public static double evaluate(String post) throws DivideByZeroException, MismatchedParenthesesException, ZeroExpoZeroException, OperandExpectedException, OperatorExpectedException{
      PropTable table = new PropTable();
      Stack<Double> st = new Stack<Double>();
      for (String item : post.split(" ")){
         if (table.isOperator(item)){ // is the item an operator?
            double b = st.pop();
            if (st.empty()){
            // if the stack is empty after a number is popped, an operand is missing
               throw new OperandExpectedException("Missing an operand", 0); 
            }
            double a = st.pop();
            switch(item){ //handles different cases for different operators
               case "+":
                  st.push(a+b);
                  break;
               case "-":
                  st.push(a-b);
                  break;
               case "*":
                  st.push(a*b);
                  break;
               case "/":
                  if (b == 0){
                     throw new DivideByZeroException("Cannot divide by 0", 0);
                  }
                  st.push(a/b);
                  break;
               case "^":
                  if (a == 0 && b == 0){
                     throw new ZeroExpoZeroException("Cannot raise 0 to the power of 0", 0);
                  }
                  st.push(Math.pow(a, b));
                  break;
            }
         }
         else{
            st.push(Double.parseDouble(item));
         }
      }
      double ans = st.pop();
      if (!st.empty()){
         // if the stack is not empty after going through postfix expression, the expression
         // was missing an operator
         throw new OperatorExpectedException("Operator Expected", 0);
      }
      return ans;
   }
   public static void main(String[] args) throws Exception{
      Scanner sc = new Scanner(System.in);
      while (sc.hasNextLine()){
         String infix = sc.nextLine();
         System.out.println("Infix Expression: " + infix);
         try{
            String postfixExp = Transformer1Copy.toPost(infix);
            System.out.println("Postfix Expression: " + postfixExp);
            System.out.println("Result: " + evaluate(postfixExp));
         }
         catch(DivideByZeroException e){
            System.out.println(e.getMessage() + "," + e.getWhere());
         }
         catch(OperandExpectedException e){
            System.out.println(e.getMessage() + "," + e.getWhere());
         }
         catch(OperatorExpectedException e){
            System.out.println(e.getMessage() + "," + e.getWhere());
         }
         catch(ZeroExpoZeroException e){
            System.out.println(e.getMessage() + "," + e.getWhere());
         }
         catch(MismatchedParenthesesException e){
            System.out.println(e.getMessage() + "," + e.getWhere());
         }
         System.out.println();
      }
   }
}


