import java.io.*;
import java.util.*;
// Saketh Ayyagari
// Printing Graph Traversals

public class PrintTraversals{
   static boolean adjMatrix[][];
   static char start;
   static void getInput(){ // gets the input for adjacency matrix and starting node
      Scanner sc = new Scanner(System.in);
      // gets size of first row to determine size of square matrix
      String row = sc.nextLine();
      String[] rowArr = row.split(" ");
      int sizeOfRow = rowArr.length;
      // creates square matrix given the size of the row
      adjMatrix = new boolean[sizeOfRow][sizeOfRow];
      // gets the input for boolean square matrix
      for (int i = 0; i < sizeOfRow; i++){
         rowArr = row.split(" ");
         for (int j = 0; j < sizeOfRow; j++){
            adjMatrix[i][j] = (rowArr[j].equals("1"));
         }
         row = sc.nextLine();
      }
      start = row.charAt(0);
   }

   public static void main(String[] args) {
      getInput();
      Graph g = new Graph(adjMatrix);
      // Basic Graph Traversal
      System.out.println("Basic Graph Traversal");
      Iterator<Character> graphIt = g.iterator();
      while (graphIt.hasNext()){
         System.out.print(graphIt.next() + " ");
      }
      System.out.println();
      // Depth First Graph Traversal
      System.out.println("Depth First Search");
      System.out.println("Starting Node: " + start);
      DFGraph2 d = new DFGraph2(start, g);
      Iterator<Character> dfIt = d.iterator();
      while (dfIt.hasNext()){
         System.out.print(dfIt.next() + " ");
      }
      System.out.println();
      // Breadth First Graph Traversal
      System.out.println("Breadth First Search");
      BFGraph b = new BFGraph(start, g);
      Iterator<Character> bfIt = b.iterator();
      while (bfIt.hasNext()){
         System.out.print(bfIt.next() + " ");
      }
      
      
   }
}
