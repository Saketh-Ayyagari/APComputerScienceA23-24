import java.io.*;
//Precedence Table of operations

public class PropTable{
   static final int OP=0;
   static final int PRECINP=1;
   static final int PRECST=2;
   static final int FOLLOW=3; // does this follow an operand?
   static final int LOOK=4; // does it look like an operand
   static final int STACKABLE=5; // can it be placed on stack?
   static final int OUPUTTABLE=6; // can it be outputted to the newExpression

   final String[] table = {
                        "+12tftt",
                        "-12tftt",
                        "*34tftt",
                        "/34tftt",
                        "^65tftt",
                        "(90fftf",
                        ")00ttff",
                        " 00ffff"}; //last row is one for empty space
   private int find(String s){ 
      for (int i=0; i<table.length; i++){
         if (s.charAt(0)==table[i].charAt(OP)){
            return i;
         }
      }
      return table.length-1;
   }
   public boolean isOperator(String s){
      return table[find(s)].charAt(OP) != ' ';
   }
   public int precInput(String s){ //returns precedence of operator when it is in infix
      return table[find(s)].charAt(PRECINP)-'0';
   }
   public int precStack(String s){
      return table[find(s)].charAt(PRECST)-'0';
   }
   public boolean follows(String s){ //returns what should come after an operator
      return table[find(s)].charAt(FOLLOW)=='t';
   }
   public boolean lookslike(String s){
      return table[find(s)].charAt(LOOK)=='t';
   }
   public boolean isStackable(String s){
      return table[find(s)].charAt(STACKABLE)=='t';
   }
   public boolean isOutputtable(String s){
      return table[find(s)].charAt(OUPUTTABLE)=='t';
   }
}
