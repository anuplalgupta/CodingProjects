package practice;

public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {

        //Algo T = O(n), S =O(1)
        //Iterate though the string maintaining index of each of unique charecter and the start of the window
        //Whenever a duplicate char is encountererd update the result with max windowSize and updated the start window position = IndexOf(duplicateChar)+1;
        //We only deep a char duplicate if the index >= windowStart;

        if(s==null || s.length()<2){
            return s.length();
        }
        int[] iMap = new int[26];
        //for(int i=0;i<26;i++) iMap[i]=-1;
        int res = 1;
        int si = 0;
        //iMap[s.charAt(0)-'a'] =0;
        int i =1;
        for(;i<s.length();i++){

            if(iMap[s.charAt(i)-'a']>si || s.charAt(i)==s.charAt(si)){
                res = Math.max(res, i-si);
                si = iMap[s.charAt(i)-'a']+1;
            }
            iMap[s.charAt(i)-'a']=i;

        }

        res = Math.max(res, i-si);

        return res;

        //Test cases
        // 1. Basic sanity test => s in not null and not empty;
        // 2. Entire string is unique abcdefg
        // 3. Entire string is made of same char bbbbbb
        // 4. String of size 2 (min) ab  bb
        // 5. Mixed
        //      aaabcdefff
        //      bbbbbcdef
        //      abcddddd

    }
}
