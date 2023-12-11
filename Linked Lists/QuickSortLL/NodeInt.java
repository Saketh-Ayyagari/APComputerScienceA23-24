import java.io.*;
//Saketh Ayyagari
//Creating a Node Class to be used with Linked Lists

public class NodeInt{
   private int data;
   private NodeInt next; //reference to the next Node of a structure
   public NodeInt (int data, NodeInt next){ 
      this.data = data;
      this.next = next;
   }
   public int getData(){ //returns the data of Node
      return this.data;
   }
   public NodeInt getNext(){ //returns the reference to the next Node
      return this.next;
   }
   public void setNext(NodeInt next){ //assigns another Node as a reference to the next.546rt
      this.next = next;
   }
}