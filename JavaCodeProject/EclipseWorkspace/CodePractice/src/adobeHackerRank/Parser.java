package adobeHackerRank;
import java.util.Stack;

class Parser{
    public boolean isBalanced(String str){
        Stack<Character> bracketBalanced = new Stack<Character>();
        for(int i=0;i<str.length();i++){
            if(str.charAt(i) == '{' || str.charAt(i) == '('){
                bracketBalanced.push(str.charAt(i));
            }
            else if (str.charAt(i) =='}') {
                if(bracketBalanced.pop() !='{' )
                	return false;
            }
            else if(str.charAt(i) ==')') {
            	if(bracketBalanced.pop() !='(')
            		return false;
            }
        }
        if(bracketBalanced.isEmpty())
        	return true;
        return false;
    }
}