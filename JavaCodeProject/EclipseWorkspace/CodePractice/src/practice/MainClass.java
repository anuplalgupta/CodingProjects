package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;


class Solution {
	public int maxArea(int[] height) {
		Stack<Integer> hStack = new Stack<>();
		int maxCapacity = 0;
		hStack.push(0);

		for(int i =1;i<height.length;i++){

			int leftGHeight = height[hStack.peek()];
			if(leftGHeight > height[i] ){

				int vol = (i-hStack.peek())* Math.min(height[i],leftGHeight);
				maxCapacity = Math.max(maxCapacity, vol);
				hStack.push(i);

			}else{

				int left = hStack.peek();
				while(!hStack.isEmpty() && height[left]<height[i] ){
					left = hStack.pop();
				}
				int vol = Math.min(height[left],height[i])*(i-left);

				maxCapacity = Math.max(maxCapacity,vol);
				if(height[left] > height[i] || hStack.isEmpty()){
					hStack.push(i);
				}
			}
		}
		return maxCapacity;
	}
}

public class MainClass {
	public static int[] stringToIntegerArray(String input) {
		input = input.trim();
		input = input.substring(1, input.length() - 1);
		if (input.length() == 0) {
			return new int[0];
		}

		String[] parts = input.split(",");
		int[] output = new int[parts.length];
		for(int index = 0; index < parts.length; index++) {
			String part = parts[index].trim();
			output[index] = Integer.parseInt(part);
		}
		return output;
	}


	public static void main(String[] args) throws IOException
	{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String line;
		while ((line = in.readLine()) != null) {
			int[] height = stringToIntegerArray(line);

			int ret = new Solution().maxArea(height);

			String out = String.valueOf(ret);

			System.out.print(out);
		}
	}
}