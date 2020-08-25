package practice;
import java.util.*;
import java.lang.*;
import java.io.*;

import javafx.util.Pair;


class SolutionKthLargest {
	public static int maximalSquare(char[][] matrix) {

		int m = matrix.length;
		int n = matrix[0].length;

		int[][] dp = new int[m][n];

		int maxLeng = 0;
		for(int i=0;i<m;i++){
			dp[i][0] = matrix[i][0];
			maxLeng = Math.max(dp[i][0],maxLeng);
		}
		for(int j=0;j<n;j++){
			dp[0][j] = matrix[0][j];
			maxLeng = Math.max(dp[0][j],maxLeng);
		}


		for(int i=1;i<m;i++){
			for(int j=1;j<n;j++){
				if(matrix[i][j] ==1){
					dp[i][j] = Math.min(dp[i-1][j],Math.min(dp[i][j-1], dp[i-1][j-1])) +1;
					maxLeng = Math.max(maxLeng,dp[i][j]);

				}
			}
		}

		return maxLeng;

	}
	public static int  findKthLargest(int[] arr, int k){

		PriorityQueue<Integer> pq = new PriorityQueue<>(k+1);

		for(int i : arr){
			if(pq.size()>=k && pq.peek()<i){
				pq.poll();
				pq.add(i);
			}else if(pq.size()<k){
				pq.add(i);
			}
		}

		return pq.poll();

	}
	public static void swap(int[]arr, int i, int j){
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	public static int kthSmallest(int[] arr, int s, int e, int k){
		if(s>=e){
			return arr[s];
		}


		int pivotIndex = partition(arr,s,e);

		if(pivotIndex==k)
		{
			return arr[pivotIndex];
		}else if(pivotIndex>k){
			return kthSmallest(arr, s, pivotIndex-1, k);
		}else{
			return kthSmallest(arr, pivotIndex+1, e, k);
		}

	}
	public static int partition(int[] arr, int s, int e){
		int pivotIndex = (s+e)/2;
		int pivot = arr[pivotIndex];
		while (s<e){
			while(s<e && arr[s]<=pivot){
				s++;
			}
			while(s<e&& arr[e]> pivot){
				e--;
			}
			if(s<e){
				swap(arr,s,e);
			}
		}
		pivotIndex = e-1;
		return  pivotIndex;
	}


	int minLength = 0;
	List<String> visited = new ArrayList<>();

	//Assuming s and t are of same length
	public static boolean isDiffOneChar(String s, String t){

		int diff =0;

		for(int i =0;i<s.length();i++){
			if(diff>1){
				return false;
			}
			if(s.charAt(i)!= t.charAt(i))
				diff++;
		}

		if(diff!=1){
			return false;
		}


		return true;
	}

	public int ladderLength(String b, String e, List<String> wordList, int l, Set<String> visited){
		int index = 0;

		if(b.equals(e)){
			return l;
		}
		for(int i=index;i<wordList.size();i++){
			String str = wordList.get(i);
			if(isDiffOneChar(b,str) && !visited.contains(str)){
				visited.add(str);
				System.out.println(str);
				int len = ladderLength(str, e,wordList,l+1,visited );
				System.out.println("Lenght so far "+len);
				if(len>0){
					if(minLength==0){
						minLength = len;
					}else{
						minLength = Math.min(minLength,len);
					}
				}
				visited.remove(str);
			}
		}

		return minLength;
	}

	public int ladderLength(String beginWord, String endWord, List<String> wordList) {

		Set<String> visited = new HashSet<>();
		//wordSet.addAll(wordList);
		ladderLength(beginWord, endWord, wordList, 0,visited);
		return minLength==0?minLength:minLength+1;

	}
}
class StockSpanner {

	Stack<Pair<Integer,Integer>> spanStk = new Stack<>();
	int lastIndex = -1;
	public StockSpanner() {

	}


	public int next(int price) {
		int span = 1;
		if(!spanStk.isEmpty()){
			Pair<Integer,Integer> lastPrice = spanStk.peek();

			while(!spanStk.isEmpty() && lastPrice.getValue()<price){
				spanStk.pop();
				if(!spanStk.isEmpty())
					lastPrice = spanStk.peek();
			}

			if(spanStk.isEmpty()){
				spanStk.push(new Pair<Integer,Integer>(lastIndex+1,price));
				span = lastIndex+2;
			}else if(lastPrice.getValue()>price){
				span = lastIndex - lastPrice.getKey()+1;
				spanStk.push(new Pair<Integer,Integer>(lastIndex+1,price));
			}else if(lastPrice.getValue()==price){
				span = lastIndex - lastPrice.getKey()+2;
			}
		}else{
			spanStk.push(new Pair<Integer,Integer>(lastIndex+1,price));

		}
		lastIndex++;
		return span;
	}
}

public class GFG
{
	public static int bitwiseComplement(int N) {

		int mask = ~0;
		int l = (int)(Math.log10(N)/Math.log10(2));
		mask = mask << l+1;
		return ~N & ~mask;
	}

	public static int twoCitySchedCost(int[][] costs) {

		int n = costs.length;

		PriorityQueue<Integer> groupA = new PriorityQueue<>(n / 2 + 1, (a,b)->
		{
			return (costs[a][1]-costs[a][0])-(costs[b][1]-costs[b][0]);
//
		});

		for(int i=0;i<n;i++){
			if(groupA.size()<n/2){
				groupA.add(i);
				continue;
			}

			int index = groupA.poll();

			if(costs[i][1]-costs[i][0]> costs[index][1]-costs[index][0]){
				index = i;
			}
			groupA.add(index);
		}

		int res =0;
		int an = 0;
		int index = groupA.peek();
		int thresoldA = costs[index][1] - costs[index][0];

		List<Integer> tIndex = new LinkedList<>();

		for(int i =0;i<n;i++){
			int[] cost = costs[i];
			if(cost[1]-cost[0]> thresoldA){//add to groupA
				res += cost[0];
				an++;
			}else if(cost[1]-cost[0]< thresoldA){
				res += cost[1];
			}else{
				tIndex.add(i);
			}
		}

		if(tIndex.size()>0)
		{
			for (int ind : tIndex){

				if (an < n / 2)
				{
					res += costs[ind][0];
					an++;
					continue;
				}
				res+=costs[ind][1];
			}
		}
		return res;
	}
	public static int solution(String S, int[] C) {
		// write your code in Java SE 8

		int n = S.length();
		int cost = 0;
		int i =1;
		//int max = C[0];
		while(i<n){
			int max = C[i-1];
			while(i<n && S.charAt(i)==S.charAt(i-1)){

				if(max<C[i]){
					cost += max;
					max=C[i];
				}else{
					cost += C[i];
				}

				i++;
			}

			i++;
		}
		return cost;
	}

	public static void main (String[] args)
	{
		//code
		SolutionKthLargest sol = new SolutionKthLargest();
//		List<String> dict = Arrays.asList("leet","code");
		//System.out.println(SolutionWordBreak.wordBreak("leetcode",dict));

//		int[] arr = {3,2,1,5,6,4};
//		int k = 3;
		//System.out.println(SolutionKthLargest.kthSmallest(arr,0,arr.length-1,arr.length-k));
//		int pi = SolutionKthLargest.partition(arr,0,arr.length-1);
//		System.out.println(arr);
//		System.out.println(pi);
//		int bil = 1000000000;
//		String b = "qa";
//		String e = "sq";
//		List<String> wordList = Arrays.asList("si","go","se","cm","so","ph","mt","db","mb","sb","kr","ln","tm","le","av","sm","ar","ci","ca","br",
//											  "ti","ba","to","ra","fa","yo","ow","sn","ya","cr","po","fe","ho","ma","re","or","rn","au","ur",
//											  "rh","sr","tc","lt","lo","as","fr","nb","yb","if","pb","ge","th","pm","rb","sh","co","ga","li",
//											  "ha","hz","no","bi","di","hi","qa","pi","os","uh","wm","an","me","mo","na","la","st","er","sc",
//											  "ne","mn","mi","am","ex","pt","io","be","fm","ta","tb","ni","mr","pa","he","lr","sq","ye");
//		System.out.println(bitwiseComplement(5));

//		System.out.println(sol.ladderLength(b,e,wordList));
//		Trie trie = new Trie();
//		trie.insert("apple");
//		trie.search("apple");

//		StockSpanner ss = new StockSpanner();
//		int[] input = {28,14,28,35,46,53,66,80,87,88};
//		for(int i : input){
//			int res = ss.next(i);
//			System.out.println(res);
//		}
//		int[][] costs = {{33,135},{849,791},{422,469},{310,92},{253,489},{995,760},{852,197},
//						 {658,216},{679,945},{197,341},{362,648},{22,324},{408,25},{505,734},
//						 {463,279},{885,512},{922,850},{784,500},{557,860},{528,367},{877,741},
//						 {554,545},{598,888},{558,104},{426,427},{449,189},{113,51},{201,221},
//						 {251,62},{981,897},{392,519},{115,70},{961,109},{512,678},{476,708},
//						 {28,902},{763,282},{787,774},{925,475},{253,532},{100,502},{110,857},
//						 {822,942},{231,186},{869,491},{651,344},{239,806},{651,193},{830,360},
//						 {427,69},{776,875},{466,81},{520,959},{798,775},{875,199},{110,396}};
//		int res = twoCitySchedCost(costs);
		int[] arr = {0, 1, 2, 3, 4, 5};
		int res = solution("abccbd",arr);

		System.out.println(res);
	}
}
