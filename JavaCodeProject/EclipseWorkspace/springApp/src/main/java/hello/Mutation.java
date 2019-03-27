package hello;

import java.util.*;

public class Mutation
{
	public static int countMutation(StringBuilder a, StringBuilder b) {
		int mutationCount = 0;
		
        if(a.length() != b.length()) {
        	return -1;
        }

        int maxMutation = 25;
        while(maxMutation >0) {
        	maxMutation --;
        	if(a.equals(b)) {
        		return mutationCount;
        	}
        	boolean foundMutatedSubstr = false;
        	int i;
        	for(i =0;i<a.length();i++) {
        		
        		if(b.charAt(i)<a.charAt(i)) {
        			return -1;
        		}
        		if(a.charAt(i) != b.charAt(i) && !foundMutatedSubstr) {
        			foundMutatedSubstr = true;
        		}
        		if(a.charAt(i) != b.charAt(i) && foundMutatedSubstr) {
        			a.setCharAt(i, (char)(a.charAt(i)+1));
        		}else if(a.charAt(i) == b.charAt(i) && foundMutatedSubstr) {
        			foundMutatedSubstr = false;
        			mutationCount++;
        			break;
        		}
        	}
        	//no need to run for maxmutation if already have reached
        	if(i>=a.length()) {
        		return mutationCount;
        	}
        }
        
        
        return mutationCount;		
	}
     public static void main (String[] args)
     {
        // INPUT [uncomment & modify if required]
        Scanner scan = new Scanner(System.in);
        String A = scan.next();
        String B = scan.next();
        
        //Since case insensitive
        String a = A.toLowerCase();
        String b = B.toLowerCase();
        
        int mutationCount = countMutation(new StringBuilder(a),new StringBuilder(b));
                
        System.out.println(mutationCount);
	    scan.close();
      }
}
