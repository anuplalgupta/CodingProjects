package practice;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.*;

public class KidnappersMaze {



    // recursive solution
    // method goes to all reachable neighbours
    public void findSolution(String[][]grid, int i, int j, int pi, int pj, int ppi, int ppj,int pppi, int pppj, int m, List<String> sol, Set<ArrayList<Integer>> flags){
        if(i<0 || j <0 || i>= grid.length || j >= grid[0].length || grid[i][j].equals("b") || visitCount[i][j]>3 ||  (pi==pppi && pj== pppj && i==ppi && j==ppj)){
            return;
        }
        visitCount[i][j]++;
        if(grid[i][j].equals("t")){
            m = m+1;
        }

        if(grid[i][j].equals("f") && !flags.contains(new ArrayList<>(Arrays.asList(i, j)))){
            flags.add(new ArrayList<>(Arrays.asList(i, j)));
        }

        //traverse conclusion
        if(flags.size()==flagCount){
            if(m<minMove){
                minMove = m;
                res = sol.toArray(new String[0]);
            }
            return;
        }

        //upwoard movement
        List<String> nextSolU = new ArrayList<>(sol);
        nextSolU.add("u");
        Set<ArrayList<Integer>> newFlagsU = new HashSet<>(flags);
        int mU;
        if(i-1==pi && j == pj){
            mU = m;
        }else{
            mU = m+1;
        }
        findSolution(grid,i-1,j,i,j,pi, pj,ppi,ppj, mU,nextSolU, newFlagsU);

        //Left movement
        List<String> nextSolL = new ArrayList<>(sol);
        nextSolL.add("l");
        Set<ArrayList<Integer>> newFlagsL = new HashSet<>(flags);
        int mL;
        if(i==pi && j-1 == pj){
            mL = m;
        }else{
            mL = m+1;
        }
        findSolution(grid,i,j-1,i,j,pi, pj,ppi,ppj,mL,nextSolL, newFlagsL);

        //Right movement
        List<String> nextSolR = new ArrayList<>(sol);
        nextSolR.add("r");
        Set<ArrayList<Integer>> newFlagsR = new HashSet<>(flags);
        int mR;
        if(i==pi && j+1 == pj){
            mR = m;
        }else{
            mR = m+1;
        }
        findSolution(grid,i,j+1,i,j,pi, pj,ppi,ppj,mR,nextSolR, newFlagsR);

        //downward movement
        List<String> nextSolD = new ArrayList<>(sol);
        nextSolD.add("d");
        Set<ArrayList<Integer>> newFlagsD = new HashSet<>(flags);
        int mD;
        if(i+1==pi && j == pj){
            mD = m;
        }else{
            mD = m+1;
        }
        findSolution(grid,i+1,j,i,j,pi, pj,ppi,ppj,mD,nextSolD, newFlagsD);


    }

    public void findSolutionOpt(String[][]grid, int i, int j, int pi, int pj, int ppi, int ppj,int pppi, int pppj, int m, List<String> sol, Set<ArrayList<Integer>> flags){
        if(i<0 || j <0 || i>= grid.length || j >= grid[0].length || grid[i][j].equals("b") || visitCount[i][j]>4 ||  (pi==pppi && pj== pppj && i==ppi && j==ppj)){
            return;
        }
        visitCount[i][j]++;
        if(grid[i][j].equals("t")){
            m = m+1;
        }
        boolean foundFlag = false;
        if(grid[i][j].equals("f") && !flags.contains(new ArrayList<>(Arrays.asList(i, j)))){
            flags.add(new ArrayList<>(Arrays.asList(i, j)));
            foundFlag = true;
        }

        //traverse conclusion
        if(flags.size()==flagCount){
            if(m<minMove){
                minMove = m;
                res = sol.toArray(new String[0]);
            }
            flags.remove(new ArrayList<>(Arrays.asList(i, j)));
            return;
        }

        //upwoard movement
//        List<String> nextSolU = new ArrayList<>();
//        nextSolU.addAll(sol);
//        nextSolU.add("u");
//        Set<ArrayList<Integer>> newFlagsU = new HashSet<>();
//        newFlagsU.addAll(flags);
        sol.add("u");
        int mU;
        if(i-1==pi && j == pj){
            mU = m;
        }else{
            mU = m+1;
        }
        findSolutionOpt(grid,i-1,j,i,j,pi, pj,ppi,ppj, mU,sol, flags);
        sol.remove(sol.size()-1);

        //Left movement
//        List<String> nextSolL = new ArrayList<>();
//        nextSolL.addAll(sol);
//        nextSolL.add("l");
//        Set<ArrayList<Integer>> newFlagsL = new HashSet<>();
//        newFlagsL.addAll(flags);
        sol.add("l");
        int mL;
        if(i==pi && j-1 == pj){
            mL = m;
        }else{
            mL = m+1;
        }
        findSolutionOpt(grid,i,j-1,i,j,pi, pj,ppi,ppj,mL,sol, flags);
        sol.remove(sol.size()-1);

        //Right movement
//        List<String> nextSolR = new ArrayList<>();
//        nextSolR.addAll(sol);
//        nextSolR.add("r");
//        Set<ArrayList<Integer>> newFlagsR = new HashSet<>();
//        newFlagsR.addAll(flags);
        sol.add("r");
        int mR;
        if(i==pi && j+1 == pj){
            mR = m;
        }else{
            mR = m+1;
        }
        findSolutionOpt(grid,i,j+1,i,j,pi, pj,ppi,ppj,mR,sol, flags);
        sol.remove(sol.size()-1);


        //downward movement
//        List<String> nextSolD = new ArrayList<>();
//        nextSolD.addAll(sol);
//        nextSolD.add("d");
//        Set<ArrayList<Integer>> newFlagsD = new HashSet<>();
//        newFlagsD.addAll(flags);
        sol.add("d");
        int mD;
        if(i+1==pi && j == pj){
            mD = m;
        }else{
            mD = m+1;
        }
        findSolutionOpt(grid,i+1,j,i,j,pi, pj,ppi,ppj,mD,sol, flags);
        sol.remove(sol.size()-1);

        if(foundFlag){
            flags.remove(new ArrayList<>(Arrays.asList(i, j)));
        }
        return;
    }




    //Set<ArrayList<Integer>> flagIndices = new HashSet<>();
    int flagCount;
    public String[] res;
    public int minMove = Integer.MAX_VALUE;
    int[] s;
    int[][] visitCount;

    public String[] solve(String[][] grid){
        //lets represent graphs nodes with int[] of size 2

        findStartAndFlags(grid);
        findSolution(grid,s[0],s[1],-1,-1,-2,-2,-3,-3,0, new ArrayList<>(), new HashSet<>());
        return res;
    }

    public String[] solveOpt(String[][] grid){
        //lets represent graphs nodes with int[] of size 2

        findStartAndFlags(grid);
        findSolutionOpt(grid,s[0],s[1],-1,-1,-2,-2,-3,-3,0, new ArrayList<>(), new HashSet<>());
        return res;
    }

    public void findStartAndFlags(String[][] grid){

        int m = grid.length;
        int n = grid[0].length;

        visitCount = new int[m][n];
        for(int i =0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j].equals("f")){
                    flagCount++;
                }
                if(grid[i][j].equals("s")){
                    s = new int[]{i,j};
                }
            }
        }

    }

    public void testSampleInputs(){
        String[][] input2 = new String[][]{{"s","f","t"},
                {"f","b","f"}};

        String str = "{\"grid\":[[\"s\",\"f\"],[\"f\",\"b\"]]}";
        str = "{\"grid\":[[\"s\",\"f\",\"t\"],[\"f\",\"b\",\"f\"]]}";
        str = "{\"grid\":[[\"f\",\"e\",\"t\",\"e\",\"e\"],[\"e\",\"e\",\"e\",\"e\",\"t\"],[\"t\",\"t\",\"t\",\"e\",\"e\"],[\"f\",\"s\",\"e\",\"t\",\"t\"],[\"f\",\"t\",\"t\",\"t\",\"e\"],[\"e\",\"e\",\"t\",\"e\",\"t\"],[\"e\",\"t\",\"e\",\"b\",\"e\"],[\"t\",\"e\",\"e\",\"t\",\"t\"]]}";

        str = "{\"grid\":[[\"e\",\"e\",\"e\",\"e\",\"t\",\"e\",\"t\"],[\"t\",\"t\",\"t\",\"e\",\"e\",\"e\",\"e\"],[\"t\",\"f\",\"e\",\"e\",\"e\",\"e\",\"f\"],[\"t\",\"e\",\"t\",\"e\",\"e\",\"e\",\"e\"],[\"e\",\"e\",\"e\",\"b\",\"e\",\"e\",\"t\"],[\"e\",\"t\",\"t\",\"t\",\"e\",\"t\",\"e\"],[\"t\",\"e\",\"e\",\"s\",\"e\",\"t\",\"t\"],[\"f\",\"e\",\"f\",\"e\",\"t\",\"e\",\"t\"]]}";
        str = "{\"grid\":[[\"s\",\"t\",\"t\",\"t\",\"t\",\"t\",\"t\"],[\"t\",\"t\",\"t\",\"t\",\"t\",\"t\",\"t\"],[\"e\",\"e\",\"e\",\"e\",\"e\",\"e\",\"e\"],[\"t\",\"t\",\"t\",\"t\",\"t\",\"t\",\"t\"],[\"t\",\"t\",\"t\",\"t\",\"t\",\"t\",\"f\"]]}";
        //str = readInputFile();
        JSONObject inputJson = new JSONObject(str);

        JSONArray gridJsonArray = inputJson.getJSONArray("grid");
        String[][] input = new String[gridJsonArray.length()][gridJsonArray.getJSONArray(0).length()];
        for(int i =0;i<gridJsonArray.length();i++){
            JSONArray jsonArray = gridJsonArray.getJSONArray(i);
            for(int j =0;j<jsonArray.length();j++){
                input[i][j] = jsonArray.getString(j);
            }
        }

        String[] stringList = solveOpt(input);


        JSONObject outputJson = new JSONObject("{}");
        outputJson.put("moves",stringList);
        JSONObject res = new JSONObject("{}");
        res.put("grid",inputJson);
        res.put("moves",outputJson);
        System.out.println(res.toString());
    }
}
