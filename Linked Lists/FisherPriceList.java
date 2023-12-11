import java.io.*;
import java.util.*;
//Saketh Ayyagari
//Interface for working with operations with Linked Lists.
public class FisherPriceList{  
   public static void main(String[] args){
      myLinkedList list = new myLinkedList();
      Scanner sc = new Scanner(System.in);
      String command = sc.nextLine();
      while (!command.equals("q")){ //"q" = quit the program
         if (command.equals("")){ //if nothing has been entered
            System.out.println("Nothing has been entered");
         }
         else{
            //detects operation to do and data to insert
            char operation = command.charAt(0);
            if (operation != 'i' && operation != 'p' && operation != 'd' && operation != 'c'){
               System.out.println("Invalid operation");
            }
            else{
               //uses "substring" to get a string containing data
               String d = command;
               while (d.indexOf(" ") >= 0){
                  d = d.substring(d.indexOf(" ") + 1); 
               }
               if (operation == 'i'){ //pushes an element into the LinkedList
                  list.push(d);
                  System.out.println(d + " inserted in list");
               }
               else if (operation == 'p'){ //printing the list
                  list.print();
               }
               else if (operation == 'd'){ //deleting an element
                  if (list.remove(d)){
                     System.out.println(d + " has been removed");
                  }
                  else{
                     System.out.println(d + " can't be removed");
                  }
               }
               else if (operation == 'c'){ //checks if an element is in the LinkedList
                  if (list.contains(d)){
                     System.out.println("Element is in list");
                  }
                  else{
                     System.out.println("Element not found in list");
                  }
               }
            }
         }
         command = sc.nextLine();
      }
      sc.close();
      return;
   }
}
