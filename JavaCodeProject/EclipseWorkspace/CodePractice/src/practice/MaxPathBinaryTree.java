package practice;

class MaxPathBinaryTreeClass{
	int maxPath = Integer.MIN_VALUE;

	public int maxPathTillNode(TreeNode root){

		if(root==null){
			return 0;
		}

		int left = maxPathTillNode(root.left);
		int right = maxPathTillNode(root.right);
		int pathNode = Math.max(left,right)+root.val;

		maxPath = Math.max(left+right+root.val,maxPath);

		return pathNode;
	}

	public int maxPathSum(TreeNode root) {

		maxPathTillNode(root);
		return maxPath;

	}
}

public class MaxPathBinaryTree
{
	public static void main(String[] args){
		MaxPathBinaryTreeClass maxPathBinaryTreeClass = new MaxPathBinaryTreeClass();
		TreeNode root = new TreeNode();
		TreeNode left = new TreeNode();
		TreeNode right = new TreeNode();
		root.val =1;
		left.val =2;
		right.val=3;
		root.left =left;
		root.right = right;

		int maxPath = maxPathBinaryTreeClass.maxPathSum(root);
		System.out.println(maxPath);
	}

}
