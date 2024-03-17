import java.util.ArrayList;
import java.util.Iterator;
//Saketh Ayyagari
// Weighted Graph Class
public class WGraph implements Iterable<Character>{
   private int[][] adj; // integer values contain weights of edges
   public WGraph(int[][] adj){ 
      this.adj = adj;
   }
   // cloning weighted graph
   public WGraph(WGraph w){
      this.adj = w.adj;
   }
	// returns the weight of the edge between two nodes.
   public int getWeight(char a, char b){ 
		return adj[a-'A'][b-'A'];
	}
	public ArrayList<Character> adjacencies(char node){
		ArrayList<Character> adjList = new ArrayList<Character>(); // contains characters adjacent to specific Node
		for (int i=0; i<this.adj[node-'A'].length; i++){ // goes through specific row of matrix
			char node2 = (char)(i+'A');
			if (getWeight(node, node2) > 0){
				// adds Node to adjacency list if an edge exists between the two Nodes
				adjList.add(node2);
			}
		}
		return adjList;
	}
	public ArrayList<Character> getFrom(char node){ // lists all nodes to which you can get to 'node'
		ArrayList<Character> list = new ArrayList<Character>();
		for (int i=0; i<this.adj.length; i++){ // goes through column of matrix
			if (getWeight((char)(i+'A'), node) > 0){ // does an edge between a character and the node exist
				list.add((char)(i+'A'));
			}
		}
		return list;
	}
	public int size(){ // returns the size of the graph (the number of nodes in the graph)
		return this.adj.length;
	}
	public Iterator<Character> iterator(){
		return new WGIterator(this);
	}
	private class WGIterator implements Iterator<Character>{
		private char start;
		private WGraph w;
		public WGIterator(WGraph w){
			this.w = w;
			this.start = 'A';
		}
		public boolean hasNext(){
			return (start-'A' < w.size());
		}
		public Character next(){
			char output = start;
			start = (char)((start-'A')+1+'A');
			return output;
		}
	}

}