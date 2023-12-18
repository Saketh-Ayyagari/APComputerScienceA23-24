import java.io.*;
import java.util.*;
//Saketh Ayyagari
//Interface for Ordered Insert of Nodes into a LinkedList
public class Interface3{
   public static void main(String[] args){
      LLComparable<String> list = new LLComparable<String>();
      Scanner sc = new Scanner(System.in);
      String command = sc.nextLine();
      while (!command.equals("q")){ //"q" = quit the program
         //detects operation to do and data to insert
         char operation = command.charAt(0);
         if (operation != 'i' && operation != 'p' && operation != 'd' && operation != 'c'){
            System.out.println("Invalid operation");
         }
         else{
            //uses "substring" to get data
            String d = command;
            while (d.indexOf(" ") >= 0){ //takes substring of
               d = d.substring(d.indexOf(" ") + 1);
            }
            if (operation == 'i'){ //inserts an element into lexicographical order of LinkedList
               list.insert(d);
               System.out.println(d + " inserted in list");
            }
            else if (operation == 'p'){ //printing the list
               list.print();
            }
            else if (operation == 'd'){ //deleting an element
               if (list.remove(d)){
                  System.out.println(d + " has been removed");
               }
               else{ //if element to be removed is not in list
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
         command = sc.nextLine();
      }
      return;
   }
}
