package practice;

import dataStructures.BinaryTreeNode;

public class BinaryTreeMaximumPathSum {

    int maxPath = Integer.MIN_VALUE;
    public int maxPathSum(BinaryTreeNode root) {
        if(root==null){
            return 0;
        }
        int mpr = maxPathTillTheRoot(root);
        maxPath = Math.max(maxPath,mpr);
        return maxPath;
    }

    public int maxPathTillTheRoot(BinaryTreeNode root){
        if(root==null) return 0;

        int maxPathLeft = maxPathTillTheRoot(root.getLeftChild());
        int maxPathRight = maxPathTillTheRoot(root.getRightChild());
        int maxPathThroughRoot = maxPathLeft + root.getVal() + maxPathRight;
        maxPath = Math.max(maxPath, Math.max(maxPathThroughRoot, root.getVal()+Math.max(maxPathLeft,maxPathRight)));
        return root.getVal() + Math.max(maxPathLeft, maxPathRight);

    }
}
