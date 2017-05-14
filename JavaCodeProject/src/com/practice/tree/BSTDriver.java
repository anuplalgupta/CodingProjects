package com.practice.tree;

import java.util.Scanner;

public class BSTDriver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int noOfNodes = in.nextInt();
		int rootNodeValue = in.nextInt();
		TreeNode root = new TreeNode(rootNodeValue);
		
		
		BST myBST = new BSTImpl(root);
		
		for(int i =0;i<noOfNodes-1;i++){
			int newNodeValue = in.nextInt();
			myBST.addElement(new TreeNode(newNodeValue));
		}
		
		myBST.printInorderTraversal(myBST.getRoot());

	}

}
