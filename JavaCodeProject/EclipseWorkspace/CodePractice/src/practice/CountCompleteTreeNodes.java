package practice;

public class CountCompleteTreeNodes {

    public int calcHeightLeft(TreeNode root){

        if(root == null) return 0;

        return 1+ calcHeightLeft(root.left);
    }

    public int calcHeightRight(TreeNode root){
        if(root == null) return 0;

        return 1+calcHeightRight(root.right);
    }
    public int countNodes(TreeNode root) {
        if(root == null) return 0;

        int hl = calcHeightLeft(root.left);
        int hr = calcHeightRight(root.right);

        if(hl==hr) return (int)Math.pow(2,hl+1) -1;

        return 1 + countNodes(root.left) + countNodes(root.right);
    }
}
