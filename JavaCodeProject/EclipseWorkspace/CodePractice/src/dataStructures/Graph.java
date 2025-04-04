package dataStructures;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

class GraphNode{
	int value;
	List<GraphNode> adjacencyList;
}
public class Graph {
	private GraphNode startNode;
	private LinkedList<Integer>[] adjacencyList;
	
	//take input from user to create a graph
	public GraphNode createGraph() {
		int v;//number of vertices
		Scanner input = new Scanner(System.in);
		
		//enter the number of nodes in Graph
		System.out.println("Please enter number of vertices");
		v = input.nextInt();
		System.out.println("Please enter number of edge");
		int e = input.nextInt();
		
		for(int i =0 ;i<e;i++) {
			
		}
		return startNode;
		
		
	}
	public LinkedList<Integer>[] createGraph(int numVertices){
		adjacencyList = new LinkedList[numVertices];
		Scanner input = new Scanner(System.in);
		
		for(int i=0;i<numVertices;i++) {
			adjacencyList[i] = new LinkedList<Integer>();
			System.out.println("Enter number of adjacent vertices for vertex "+(i+1));
			int n = input.nextInt();
			for(int j =0;j<n;j++) {
				System.out.println("Enter next adjacent vertex for "+(i+1));
				adjacencyList[i].add(input.nextInt());
			}
		}
		
		input.close();
		return adjacencyList;
	}
	

}