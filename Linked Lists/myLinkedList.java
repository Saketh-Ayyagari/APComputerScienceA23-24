import java.io.*;
//Saketh Ayyagari
//Using Node class to create a Linked List class

public class myLinkedList {
   private Node head; //Node that refers to beginning of linked list
   public myLinkedList(){ //Declares empty Linked List
      this.head = null;
   }
   public boolean isEmpty(){ //is the Linked list empty?
      return (this.head==null);
   }
   public void push(String d){
      //new "head" Node becomes assigned new "Node" object that has previous head assigned
      this.head = new Node(d, this.head); 
   }
   public String pop(){ //returns the head element of a Linked List
      String output = this.head.getData();
      this.head = this.head.getNext();
      return output;
   }
   public void print(){
      Node t = this.head;
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
   public boolean contains(String target){ //does a LinkedList contain a certain value?
      Node t = this.head;
      while (t != null){
         if (t.getData().equals(target)){
            return true;
         }
         t = t.getNext();
      }
      return false;
   }
   public void remove(String target){ //removes a Node from a LinkedList
      Node t = this.head;
      if (t.getData().equals(target)){ //if the head Node contains target data to be removed
         this.head = t.getNext();
      }
      else{
         while (t.getNext() != null && !t.getNext().getData().equals(target)){
            //goes through LinkedList until the Node before the target is reached.
            t=t.getNext();
         }
         if (t.getNext().getNext() == null){ //if t is the last or second-to-last element in a LinkedList
            t.setNext(t.getNext());
         }
         else{
            t.setNext(t.getNext().getNext());
         }
      }
   }
}
