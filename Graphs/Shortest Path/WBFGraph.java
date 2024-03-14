import java.util.*;
//Saketh Ayyagari
// Weighted Graph Traversal with BFS
public class WBFGraph extends WGraph{
   private char start;
   public WBFGraph(char start, int[][] adj){
      super(adj);
      this.start = start;
   }
   public WBFGraph(char start, WGraph g){
      super(g);
      this.start = start;
   }
   public Iterator<Character> iterator(){
      return new BFSIterator(this);
   }
   private class BFSIterator implements Iterator<Character>{
      private WBFGraph b;
      private MyQueue q;
      private char start;
      private boolean[] visited;
      public BFSIterator(WBFGraph b){
         this.b = b;
         this.q = new MyQueue(b.size()); // initializes a queue with the same size as the graph.
         // initializing all values in visited array to be false
         visited = new boolean[b.size()];
         for (int i = 0; i < size(); i++){
            this.visited[i] = false;
         }
         this.start = b.start;
         // pushes start node to the queue
         q.enqueue(this.start);
      }
      public boolean hasNext(){
         // is the queue not empty
         return (!q.isEmpty());
      }
      public Character next(){
         char node = q.head(); // reference to the next 
         visited[node-'A'] = true;

         ArrayList<Character> adjList = new ArrayList<Character>();
         adjList = this.b.adjacencies(node);
         // adds unvisited nodes to queue
         for (char c : adjList){
            if (!this.visited[c-'A']){
               q.enqueue(c);
               visited[c-'A'] = true;
            }
         }
         return q.dequeue();
         
      }
   }
}
