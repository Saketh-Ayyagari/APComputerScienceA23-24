// Saketh Ayyagari
// Merge Sort on a Linked List
import java.util.Scanner;

public class MergeSort {
   public static void main(String[] args){
      myLinkedList list = new myLinkedList();
      Scanner sc = new Scanner(System.in);      
      String token = sc.nextLine();
      while (sc.hasNextLine()){
         list.push(token);
         token = sc.nextLine();

      }   
      list.sort();
      list.print();
      
   }
}
