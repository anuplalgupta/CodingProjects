package practice;

import java.util.*;
import java.lang.*;
import java.io.*;
class ModuloPower
 {
	public static void main (String[] args)
	 {
    	 Scanner sc = new Scanner(System.in);
	    int t = sc.nextInt();
	    while(t>0){
	        t--;
	        int a = sc.nextInt();
	        int b = sc.nextInt();
	        int c = sc.nextInt();
	        
	        a = a%c;
	        int fractC = c / a;
	        if(c%a != 0){
	            fractC++;
	        }
	        b = b %c;
	        int result = (int)Math.pow(a,b);
	        result = result % c;
	        System.out.println(result);
	    }
	 }
}
