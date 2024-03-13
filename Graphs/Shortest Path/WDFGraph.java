import java.util.Stack;
import java.util.Iterator;
import java.util.ArrayList;
// Saketh Ayyagari
// Weighted Graph with DFS Traversal
public class WDFGraph extends WGraph{
   private char start;
   public WDFGraph(char start, int adj[][]){
      super(adj);
      this.start = start;
   }
   public WDFGraph(char start, WGraph g){
      super(g);
      this.start = start;
   }
   public Iterator<Character> iterator(){ // calls iterator for DFS traversal
      return new WDFSIterator(this); // "this" passes the instances the DFGraph
   }
   private class WDFSIterator implements Iterator<Character>{
      private Stack<Character> st;
      private Character pending;
      private WDFGraph d;
      private boolean[] visited;
      
      public WDFSIterator(WDFGraph d){
         this.d = d;
         this.st = new Stack<Character>();
         this.visited = new boolean[d.size()];
         //initializing visited array to be false
         for (int i = 0; i < d.size(); i++){
            visited[i] = false;
         } 
         this.pending = this.d.start;
      }
      public boolean hasNext(){
         return this.pending != ' ';
      }
      public Character next(){
         ArrayList<Character> adjList = new ArrayList<Character>();
         adjList = this.d.adjacencies(this.pending);

         int i = 0;
         while (i < adjList.size()){ // finds the first unvisited neighbor of pending
            if (!visited[adjList.get(i)-'A']){ 
               break;
            }
            i+=1;
         }
         char output = this.pending; // character that will be returned
         if (i == adjList.size()){ // if i is the same as the adjacency list size, there are no unvisited neighbors
            if (this.st.empty()){ // if the stack is empty, we are done with DFS traversal
               this.pending = ' ';
               return this.pending;
            }         
            this.pending = this.st.pop(); // otherwise, the pending becomes the top of the stack
         }
         else{
            this.pending = adjList.get(i);
         }
         if (!this.visited[output-'A']){ // if the output is not visited, push it to the stack
            this.st.push(output);
         }
         else{ // continues to look through adjacency list for neighbors
            return next();
         }
         visited[output-'A'] = true; // marks output as visited
         return output;
      }
   }
}