package practice;


import java.util.*;
import java.math.BigInteger;
class BigIntegerJavaLargestPrimeFactor
 {
	public static void main (String[] args)
	 {
	    Scanner in = new Scanner(System.in);
	    int t = in.nextInt();
	    
	    while(t>0){
	        t--;
	        long n = in.nextLong();
	       // BigInteger bn = new BigInteger(String.valueOf(n));
	       // if(bn.isProbablePrime(1)){
	       //     System.out.println(bn);
	       // }
	        long largestPrimeFactor = 1;
	        
	        long divisor = 2;
	        while(divisor <= n/2){
	            if(n%divisor == 0){
	                largestPrimeFactor = divisor;
	            }
	            BigInteger b = new BigInteger(String.valueOf(divisor));
	            divisor = Long.parseLong(b.nextProbablePrime().toString());
	            
	        }
	        System.out.println(largestPrimeFactor);
	        
	    }
	    in.close();
	 }
}