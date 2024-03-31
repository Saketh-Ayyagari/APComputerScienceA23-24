import java.io.*;
//Saketh Ayyagari
//Using Node class to create a Linked List class

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
   public void sort(){
      this.head = recsort(this.head);
   }
   private static Node recsort(Node h){
      Node t = split(h);
      h = recsort(h);
      t = recsort(t);
   
      return merge(h, t);
   }
   public static Node merge(Node h, Node t){
      Node firstMerged = null;
      
      // as long as both list h and t still contain elements
      while (t != null && h != null){
         if (t.getData().compareTo(h.getData()) < 0){
            firstMerged = new Node(t.getData(), firstMerged);
         }
         else{
            firstMerged = new Node(h.getData(), firstMerged);
         }
      }
      if (h == null){
         while (t != null){
            firstMerged = new Node(t.getData(), firstMerged);
         }
      }
      else if (t == null){
         while (h != null){
            firstMerged = new Node(h.getData(), firstMerged);
         }
      }
      return firstMerged;
   }
   public static Node split(Node t){ // splits a Linked List given the head of the Linked List
      Node ref1 = t; // reference to the middle of a Linked List
      Node ref2 = t;
      while (ref2 != null){
         ref1 = ref1.getNext();
         ref2 = ref2.getNext().getNext();
      }
      return ref1;
   }
   
   // NOT NEEDED FOR MERGE SORT
   public void insert(String d){
      if (isEmpty() || this.head.getData().compareTo(d) > 0){
         //new Node is the new head if LinkedList is empty or current data is less than that of head
         this.head = new Node(d, this.head);
      }
      else{
         Node t = this.head; //pointer that goes through LL
         while (t.getNext() != null){
            //goes through LinkedList until t reaches the Node before the current desired spot.
            if (t.getNext().getData().compareTo(d) > 0){
               Node n = new Node(d, t.getNext());
               t.setNext(n);
               return;
            }
            t = t.getNext();
         }
         //appends Node to the end of the list if t reaches end of list
         Node n = new Node(d, null); 
         t.setNext(n);
      }
   }
}
