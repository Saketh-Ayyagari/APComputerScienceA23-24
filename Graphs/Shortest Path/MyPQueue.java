import java.util.ArrayList;
/* 
Priority Queue Class
This priority queue class takes on the structure of a heap 
*/ 
public class MyPQueue{
   private ArrayList<Integer> heapList;
   private ArrayList<Character> vertices; // list of vertices in the same order as their respective distances/priorities
   private int index;
   
   public MyPQueue(){
      this.heapList = new ArrayList<Integer>();
      this.vertices = new ArrayList<Character>();
      this.index = 1;
      // adds placeholder elements
      heapList.add(-1);
      vertices.add('x');
   }
   public boolean isEmpty(){
      return this.index == 1;
   }
   private boolean leftExists(int parentIndex){ // does a node have a left child?
      return parentIndex*2 < this.heapList.size();
   }
   private boolean rightExists(int parentIndex){ // does a node have a right child?
      return (parentIndex*2)+1 < this.heapList.size();
   }
   public void enqueue(char vertex, int priority){ 
      // adds an element to the heap, then rearranges it to maintain conditions for heap
      heapList.add(this.index, priority);
      vertices.add(this.index, vertex);
      if (this.index > 1){ 
         // index must be greater than 1 to make comparisons with other elements
         int index2 = this.index; // contains the index where the added vertex/priority will be after exchanges
         
         while (index2 > 1 && heapList.get(index2/2) > priority){
            // makes exchanges with parent node as long as a parent node is greater than the priority mentioned
            //exchanges distances from source node
            int parentNode = heapList.get(index2/2);
            heapList.set(index2, parentNode);
            //exchanges vertices
            char dummyVertex = vertices.get(index2/2);
            vertices.set(index2, dummyVertex);
            
            index2 /= 2;
         } 
         // assigns the priority and vertex to its respective place
         heapList.set(index2, priority);
         vertices.set(index2, vertex);
      }
      this.index+=1;
   }
   public char dequeue(){ // removes root node of the heap, then rearranges it to maintain conditions
      heapList.remove(1);
      char output = vertices.remove(1);
      this.index-=1;      
      
      if (this.index > 1){ 
         // moves the last element of the heap to the new root
         int node2 = heapList.remove(heapList.size()-1); 
         char lastVertex = vertices.remove(vertices.size()-1);
         // if the size of the heap is greater than 1, do an exchange to maintain heap property
         heapList.add(1, node2);
         vertices.add(1, lastVertex);
         int index2 = 1; // stores final index where node2 will go
         while(leftExists(index2) || rightExists(index2)){ 
            int smallestChildIndex=index2;
            // determines how many children there are
            if (leftExists(index2) && rightExists(index2)){ 
               // if a parent node has two children
               int left = 2*index2;
               int right = (2*index2)+1;
               // determines the index of the smaller child
               if (heapList.get(left) <= heapList.get(right)){
                  smallestChildIndex = left;
               }
               else{
                  smallestChildIndex = right;

               }
            }
            else if (leftExists(index2) && !rightExists(index2)){ // if only the left child exists
               smallestChildIndex = 2 * index2;
               
            }
            else if (rightExists(index2) && !leftExists(index2)){ // if only the right child exists
               smallestChildIndex = (2 * index2)+1;
            }
            else{ // if no children exist, the vertex is a leaf, which means it is in the right place
               return output;
            }
            if (heapList.get(smallestChildIndex) < heapList.get(index2)){
               // exchanges parent node with its smallest child
               int dummy = heapList.get(index2);
               heapList.set(index2, heapList.get(smallestChildIndex));
               heapList.set(smallestChildIndex, dummy);
               //exchanges corresponding vertex
               char dummyChar = vertices.get(index2);
               vertices.set(index2, vertices.get(smallestChildIndex));
               vertices.set(smallestChildIndex, dummyChar);
            }
            else{ // heap invariant is now maintained
               return output;
            }
            index2 = smallestChildIndex; // new parent node becomes the child node            
         }  
      }
      return output;
   }
   public int getRootDistance(){ // returns shortest distance (root node of distance heap) 
      return heapList.get(1);
   }
   public char getRootVertex(){ // returns vertex of shortest distance from the start
      return vertices.get(1);
   }
}

