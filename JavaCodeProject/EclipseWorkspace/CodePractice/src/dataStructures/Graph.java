package dataStructures;

import java.util.List;
import java.util.Scanner;

class GraphNode{
	int value;
	List<GraphNode> adjacencyList;
}
public class Graph {
	GraphNode startNode;
	
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

}