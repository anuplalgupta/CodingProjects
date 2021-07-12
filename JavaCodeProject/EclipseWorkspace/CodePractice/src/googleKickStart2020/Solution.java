package googleKickStart2020;


import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();


        for (int test = 1; test <= t; test++) {
            int n = sc.nextInt();
            int k = sc.nextInt();

            int[][] arr = new int[n][2];

            for(int i =0;i<n;i++){
                arr[i][0] = sc.nextInt();
                arr[i][1]= sc.nextInt();
            }

            Arrays.sort(arr, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return  Integer.compare(o1[0],o2[0]);
                }
            });
            int count =1;
            int nextLimit = k+arr[0][1];

            for(int i=0;i<n;i++){
                if(arr[i][1]<=nextLimit){
                    continue;
                }else{
                    count++;
                    nextLimit = Math.max(arr[i][0],nextLimit)+k;
                }
            }

            System.out.println("Case #"+test+": "+count);

        }

    }

}
