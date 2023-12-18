//Generic Node Class
public class NodeComparable<T> {
   private T data;
   private NodeComparable<T> next; //reference to the next Node of a structure
   public NodeComparable (T data, NodeComparable<T> next){
      this.data = data;
      this.next = next;
   }
   public T getData(){ //returns the data of Node
      return this.data;
   }
   public NodeComparable<T> getNext(){ //returns the reference to the next Node
      return this.next;
   }
   public void setNext(NodeComparable<T> next){ //assigns another Node as a reference to the next.546rt
      this.next = next;
   }
}

