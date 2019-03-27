package dataStructures;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {
	BinaryTreeNode root;
	
	public BinaryTree(int val){
		root = new BinaryTreeNode(val);
		
	}
	
	public boolean levelOrderSearch(int val) {
		
		Queue<BinaryTreeNode> traversalQ = new LinkedList<>();
		traversalQ.add(root);
		
		while(!traversalQ.isEmpty()) {
			BinaryTreeNode node = traversalQ.poll();
			if(node.getVal() == val) {
				return true;
			}
			
			if(node.getLeftChild() != null) {
				traversalQ.add(node.getLeftChild());
			}
			if(node.getRightChild() != null) {
				traversalQ.add(node.getRightChild());
			}
			
			
		}
		return false;
	}
	
	// insert the value at first level order null node
	public void insert(int val) {
		Queue<BinaryTreeNode> traversalQ = new LinkedList<>();
		traversalQ.add(root);
		
		while(!traversalQ.isEmpty()) {
			BinaryTreeNode node = traversalQ.poll();
	
			
			if(node.getLeftChild() != null) {
				traversalQ.add(node.getLeftChild());
			}else {
				node.setLeftChild(new BinaryTreeNode(val));
				return;
			}
			if(node.getRightChild() != null) {
				traversalQ.add(node.getRightChild());
			}else {
				node.setRightChild(new BinaryTreeNode(val));
				return;
			}
		}
	}
	
	public void printTree() {
		Queue<BinaryTreeNode> traversalQ = new LinkedList<>();
		traversalQ.add(root);
		//add level delimiter
		traversalQ.add(new BinaryTreeNode(-1));
		
		
		while(!traversalQ.isEmpty()) {
			BinaryTreeNode node = traversalQ.poll();
			//if its delimiter remove it and add deliver for next level
			if(node.getVal() == -1) {
				if(!traversalQ.isEmpty()) {
					traversalQ.add(new BinaryTreeNode(-1));
				}
				//print level seperator new line
				System.out.print("\n");
				//needed to not process the delimiter node
				continue;
			}
			
			System.out.print(node.getVal()+"\t");
			
			if(node.getLeftChild() != null) {
				traversalQ.add(node.getLeftChild());
			}
			if(node.getRightChild() != null) {
				traversalQ.add(node.getRightChild());
			}
		}
	}
}
