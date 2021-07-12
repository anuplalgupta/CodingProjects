package practice;



import java.util.*;
import java.lang.*;
import java.io.*;

class TreeNode{
	public int val;
	public TreeNode left, right;
}
class PairFriends
 {
     public static long pairFriends(int n){
         if(n<=2){
             return n;
         }
         long prev = 2;
         long prevToPrev = 1;
         
         for(int i =3;i<=n;i++){
             long cur = prev + ((i-1)*(prevToPrev));
             prevToPrev = prev;
             prev = cur;
         }
         return prev;
     }
	public static void main (String[] args)
	 {
	 //code
		int[] arr = new int[0];
		System.out.println(arr);
	    Scanner sc = new Scanner(System.in);
	    int t = sc.nextInt();
	    while(t>0){
	        t--;
	        int n = sc.nextInt();
	        System.out.println(pairFriends(n));
	    }
	 }
}
