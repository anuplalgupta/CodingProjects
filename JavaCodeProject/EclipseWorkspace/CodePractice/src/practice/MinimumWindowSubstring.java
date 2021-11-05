package practice;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MinimumWindowSubstring {
    public static String minWindow(String s, String t) {

        String res = "";

        Map<Character,Integer> charCount = new HashMap<>();
        Set<Character> charSet = new HashSet<>();
        for(int i=0;i<t.length();i++){
            charCount.put(t.charAt(i), charCount.getOrDefault(t.charAt(i),0)+1);
            charSet.add(t.charAt(i));
        }

        int i =0,j=0;
        Map<Character,Integer> wCharCount = new HashMap<>();
        while(i<=j && j<=s.length()){

            //Shrink the window if found one
            while(i<=j && charSet.isEmpty()){

                if(wCharCount.get(s.charAt(i))==charCount.get(s.charAt(i))){
                    if(res.length()==0 || j-i<res.length()){
                        res = s.substring(i,j);
                    }
                    charSet.add(s.charAt(i));
                }
                wCharCount.put(s.charAt(i),wCharCount.get(s.charAt(i))-1);
                i++;
            }

            if(j>=s.length()) break;

            //expand Window
            while(j<s.length() && !charSet.isEmpty()){

                wCharCount.put(s.charAt(j),wCharCount.getOrDefault(s.charAt(j),0)+1);

                if(wCharCount.get(s.charAt(j))==charCount.getOrDefault(s.charAt(j),0)){
                    charSet.remove(s.charAt(j));
                }
                j++;
            }

        }
        return res;


    }

    public static void main(String[] args){
        String s = "ADOBECODEBANC";
        String t = "ABC";
        String res = minWindow(s,t);
        System.out.println(res);
    }
}
