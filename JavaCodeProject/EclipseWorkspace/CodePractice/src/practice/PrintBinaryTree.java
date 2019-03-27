package practice;

import dataStructures.BinaryTree;


public class PrintBinaryTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTree binaryTree = new BinaryTree(1);
		int[] nodeValues = {2,3,4,5,6,7,8};
		
		for(int i : nodeValues) {
			binaryTree.insert(i);
		}
		
		binaryTree.printTree();
		
	}

}
