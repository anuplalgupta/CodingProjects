package practice;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

import com.sun.org.apache.bcel.internal.generic.JsrInstruction;
import dataStructures.BinaryTree;
import dataStructures.BinaryTreeNode;
import org.json.*;

public class TestDriver {

    public static String readInputFile(){
        String filePath = "C:\\Users\\anuplalgupta\\Downloads\\grid.json";
        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines( Paths.get(filePath), StandardCharsets.UTF_8))
        {
            stream.forEach(s -> contentBuilder.append(s).append("\n"));
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        return contentBuilder.toString();
    }

    public static void main(String[] args){

//        StringPermutationIncluded stringPermutationIncluded = new StringPermutationIncluded();
//
//        String s1 = "ab";
//        String s2 = "eidbaooo";
//
//        boolean result = stringPermutationIncluded.checkInclusion(s1,s2);
//
//        System.out.println(result);

//        ShortestPathBinaryMatrix shortestPathBinaryMatrix = new ShortestPathBinaryMatrix();
//
//        int[][] grid = new int[][]{{0,0,0},{0,0,0},{0,0,0}};
//        int res = shortestPathBinaryMatrix.shortestPathBinaryMatrixDP(grid);
//        System.out.println(res);

//        ClosestValueInSortedArray closestValueInSortedArray = new ClosestValueInSortedArray();
//        int[] arr = {1,2,5};
//        int res = closestValueInSortedArray.closestValue(arr,0);
//        System.out.println(res);

//        KidnappersMaze kidnappersMaze = new KidnappersMaze();
//        kidnappersMaze.testSampleInputs();

//        ShortestUnsortedContinuousSubarray sucs = new ShortestUnsortedContinuousSubarray();
//        int[] arr = new int[]{6,7,8,1,2,3,4,9,10,9,8};
//        int res = sucs.findUnsortedSubarray(arr);
//        System.out.println(res);
//        LongestSubstringWithoutRepeatingCharacters lswrc = new LongestSubstringWithoutRepeatingCharacters();
//        int res = lswrc.lengthOfLongestSubstring("abcdeft");
//        System.out.println(res);

        ClosestDessertCost cdc = new ClosestDessertCost();
        int[] a = {2,3};
        int[] b = {4,5,100};
        int t = 18;

//        int res = cdc.closestCost(a,b,t);
//        System.out.println(res);

//        BinaryTreeNode root = new BinaryTreeNode(1);
//        BinaryTreeNode left = new BinaryTreeNode(2);
//        BinaryTreeNode right = new BinaryTreeNode(3);
//        root.setLeftChild(left);
//        root.setRightChild(right);
//        BinaryTreeMaximumPathSum btmps = new BinaryTreeMaximumPathSum();
//        btmps.maxPathSum(root);

        TreeNode root = new TreeNode();
        root.val = 1;
        TreeNode l = new TreeNode();
        l.val = 2;
        TreeNode r = new TreeNode();
        r.val = 3;
        TreeNode ll = new TreeNode();
        ll.val=4;
        TreeNode lr = new TreeNode();
        lr.val=5;
        TreeNode rl = new TreeNode();
        rl.val=6;
        root.left= l;
        root.right=r;
        l.left =ll;
        l.right=lr;
        r.left=rl;
        CountCompleteTreeNodes cctn = new CountCompleteTreeNodes();
        int nc = cctn.countNodes(root);

    }
}
