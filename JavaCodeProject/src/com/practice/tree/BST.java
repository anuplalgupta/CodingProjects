/**
 * 
 */
package com.practice.tree;

/**
 * @author LAL
 *
 */
public interface BST {
	
	public boolean search(int value);
	public void printInorderTraversal(TreeNode root);
	public void addElement(TreeNode node);
	public TreeNode getRoot();
	
}
