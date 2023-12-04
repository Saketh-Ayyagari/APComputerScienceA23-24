import java.io.*;
import java.util.*;
//Saketh Ayyagari
//Operations with Linked Lists.

public class FisherPriceList {  
   public static void main(String[] args){
      myLinkedList list = new myLinkedList();
      //getting input
      Scanner sc = new Scanner(System.in);
      String command = sc.nextLine();
      while (!command.equals("q")){ //"q" = quit the program
          //declares 2-element array of the command and the data
         String[] commandSplit = command.split(" "); 
         if (commandSplit[0].equals("i")){ //"i" asks to push an element to the head
            list.push(commandSplit[1]);
            System.out.println(commandSplit[1] + " inserted in list");
         }
         else if (commandSplit[0].equals("p")){ //"p" asks to print an element
            list.print();
         }
         else if (commandSplit[0].equals("r")){ //"r" asks to remove an element
            if (list.contains(commandSplit[1])){
               list.remove(commandSplit[1]);
               System.out.println(commandSplit[1] + " has been removed");
            }
            else{
               System.out.print("Element you attempted to remove not found.");
            }
         }
         else if (commandSplit[0].equals("c")){ //"c" asks to check if an element is in the LinkedList
            if (list.contains(commandSplit[1])){
               System.out.println("Element is in list");
            }
            else{
               System.out.println("Element not found in list");
            }
         }
         command = sc.nextLine();
      }
      sc.close();
      return;
   }
}
