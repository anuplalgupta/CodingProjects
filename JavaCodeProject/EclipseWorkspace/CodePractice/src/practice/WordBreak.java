package practice;
import java.util.*;
import java.lang.*;
import java.io.*;
class WordBreak{
	
    public static int isWordBreakable(String str,Set<String> dict){
        
        int n = str.length();
        
        //create a boolean result set to identify if str[0..i] is breakable
        boolean[] result = new boolean[n+1];
        result[0] = true;
        result[1] = dict.contains(str.substring(0,1));
        
        for(int i = 2;i<n+1;i++){
            result[i] = false;
            for (int j = i-1 ; j>=0;j--){
            	String subString = str.substring(j,i);
                if(result[j] && dict.contains(subString)){
                    result[i] = true;
                    break;
                }
            }
        }
        return result[n] ? 1 : 0;
    }
	public static void main (String[] args)
	 {
	 //code
	    Scanner sc = new Scanner(System.in);
	    int t = sc.nextInt();
	    while(t>0){
	        t--;
	        int n = sc.nextInt();
	        Set<String> dict = new HashSet<>();
	        
	        for(int i =0;i<n;i++){
	            dict.add(sc.next());
	        }
	        
	        String str = sc.next();
	        
	        System.out.println(isWordBreakable(str, dict));
	    }
	 }
}