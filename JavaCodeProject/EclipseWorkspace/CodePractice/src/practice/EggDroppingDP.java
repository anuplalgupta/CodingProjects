package practice;

import java.util.*;


class EggDroppingDP{
	
    public static int max(int a, int b){
        return a > b ? a : b;
    }
    public static int minTrialEgg(int n, int k){
        int[][] result = new int[k+1][n];
        
        if(n == 1 || k ==0 || k==1 ){
            return k;
        }
        //for floor 0 and 1, same no. of tries are enough
        for(int i = 0;i<n;i++){
            result[0][i] = 0;
            result[1][i] = 1;
        }
        
        //if there is only one egg no of tries will be same as number of floors.
        for(int i = 0;i<k+1;i++){
            result[i][0] = i;
        }
        
        for(int i = 2;i<k+1;i++){
            for(int j = 1;j<n;j++){
                int min = Integer.MAX_VALUE;
                
                for(int x = 1;x<=i;x++){
                    int res = max(result[x-1][j-1], result[i-x][j]);
                    if(res < min){
                        min = res;
                    }
                }
                result[i][j] = 1+min;
            }
        }
        
        return result[k][n-1];
        
    }
    
	public static void main (String[] args)
	 {
	 //code
	    Scanner sc = new Scanner(System.in);
	    int t = sc.nextInt();
	    while(t>0){
	        t--;
	        int n = sc.nextInt();
	        int k = sc.nextInt();
	        System.out.println(minTrialEgg(n,k));
	        
	    }
	 }
}