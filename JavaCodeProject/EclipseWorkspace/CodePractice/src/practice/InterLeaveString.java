package practice;
import java.util.*;
import java.lang.*;
public class InterLeaveString
{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t>0)
        {
            String a =sc.next();
            String b = sc.next();
            String c = sc.next();
            GfG g=new GfG();
        
            System.out.println(g.isInterLeave(a,b,c)==true?1:0);
            t--;
        }
    }
}


/*This is a function problem.You only need to complete the function given below*/
/*you are required to complete this method */
class GfG{
	public boolean isInterLeave(String a,String b,String c)
	{
            //Your code here
            StringBuilder s1 = new StringBuilder(a);
            StringBuilder s2 = new StringBuilder(b);
            StringBuilder s = new StringBuilder(c);
            
            int i=0, j=0;

            while(i<s1.length() && j<s.length()){
                
                if(s1.charAt(i) == s.charAt(j)){
                	s.setCharAt(j,' ');
                    i++;
                    j++;
                    
                }else{
                    j++;
                }
            }
            
            if(i<s1.length()){ // didn't find all the chars in s1
                return false;
            }
            
            i=0;
            j=0;
            while(i<s2.length() && j<s.length()){
                
                if(s2.charAt(i) == s.charAt(j)){
                    i++;
                    j++;
                }else{
                    j++;
                }
            }
            if(i<s2.length()){
                return false;
            }
            
            return true;
	}
}
