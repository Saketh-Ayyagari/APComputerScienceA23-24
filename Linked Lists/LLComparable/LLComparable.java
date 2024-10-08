import java.util.Iterator;
//Saketh Ayyagari
//LinkedList of Generic Type + Removed print method by using Iterator
public class LLComparable<C extends Comparable<C>> implements Iterable<C>{
   private NodeComparable<C> head; //Node that refers to beginning of linked list
   public LLComparable(){ //Declares empty Linked List
      this.head = null;
   }
   public boolean isEmpty()
   { //is the Linked list empty?
      return (this.head==null);
   }
   public void push(C d)
   {//new "head" Node is assigned new "Node" object that has previous head assigned
      this.head = new NodeComparable<C>(d, this.head);
   }
   public boolean contains(C target){ //does a LinkedList contain a certain value?
      NodeComparable<C> t = this.head;
      while (t != null){
         if (t.getData().equals(target)){
            return true;
         }
         t = t.getNext();
      }
      return false;
   }
   public boolean remove(C target)
   { //removes a Node from a LinkedList and returns whether or not operation was successful
      NodeComparable<C> t = this.head;
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
   public void insert(C d){ //inserts a Node in lexicographical order
      if (isEmpty() || this.head.getData().compareTo(d) > 0){
         //new Node is the new head if LinkedList is empty or new data is less than that of head
         this.head = new NodeComparable<C>(d, this.head);
      }
      else{
         NodeComparable<C> t = this.head;
         while (t.getNext() != null){
            //goes through LinkedList until t reaches the Node before the current desired spot.
            if (t.getNext().getData().compareTo(d) > 0){
               NodeComparable<C> n = new NodeComparable<C>(d, t.getNext());
               t.setNext(n);
               return;
            }
            t = t.getNext();
         }
         //appends Node to the end of the list if t reaches end
         NodeComparable<C> n = new NodeComparable<C>(d, null);
         t.setNext(n);
      }
   }
   public Iterator<C> iterator(){ //method to access iterator
      return new LLIter<C>(this.head);
   }
   private class LLIter<E> implements Iterator<E>{ 
      private NodeComparable<E> t;
      public LLIter(NodeComparable<E> t){
         this.t = t;
      }
      public boolean hasNext(){ //is there another Node in LinkedList?
         return (this.t != null);
      }
      public E next(){ //returns the next Node of the LL
         E d = this.t.getData();
         this.t = this.t.getNext();
         return d;
      }
   }
}
