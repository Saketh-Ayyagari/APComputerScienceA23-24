import java.util.ArrayList;
import java.util.Iterator;
// Saketh Ayyagari
// Graph Class

public class Graph implements Iterable<Character>{
	private boolean adj[][];
	public Graph(boolean adj[][]){
		this.adj = adj;
	}
	public Graph(Graph g){ // cloning a graph
		this.adj = g.adj;
	}
	public boolean isEdge(char a, char b){ // does an edge exist between two Nodes?
		return adj[a-'A'][b-'A'];
	}
	public ArrayList<Character> adjacencies(char node){
		ArrayList<Character> adjList = new ArrayList<Character>(); // contains characters adjacent to specific Node
		for (int i=0; i<this.adj[node-'A'].length; i++){ // goes through specific row of matrix
			char node2 = (char)(i+'A');
			if (isEdge(node, node2)){
				// adds Node to adjacency list if an edge exists between the two Nodes
				adjList.add(node2);
			}
		}
		return adjList;
	}
	public ArrayList<Character> getFrom(char node){ // lists all nodes to which you can get to 'node'
		ArrayList<Character> list = new ArrayList<Character>();
		for (int i=0; i<this.adj.length; i++){ // goes through column of matrix
			if (this.adj[i][node-'A']==true){ // does an edge between a character and the node exist
				list.add((char)(i+65));
			}
		}
		return list;
	}
	public int size(){ // returns the size of the graph (the number of nodes in the graph)
		return this.adj.length;
	}		
	public Iterator<Character> iterator(){
		return new GraphIterator(this);
	}
	private class GraphIterator implements Iterator<Character>{
		private char start;
		private Graph g;
		public GraphIterator(Graph g){
			this.g = g;
			this.start = 'A';
		}
		public boolean hasNext(){
			return (start-'A' < g.size());
		}
		public Character next(){
			char output = start;
			start = (char)((start-'A')+1+'A');
			return output;
		}
	}
}

