package practice;

import java.util.Scanner;

class SolutionLSS {
    public static int lengthOfLongestSubstringTwoDistinct(String s) {
        
        if(s == null){
            return 0;
        }
        if(s.length()<=2){
            return s.length();
        }
        char a = s.charAt(0);
        char b = s.charAt(0);
        int maxLength = Integer.MIN_VALUE;
        int i,j;
        for(i =0,j=1;j<s.length();){
            
            if(s.charAt(j) != b ){
                
                if(a == b){
                    b = s.charAt(j);
                    j++;
                    continue;
                }
            }
            if(s.charAt(j) == a || s.charAt(j) == b){
                j++;
                continue;
            }
            if(maxLength < (j-i)){
                maxLength = j-i;
            }
            //move i to remove first element from the window
            int k ;
            for(k=j-1;k>=i;k--){
                if(s.charAt(k) != s.charAt(j-1)){
                    i = k+1;
                    break;
                }
            }
            a = s.charAt(i);
            b = s.charAt(j);
        }
        
        //for last window
        if(maxLength < (j-i)){
            maxLength = j-i;
        }
        return maxLength;
    }
}
public class TwoLetterLargestSubstring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
        SolutionLSS sl = new SolutionLSS();
		System.out.println(sl.lengthOfLongestSubstringTwoDistinct(str));
	}

}
