package practice;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathBinaryMatrix {
    class GraphNode{
        public int i,j;

        public GraphNode(int i, int j){
            this.i =i;
            this.j =j;
        }

    }

    public void addAdjs(Queue<GraphNode> q, int i, int j, int[][] grid, boolean[][] v){

        int n = grid.length;
        for(int a=i-1;a<=i+1;a++){
            for(int b=j-1;b<=j+1;b++){
                if(a<0 || b<0 || a>n-1 || b> n-1 || v[a][b] || grid[a][b]==1){
                    continue;
                }
                q.add(new GraphNode(a,b));
                v[a][b] = true;
            }
        }
    }
    //Using BFS
    public int shortestPathBinaryMatrix(int[][] grid) {

        int m = grid.length;

        if(grid[0][0]>0){
            return -1;
        }

        boolean [][] v = new boolean[m][m];
        v[0][0] = true;

        int res = 1;

        Queue<GraphNode> q = new LinkedList<>();

        q.add(new GraphNode(0,0));

        while(!q.isEmpty()){

            int vSize = q.size();
            for(int i=0;i<vSize;i++){
                GraphNode n = q.poll();

                if(n.i==m-1 && n.j==m-1){
                    return res;
                }



                addAdjs(q,n.i,n.j,grid,v);

            }
            res++;
        }
        return -1;
    }

    //Using DP matrix
    public int shortestPathBinaryMatrixDP(int[][] grid) {

        int n = grid.length;

        if(grid[0][0]>0){
            return -1;
        }

        int[][] dp = new int[n][n];

        dp[0][0] = 1;
        for(int i =0;i<n;i++){
            for(int j=0;j<n;j++){

                if(i==0 && j==0){
                    continue;
                }
                if(grid[i][j]>0){
                    dp[i][j] = Integer.MAX_VALUE;
                    continue;
                }
                int minAdj = (i>0 && j >0) ? dp[i-1][j-1] : Integer.MAX_VALUE;
                minAdj = Math.min(minAdj, (i>0?dp[i-1][j]: Integer.MAX_VALUE));
                minAdj = Math.min(minAdj, j>0 ?dp[i][j-1]: Integer.MAX_VALUE);
                minAdj = Math.min(minAdj, j<n-1 && i>0 ?dp[i-1][j+1] : Integer.MAX_VALUE);
                dp[i][j] = minAdj < Integer.MAX_VALUE ? 1+minAdj : Integer.MAX_VALUE;

            }
        }
        return dp[n-1][n-1]==Integer.MAX_VALUE?-1:dp[n-1][n-1];
    }

}