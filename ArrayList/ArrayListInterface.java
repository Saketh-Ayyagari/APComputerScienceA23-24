import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Iterator;
//Saketh Ayyagari
//ArrayList Interface
public class ArrayListInterface {
   public static void main(String[] args){
      ArrayList<String> list = new ArrayList<String>();
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
               list.add(d);
               System.out.println(d + " inserted in list");
            }
            else if (operation == 'p'){ //printing the list
               Iterator<String>it = list.iterator();
               while (it.hasNext()){
                  System.out.println(it.next());
               }
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
