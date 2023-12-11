import java.io.*;
//Saketh Ayyagari
//Using Node class to create a Linked List class

public class LLInt {
   private NodeInt head; //Node that refers to beginning of linked list
   public LLInt(){ //Declares empty Linked List
      this.head = null;
   }
   public boolean isEmpty(){ //is the Linked list empty?
      return (this.head==null);
   }
   public void push(int d){
      //new "head" Node becomes assigned new "Node" object that has previous head assigned
      this.head = new NodeInt(d, this.head); 
   }
   public int pop(){ //returns the head element of a Linked List
      int output = this.head.getData();
      this.head = this.head.getNext();
      return output;
   }
   public void print(){
      NodeInt t = this.head;
      while (t != null){
         if (t.getNext() == null){
            System.out.print(t.getData());
         }
         else{
            System.out.print(t.getData() + "-->");
         }
         t=t.getNext();
      }
      System.out.println(); 
   }
   public boolean contains(int target){ //does a LinkedList contain a certain value?
      NodeInt t = this.head;
      while (t != null){
         if (t.getData() == (target)){
            return true;
         }
         t = t.getNext();
      }
      return false;
   }
   public boolean remove(int target){ //removes a Node from a LinkedList and returns whether 
      NodeInt t = this.head;
      if (t.getData() == target){ //if the head node contains target data
         this.head = t.getNext();
         return true;
      }
      else{ //if the target data is not in the head.
         while (t.getNext() != null){ 
            if (t.getNext().getData() == (target)){
               //goes through LinkedList until Node before target is reached.
               t.setNext(t.getNext().getNext());
               return true;
            }
            t=t.getNext();
         }
      }
      return false; //
   }
}
