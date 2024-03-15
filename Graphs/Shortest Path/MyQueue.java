// Saketh Ayyagari
// Queue Class
public class MyQueue{
   private int size; 
   private char[] queue;
   private int head; // index for adding elements to queue
   private int tail; // index for removing elements from queue
   public MyQueue(int size){
      this.size = size;
      this.queue = new char[this.size];
      this.head = 0;
      this.tail = 0;
   }
   public void enqueue(char c){ // adding an element to the queue
      // NEVER  DO THIS
      /*/   
      this.queue[this.tail % size] = c;
      this.tail++;
      */
      // DO THIS
      this.queue[this.tail] = c;
      this.tail = (this.tail + 1) % this.size;
   }
   public char dequeue(){ // removing an element from the queue
      char output = this.queue[this.head];  
      this.head = (this.head+1) % this.size;
      return output;
   }
   public boolean isEmpty(){
      // queue is empty only if the head and tail indecies are the same
      return (this.head == this.tail);
   }
   public char head(){
      // returns the oldest node added to the queue (head node of the queue)
      return this.queue[this.head % size];
   }
}
