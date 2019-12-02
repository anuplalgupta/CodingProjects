package dataStructures;

import java.util.*;
import java.io.*;
import java.lang.*;
public class IsCyclic
{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            int nov = sc.nextInt();
            int edg = sc.nextInt();
            for(int i = 0; i < nov+1; i++)
                list.add(i, new ArrayList<Integer>());
            for(int i = 1; i <= edg; i++)
            {
                int u = sc.nextInt();
                int v = sc.nextInt();
                list.get(u).add(v);
            }
            if(new DetectCycle().isCyclic(list, nov) == true)
                System.out.println("1");
            else System.out.println("0");
        }
    }
}
/*This is a function problem.You only need to complete the function given below*/
/*Complete the function below*/
/*
ArrayList<ArrayList<Integer>> list: to represent graph containing 'v'
                                    vertices and edges between them
V: represent number of vertices
*/
class DetectCycle
{
    public static boolean isCyclicFromSrc(ArrayList<ArrayList<Integer>> list,int src){
        Stack<Integer> dfsStack = new Stack<>();
        boolean[] vis = new boolean[list.size()];
        dfsStack.push(src);
        
        while(!dfsStack.isEmpty()){
            int node = dfsStack.pop();
            if(vis[node]){
                return true;
            }
            vis[node] = true;
            for(int adjV : list.get(node)){
                dfsStack.push(adjV);
            }
        }
        
        return false;
    }
    static boolean isCyclic(ArrayList<ArrayList<Integer>> list, int V)
    {
        // add your code here
        for(int i=0;i<list.size();i++){
            if(isCyclicFromSrc(list,i)){
                return true;
            }
        }
        return false;
    }
}