package hello;
//
//import java.io.*;
//import java.math.*;
//import java.security.*;
//import java.text.*;
//import java.util.*;
//import java.util.concurrent.*;
//import java.util.regex.*;
//
//
//
//class Result {
//
//    /*
//     * Complete the 'maximumOccurringCharacter' function below.
//     *
//     * The function is expected to return a CHARACTER.
//     * The function accepts STRING text as parameter.
//     */
//
//    public static char maximumOccurringCharacter(String text) {
//    // Write your code here
//        int n = text.length();
//        Map<Character,Integer> countMap = new HashMap<>();
//
//        for(int i =0;i<n;i++){
//            char temp = text.charAt(i);
//            if(!countMap.containsKey(temp)){
//                countMap.put(temp,1);
//            }else{
//                int count = countMap.get(temp);
//                countMap.put(temp,count+1);
//            }
//
//        }
//
//        int maxCount = Integer.MIN_VALUE + 1;
//        int maxIndex = 0;
//        for(int i =0;i<n;i++){
//            char temp = text.charAt(i);
//            int count = countMap.get(temp);
//            if(count > maxCount){
//                maxCount = count;
//                maxIndex = i;
//            }
//
//        }
//
//        return text.charAt(maxIndex);
//
//
//
//    }
//
//}
//
//public class Solution {
//    public static void main(String[] args) throws IOException {
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
//
//        String text = bufferedReader.readLine();
//
//        char result = Result.maximumOccurringCharacter(text);
//
//        bufferedWriter.write(String.valueOf(result));
//        bufferedWriter.newLine();
//
//        bufferedReader.close();
//        bufferedWriter.close();
//    }
//}



import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;





class TreeNode {
	List<TreeNode> children;
	
	int val;
	
	public TreeNode(int val) {
		// TODO Auto-generated constructor stub
		this.val = val;
		children = new LinkedList<TreeNode>();
	}
	
	
	public List<TreeNode> getChildren() {
		return children;
	}
	public void addChild(TreeNode child) {
		children.add(child);
	}
	public int getVal() {
		return val;
	}
	public void setVal(int val) {
		this.val = val;
	}
}



class Result {

    /*
     * Complete the 'bestSumAnyTreePath' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY parent
     *  2. INTEGER_ARRAY values
     */
	
	public static void buildTree(List<Integer> parent, List<Integer> values) {
		TreeNode root = new TreeNode(values.get(0)) ;
		for(int i =0;i<parent.size();i++) {
			
		}
		
		
	}

    public static int bestSumAnyTreePath(List<Integer> parent, List<Integer> values) {
    // Write your code here
    	int maxSumPath = Integer.MIN_VALUE +1;

    	List<List<Integer>> parentPathSum = new LinkedList<>();
    	
    	
    	int n = parent.size();
    	
    	int[] maxValueAtNode = new int[n];
    	for(int i =0;i<n;i++) {
    		
    		maxValueAtNode[i] = values.get(i);
    	}
    	
    	for(int i =0;i<n;i++) {
    		
    		
    		if(parent.get(i)== -1) {
    			continue;
    		}
    		
    		int curentParent = parent.get(i);
    		if(maxValueAtNode[curentParent]< maxValueAtNode[curentParent]+maxValueAtNode[i]) {
    			maxValueAtNode[curentParent] = maxValueAtNode[curentParent]+maxValueAtNode[i];
    		}
    		
    		if(maxValueAtNode[i] > maxSumPath) {
    			maxSumPath = maxValueAtNode[i];
    		}
    		
    		
    		    		
    	}
    	
    	
    	return maxSumPath;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int parentCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> parent = new ArrayList<>();

        for (int i = 0; i < parentCount; i++) {
            int parentItem = Integer.parseInt(bufferedReader.readLine().trim());
            parent.add(parentItem);
        }

        int valuesCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> values = new ArrayList<>();

        for (int i = 0; i < valuesCount; i++) {
            int valuesItem = Integer.parseInt(bufferedReader.readLine().trim());
            values.add(valuesItem);
        }

        int result = Result.bestSumAnyTreePath(parent, values);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}




