import java.util.Stack;

//Saketh Ayyagari
//Infix to Postfix Transformer Class
public class Transformer{
  public static String toPost(String infix) throws DivideByZeroException, MismatchedParenthesesException, ZeroExpoZeroException, OperandExpectedException, OperatorExpectedException{ 
   //translates an infix expression into postfix
      String newExpression = "";
      Stack<String> st = new Stack<String>(); //holds operators
      PropTable table = new PropTable();
      String operand="";
      int i=0;
      while (i<infix.length()){
         String s = infix.substring(i, i+1);
         if (table.isOperator(s)){ // is the character an operator?
            operand="";
            String stOperator;
            if (st.empty()){ // if the stack is empty, then the stOperator is a space.
               stOperator = " ";
            }
            else{ // stack Operator is the top of the stack (if the stack is not empty)
               stOperator = st.peek();
            }

            if (table.precInput(s) > table.precStack(stOperator) && table.isStackable(s)){
               // pushes input operator to stack if it has a higher precedence than top of stack 
               // & is stackable.
                  st.push(s);
            }
            else{
               while (!st.empty() && table.precStack(st.peek()) >= table.precInput(s)){
                  /*as long as the stack is not empty AND the precedence of top element is greater than 
                  the input precedence of input operator
                  */
                  String operator = st.pop();
                  // only adds the operator to the expression if the operator is outputtable
                  if (table.isOutputtable(operator)){
                     newExpression += operator + " ";                 
                  }
               }
               if (table.isStackable(s)){ 
               // pushes inputOperator to stack if it is stackable
               // only operator that isn't stackable is closed parantheses
                  st.push(s);
               }
            }
            i+=1;
         }
         else{ // if the character is not an operator
            while (i < infix.length() && !table.isOperator(infix.substring(i, i+1))){
               operand+=infix.substring(i, i+1);
               i++;
            }
            newExpression+=operand+" ";
         }
      }
      // flushes the stack when i reaches end of infix expression
      
      while (!st.empty()){
         String op = st.pop(); // operator
         if (table.isOutputtable(op)){
            newExpression += op + " ";
         }
         else if (table.precStack(op)==0){
            throw new MismatchedParenthesesException("Unmatched Parantheses", 0);
         }
      }
      
      return newExpression;
   }
}