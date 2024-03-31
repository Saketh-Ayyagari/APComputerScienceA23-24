//Saketh Ayyagari
//Creating a Node Class to be used with Linked Lists

public class Node{
   private String data;
   private Node next; //reference to the next Node of a structure
   public Node (String data, Node next){ 
      this.data = data;
      this.next = next;
   }
   public String getData(){ //returns the data of Node
      return this.data;
   }
   public Node getNext(){ //returns the reference to the next Node
      return this.next;
   }
   public void setNext(Node next){ //assigns another Node as a reference to the next.546rt
      this.next = next;
   }
}