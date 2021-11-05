package googleKickStart2021;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SuffledAnagram {

    static String res = "IMPOSSIBLE";
    public static void main(String[] args){


        int T;
        Scanner sc = new Scanner(System.in);

        T = sc.nextInt();

        for(int t = 1;t<=T;t++){

            String str = sc.next();
            res = "IMPOSSIBLE";
            Map<Character, Integer> charCount = new HashMap<>();

            for(char c : str.toCharArray()){
                charCount.put(c, charCount.getOrDefault(c,0)+1);
            }

            getSuffledAnagram(str, "",charCount);

            System.out.println("Case #"+t+": "+res);
        }
    }

    public static boolean getSuffledAnagram(String str, String r, Map<Character, Integer> charMap){

        if(str.length()==r.length()) {
            res = r;
            return true;
        }


        for(char c : charMap.keySet()){
            if(charMap.get(c)>0 && str.charAt(r.length())!=c){
                charMap.put(c, charMap.get(c)-1);
                if(getSuffledAnagram(str, r+c, charMap)) return true;
                charMap.put(c, charMap.get(c)+1);
            }
        }
        return false;
    }
}
