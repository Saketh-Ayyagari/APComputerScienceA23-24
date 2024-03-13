import java.io.*;
import java.util.*;
// Saketh Ayyagari
// Printing Graph Traversals along with Shortest Path Traversal

public class PrintTraversals2{
   static int adjMatrix[][];
   static char start;
   static void getInput(){ // gets the input for adjacency matrix and starting node
      Scanner sc = new Scanner(System.in);
      // gets size of first row to determine size of square matrix
      String row = sc.nextLine();
      String[] rowArr = row.split(" ");
      int sizeOfRow = rowArr.length;
      // creates square matrix given the size of the row
      adjMatrix = new int[sizeOfRow][sizeOfRow];
      // gets the input for boolean square matrix
      for (int i = 0; i < sizeOfRow; i++){
         rowArr = row.split(" ");
         for (int j = 0; j < sizeOfRow; j++){
            adjMatrix[i][j] = Integer.parseInt(rowArr[j]);
         }
         row = sc.nextLine();
      }
      start = row.charAt(0);
   }

   public static void main(String[] args) {
      getInput();
      // Basic Graph Traversal Iterator
      System.out.println("Basic Graph Traversal");
      WGraph wg = new WGraph(adjMatrix);
      Iterator<Character> wgIt = wg.iterator();
      while (wgIt.hasNext()){
         System.out.print(wgIt.next() + " ");
      }
      System.out.println();
      // DFS
      System.out.println("Depth-First Search");
      WDFGraph wdf = new WDFGraph(start, wg);

      Iterator<Character> wdfIt = wdf.iterator();
      while (wdfIt.hasNext()){
         System.out.print(wdfIt.next() + " ");
      }
      System.out.println();
      // BFS
      System.out.println("Breadth First Search");
      WBFGraph wbf = new WBFGraph(start, wg);
      Iterator<Character> wbfIt = wbf.iterator();
      while (wbfIt.hasNext()){
         System.out.print(wbfIt.next() + " ");
      }
      System.out.println();
      System.out.println("Shortest Path");
      WSPGraph wsp = new WSPGraph(start, adjMatrix);
      
      wsp.output();

   }
}
