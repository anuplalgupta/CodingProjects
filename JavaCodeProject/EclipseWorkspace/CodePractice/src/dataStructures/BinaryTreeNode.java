package dataStructures;

public class BinaryTreeNode {
	BinaryTreeNode leftChild, rightChild;
	int val;
	
	public BinaryTreeNode(int val) {
		// TODO Auto-generated constructor stub
		this.val = val;
	}
	public BinaryTreeNode getLeftChild() {
		return leftChild;
	}
	public void setLeftChild(BinaryTreeNode leftChild) {
		this.leftChild = leftChild;
	}
	public BinaryTreeNode getRightChild() {
		return rightChild;
	}
	public void setRightChild(BinaryTreeNode rightChild) {
		this.rightChild = rightChild;
	}
	public int getVal() {
		return val;
	}
	public void setVal(int val) {
		this.val = val;
	}
}
