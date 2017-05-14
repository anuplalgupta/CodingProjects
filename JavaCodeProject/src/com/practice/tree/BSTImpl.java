package com.practice.tree;


public class BSTImpl implements BST {
	
	private TreeNode root;
	
	public BSTImpl(TreeNode root){
		this.root = root;
	}
	
	@Override
	public boolean search(int value) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void printInorderTraversal(TreeNode rootNode) {
		// TODO Auto-generated method stub
		if(rootNode == null){
			return;
		}
		printInorderTraversal(rootNode.getLeftNode());
		System.out.println(rootNode.getValue());
		printInorderTraversal(rootNode.getRightNode());
		

	}

	public TreeNode getRoot() {
		return root;
	}

	public void setRoot(TreeNode root) {
		this.root = root;
	}

	@Override
	public void addElement(TreeNode node) {
		System.out.println("adding value "+node.getValue());
		// TODO Auto-generated method stub
		TreeNode newRoot = root;
		while(true){
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(node.getValue() <= newRoot.getValue()){
				System.out.println("goint to left of" + newRoot.getValue());
				if(newRoot.getLeftNode() != null){
					
					newRoot = newRoot.getLeftNode();
					
					continue;
				}else{
					newRoot.setLeftNode(node);
					return;
				}
			}
			else{
				System.out.println("goint to right of" + newRoot.getValue());
				if(newRoot.getRightNode() != null){
					newRoot = newRoot.getRightNode();
					continue;			
				}else{
					newRoot.setRightNode(node);
					return;
				}
			}
		}
	}

}
