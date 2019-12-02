package multiThreading;

import java.util.*;
import java.util.Set;

class Solution {
    
    public List<String> getPatForStr(String str){
        List<String> res = new LinkedList<>();
        
        for(int i =0;i<str.length();i++){
            StringBuilder strB = new StringBuilder(str);
            strB.setCharAt(i,'*');
            res.add(strB.toString());
        }
        return res;
    }
    
    
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
//        Set<String> wordList = new HashSet<>(wordList);
//        
//        if( ! wordList.contains(endWord)){
//            return 0;
//        }
        
        Map<String,Set<String>> dict = getMatcherDict(wordList);
        
        Set<String> visited = new HashSet<>();
        Queue<String> bfs = new LinkedList<>();
        
        bfs.add(beginWord);
        bfs.add("|");//delimeter to mark the level
        
        int res =1;
        
        while(!bfs.isEmpty()){
            String cur = bfs.remove();
            
            if(cur.equals("|") && !bfs.isEmpty()){
                bfs.add("|");
                res++;
                continue;
            }
            if(cur.equals(endWord)){
                return res;
            }
            addAllAdjacents(bfs,cur,dict,visited,wordList);
        }
        return 0;
    }
    public void addAllAdjacents(Queue<String> bfs, String cur, Map<String,Set<String>> 
                                dict, Set<String> visited, List<String> wordList){
        for(String pat : getPatForStr(cur)){
        	if(!dict.containsKey(pat)) {
        		continue;
        	}
            for(String adj : dict.get(pat)){
                if(!visited.contains(adj)){
                    bfs.add(adj);
                    visited.add(adj);
                }
            }
        }
    }
    
    public Map<String, Set<String>> getMatcherDict(List<String> wordList ){
        Map<String,Set<String>> dict = new HashMap<>();
        for(String word : wordList){
            for(String pat : getPatForStr(word)){
                if(!dict.containsKey(pat)){
                    dict.put(pat,new HashSet<>());
                }
                dict.get(pat).add(word);
            }
        }
        return dict;
    }
}
//Test class
public class WordLadder {

	public static void main(String[] args) {
		Solution sol = new Solution();
		String beginWord = "hit";
		String endWord = "cog";
		List<String> wordList = new LinkedList<String>(Arrays.asList("hot","dot","dog","lot","log","cog"));
		System.out.println(sol.ladderLength(beginWord, endWord, wordList));

	}

}
