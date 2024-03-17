import java.io.*;
//Saketh Ayyagari
//Using Node class to create a Linked List class
// NOTE: THIS HAS ORDERED INSERT
public class myLinkedList 
{
   private Node head; //Node that refers to beginning of linked list
   public myLinkedList()
   { //Declares empty Linked List
      this.head = null;
   }
   public boolean isEmpty()
   { //is the Linked list empty?
      return (this.head==null);
   }
   public void push(String d)
   {//new "head" Node becomes assigned new "Node" object that has previous head assigned
      this.head = new Node(d, this.head); 
   }
   public String pop()
   { //returns the head element of a Linked List
      String output = this.head.getData();
      this.head = this.head.getNext();
      return output;
   }
   public void print()
   {
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
   public boolean remove(String target)
   { //removes a Node from a LinkedList and returns whether or not operation was successful
      Node t = this.head;
      if (isEmpty())
      {
         //element can't be removed if list is empty
         return false;
      }
      if (t.getData().equals(target))
      { //if head Node contains target data
         this.head = t.getNext();
         return true;
      }
      else
      { //if target data is NOT in head node
         while (t.getNext() != null)
         {
            if (t.getNext().getData().equals(target))
            { //goes through LinkedList until Node before target is reached
               t.setNext(t.getNext().getNext()); //sets nextNode two Nodes ahead of t
               return true;
            }
            t=t.getNext();
         }
      }
      return false; //no Node contains the target
   }
   // Merge Sort methods
   public void sort(){
      this.head = recsort(this.head);
   }  
   private Node recsort(myLinkedList h){
      Node t = split(h);
      h = recsort(h);
      t = recsort(t);
      return merge(h, t);
   }
   private myLinkedList split(){

      
   }
   private Node merge(myLinkedList h, myLinkedList t){

      return this.head;
   }
}
