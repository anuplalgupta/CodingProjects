package practice;


public class MatrixParenthesization {
	
	int n;
	int[] matDimension;
	int[][] dp;
	
	
	public MatrixParenthesization(int n, int[] matDim) {
		super();
		this.n = n;
		this.matDimension = matDim;
		dp = new int[n+1][n+1];
		
		for(int j =0;j<=n;j++) {
			for(int k =0;k<=n;k++)
				dp[j][k] = -1;
		}
		
		for(int i =0;i<=n ;i++)
			dp[i][i] = 0;
		
	}

	public int costParenthesizationRec(int i, int j) {
		if(i +1 >=j)
			return 0;
		int cost = Integer.MAX_VALUE;
		
		
		for(int k=i+1;k<j;k++) {
			int costK = matDimension[i]*matDimension[k]*matDimension[j] + costParenthesizationRec(i,k) + costParenthesizationRec(k+1,j);
			if(costK < cost)
				cost = costK;
		}
		return cost;
	}
	
	public int costParenthesizationDPTabulation() {
		
		for(int length = 2;length < n;length++) {
			for(int i = 1;i<n-length+2;i++) {
				int j = i+length-1;
				int cost = Integer.MAX_VALUE;
				for(int k = i;k<j;k++) {
					int costK  = dp[i][k] + dp[k+1][j] + matDimension[i-1]*matDimension[k]*matDimension[j];
					if(costK < cost)
						cost = costK;
				}
				dp[i][j] = cost;
			}
		}		
		return dp[1][n];
	}
	
	public int costParenthesizationDPMemoization(int i , int j) {
		
		if(dp[i][j] != -1)
			return dp[i][j];
		
		int cost = Integer.MAX_VALUE;
		
		for(int k =1;k<j;k++) {
			int costK = costParenthesizationDPMemoization(i,k) + costParenthesizationDPMemoization(k+1,j) + matDimension[i-1]*matDimension[k]*matDimension[j];
			if(costK < cost)
				cost = costK;
		}
		dp[i][j] = cost;
		
		return dp[i][j];
	}
	
	public int costPrintParenthesizationDPMemoization(int i , int j) {
	
		//System.out.println("i is "+i + "j is "+j);
		
		if(dp[i][j] != -1) {
			if(i == j) {
				//System.out.print(i);	
			}
			return dp[i][j];
		}
		
		//System.out.print("(");
		int cost = Integer.MAX_VALUE;
		
		for(int k =i;k<j;k++) {
			// { 40, 20, 30, 10, 30 } 
			int costK = costPrintParenthesizationDPMemoization(i,k) + costPrintParenthesizationDPMemoization(k+1,j) + matDimension[i-1]*matDimension[k]*matDimension[j];
			if(costK < cost) {
				cost = costK;
				System.out.println(k);
			}
		}
		dp[i][j] = cost;
		//System.out.print(")");
		return dp[i][j];
	}
	
	
}
