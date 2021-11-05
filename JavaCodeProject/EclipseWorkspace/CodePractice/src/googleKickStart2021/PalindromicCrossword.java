package googleKickStart2021;

import java.util.*;

class Cell{
    public int i;
    public int j;

    public Cell(int i, int j) {
        this.i = i;
        this.j = j;
    }
}
public class PalindromicCrossword {

    static int rc =0;
    public static void main(String[] args) {


        int T;
        Scanner sc = new Scanner(System.in);
        T = sc.nextInt();
        

        for (int t = 1; t <= T; t++) {
            rc = 0;
            int n = sc.nextInt();
            int m = sc.nextInt();
            char[][] cw = new char[n][m];
            List<Cell> existingCells = new ArrayList<>();

            Set<Cell> visited = new HashSet<>();
            for (int i = 0; i < n; i++) {
                String row = sc.next();
                for (int j = 0; j < m; j++) {
                    cw[i][j] = row.charAt(j);

                    if (cw[i][j] != '.' && cw[i][j] != '#') {
                        existingCells.add(new Cell(i, j));
                    }

                }
            }
            for (Cell cell : existingCells) {
                dfs(cw, cell,visited);
            }
            System.out.println("Case #"+t+": "+rc);
            printGrid(cw,n,m);
        }

    }

    private static void dfs(char[][] cw, Cell cell, Set<Cell> visited) {
        
        if(visited.contains(cell)) return;
        
        visited.add(cell);
        
        List<Cell> adjCells = findAdjCells(cw, cell);
        
        for(Cell adjCell : adjCells){
            if(cw[adjCell.i][adjCell.j]=='.'){
                cw[adjCell.i][adjCell.j] =cw[cell.i][cell.j];
                rc++;
            }
            dfs(cw, adjCell, visited);
        }
    }

    private static List<Cell> findAdjCells(char[][] cw, Cell cell) {
        return null;
    }

    private static void printGrid(char[][] cw, int n, int m) {
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                System.out.print(cw[i][j]);
            }
            System.out.println("");
        }
    }

}
