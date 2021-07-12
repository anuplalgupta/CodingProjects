package practice;

public class StringPermutationIncluded {
    public boolean checkInclusion(String s1, String s2) {
        int n1 = s1.length();
        int n2 = s2.length();

        int[] s1CharCount = new int[26];

        //process s1
        for(char ch : s1.toCharArray()){
            s1CharCount[ch-'a']++;
        }

        //process the first window of s2

        int[] s2CharCountWindow = new int[26];



        for(int i=0;i<n1;i++){
            s2CharCountWindow[s2.charAt(i)-'a']++;
        }

        //compare s1CharCount and s2charCount
        int matchCharCount = 0;

        for(int i =0;i<26;i++){
            if(s1CharCount[i]==s2CharCountWindow[i]){
                matchCharCount++;
            }
        }

        if(matchCharCount==26){
            return true;
        }

        for(int i=1;i<=n2-n1;i++){
            int j = i+n1-1;

            s2CharCountWindow[s2.charAt(i-1)-'a']--;
            if(s2CharCountWindow[s2.charAt(i-1)-'a']==s1CharCount[s2.charAt(i-1)-'a']){
                matchCharCount++;
            }else if(s2CharCountWindow[s2.charAt(i-1)-'a']+1==s1CharCount[s2.charAt(i-1)-'a']){
                matchCharCount--;
            }

            s2CharCountWindow[s2.charAt(j)-'a']++;
            if(s2CharCountWindow[s2.charAt(j)-'a']==s1CharCount[s2.charAt(j)-'a']){
                matchCharCount++;
            }else if(s2CharCountWindow[s2.charAt(j)-'a']-1==s1CharCount[s2.charAt(j)-'a']){
                matchCharCount--;
            }
            if(matchCharCount==26){
                return true;
            }
        }

        return false;
    }
}
