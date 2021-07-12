package practice;

public class PatternMatching {
    Boolean[][] dp =null;
    int n,m;
    public boolean isMatch(String s, String p) {

        n = p.length();
        m = s.length();

        dp = new Boolean[n+1][m+1];

        dp[n][m] = Boolean.TRUE;

        for(int i=0;i<m;i++){//pattern is empty or smaller than string
            dp[n][i]= Boolean.FALSE;
        }
        return isMatchMemoDP(s,p,0,0);
    }

    public boolean isMatchMemoDP(String s, String p, int i, int j){

        if(i>n || j>m){
            return Boolean.FALSE;
        }

        if(dp[i][j]!=null){
            return dp[i][j];
        }

        boolean res = false;

        boolean patMatch = p.charAt(i) == '.' || p.charAt(i) == s.charAt(j);
        if(i<n-1 && p.charAt(i+1)=='*'){

            if(j<m){
                if(patMatch){

                    res = isMatchMemoDP(s, p, i + 2, j + 1) || isMatchMemoDP(s, p, i, j + 1);

                }
                res = res || isMatchMemoDP(s,p,i+2,j) || isMatchMemoDP(s,p,i+2,j);
            }else{
                res = isMatchMemoDP(s,p,i+2,j);
            }

        }else{
            if(i>=n){
                return false;
            }

            if(j<m){
                if(patMatch){
                    res = isMatchMemoDP(s,p,i+1,j+1);
                }
            }
        }

        dp[i][j]= res;
        return dp[i][j];
    }

}
