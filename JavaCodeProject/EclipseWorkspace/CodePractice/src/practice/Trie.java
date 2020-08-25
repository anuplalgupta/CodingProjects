package practice;

import java.util.Arrays;


class TrieNode{
	public boolean[] charPresent = new boolean[26];
	public TrieNode[] nodeArray = new TrieNode[26];
}
class Trie {

	TrieNode root;
	/** Initialize your data structure here. */
	public Trie() {
		root = new TrieNode();
	}

	public void insert(String pre, TrieNode tNode){
		if(pre == null || pre.equals("")){
			return;
		}
		char c  = pre.charAt(0);
		TrieNode childNode = new TrieNode();
		if(tNode.charPresent[c-'a']){
			childNode = tNode.nodeArray[c-'a'];
		}else{
			tNode.charPresent[c-'a'] = true;
			tNode.nodeArray[c-'a'] = childNode;
		}
		insert(pre.substring(1), childNode);
	}

	/** Inserts a word into the trie. */
	public void insert(String word) {
		insert(word, root);
	}

	public boolean search(String word, TrieNode tNode){
		if(tNode == null || !tNode.charPresent[word.charAt(0)-'a']){
			return false;
		}
		if(word.length()==1){
			for(TrieNode tn : tNode.nodeArray[word.charAt(0)-'a'].nodeArray){
				if(tn!=null){
					return false;
				}
			}
			return true;
		}
		return search(word.substring(1),tNode.nodeArray[word.charAt(0)-'a']);
	}

	/** Returns if the word is in the trie. */
	public boolean search(String word) {
		return search(word, root);
	}

	public boolean startsWith(String word, TrieNode tNode){
		if(tNode == null || !tNode.charPresent[word.charAt(0)-'a']){
			return false;
		}
		if(word.length()==1){
			return true;
		}
		String[] splittedText = word.split(" ");


		return search(word.substring(1),tNode.nodeArray[word.charAt(0)-'a']);
	}

	/** Returns if there is any word in the trie that starts with the given prefix. */
	public boolean startsWith(String prefix) {
		return startsWith(prefix, root);
	}
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
