import java.util.*;
/*Saketh Ayyagari
 * Shortest Path Graph Traversal
 */
public class WSPGraph extends WGraph{
   private char start;
   private int[] shortestDistances;
   private Character[] whereFrom; // which vertex did another come from in order to get to another?
   
   public WSPGraph(char start, int[][] adj){
      super(adj);
      this.start = start;
      shortestDistances = new int[this.size()];
      whereFrom = new Character[this.size()];      
   }
   public WSPGraph(char start, WGraph w){
      super(w);
      this.start = start;
      shortestDistances = new int[this.size()];
      whereFrom = new Character[this.size()];  
   }
   public int getShortestDistance(char c){ // gets the shortest distance to a node from the start
      return this.shortestDistances[c-'A'];
   }
   public Iterator<Character> iterator(){
      return new WSPIterator(this); 
   }
   public void output(){ // prints the shortest distance to each vertex and where it got from.
      Iterator<Character> spIt = this.iterator();
      while (spIt.hasNext()){
         char output = spIt.next();
         if (start == output){
            System.out.println(output + " " + 0);
         }
         else if (output != ' '){
            System.out.println(output + ": " + shortestDistances[output-'A'] + " via " + whereFrom[output-'A']);
         }
      }
   }
   private class WSPIterator implements Iterator<Character>{
      private WSPGraph wsp;
      private char start;
      private MyPQueue p;
      private boolean[] visited;
      public WSPIterator(WSPGraph wsp){
         this.wsp = wsp;
         this.start = wsp.start;
         this.p = new MyPQueue();
         // creates array of visited vertices
         visited = new boolean[this.wsp.size()];
         
         p.enqueue(start, 0);
         // shortest distance from starting node to itself is 0
         shortestDistances[this.start-'A'] = 0; 
         whereFrom[start-'A'] = ' ';
      }
      public boolean hasNext(){ // does the priority queue still contain elements?
         return !p.isEmpty();
      }
      public Character next(){
         int d = p.getRootDistance();
         char output = p.dequeue();
         while (visited[output-'A']){
            if (p.isEmpty()){
               return ' ';
            }
            output = p.dequeue();
         }
         // finds neighbors of the root node
         ArrayList<Character> neighbors = this.wsp.adjacencies(output);
         // pushes unvisited neighbors into priority queue
         for (char c : neighbors){
            int distanceFromStart = d + wsp.getWeight(output, c);
            /* if a neighbor is not visited and either has a shortestDistance of 0 or a distance smaller than the
            * shortest distance in the array, add it to the priority queue and update whereFrom and shortestDistances
            * arrays..
            */
            if (!visited[c-'A'] && (shortestDistances[c-'A'] == 0 || distanceFromStart < shortestDistances[c-'A']))
            { 
               p.enqueue(c, distanceFromStart);
               shortestDistances[c-'A'] = distanceFromStart;
               whereFrom[c-'A'] = output;
            }
         }
         visited[output-'A'] = true;
         return output;
      }
      
   }
}
