package practice;

import java.util.*;
import java.lang.*;
import java.io.*;

class MatchPatternInteger 
 {
    public static String getMatchingMinInterger(String pat){
        
        StringBuilder result = new StringBuilder(pat+"0");
        int[] repeatations = new int[pat.length()];
        
        for(int i = pat.length()-1;i>=0;i--){
            if(pat.charAt(i) == 'I'){
                repeatations[i] =0;
            }else{
                if(i == pat.length()-1){
                    repeatations[i] =1;
                }else{
                    repeatations[i] =  repeatations[i+1]+1;
                }
            }
        }
        
        char val = Character.forDigit(repeatations[0]+1, 10);
        result.setCharAt(0 ,val);
        
        for(int i =0;i<pat.length();i++){
            
            val = '0';
            if(repeatations[i] == 0){
                if(i<pat.length()-1 && repeatations[i+1] >0){
                	int valFromI = Character.getNumericValue(result.charAt(i))+1;
                	int valFromD = repeatations[i+1]+1;
                    val = Character.forDigit(valFromI > valFromD ? valFromI : valFromD, 10);
                }else{
                    val = (char)(result.charAt(i)+1);
                }
                
            }else{
                val = Character.forDigit(repeatations[i], 10);                
            }
            
            result.setCharAt(i+1, val);
        }
        return result.toString();
    }
	public static void main (String[] args)
	 {
	    //code
	    Scanner sc = new Scanner(System.in);
	    int t = sc.nextInt();
	    while(t>0){
	        t--;
	        String pat = sc.next();
	        String minInteger = getMatchingMinInterger(pat);
	        System.out.println(minInteger);
	    }
	 }
}