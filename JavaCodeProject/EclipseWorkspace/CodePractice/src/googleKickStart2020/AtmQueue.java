package googleKickStart2020;

import java.util.*;

public class AtmQueue{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();


        for(int test = 1;test<=t;test++){
            int n = sc.nextInt();
            int x = sc.nextInt();

            Map<Integer, List<Integer>> timesMap = new HashMap<>();
            int maxTimes = 0;
            for(int i =1;i<=n;i++){
                int ai = sc.nextInt();
                int times = ai/x + (ai%x >0 ?1:0);
                List<Integer> timesList = timesMap.getOrDefault(times,new LinkedList<Integer>());
                timesList.add(i);
                timesMap.put(times,timesList);
                maxTimes = Math.max(maxTimes,times);
            }
            System.out.print("Case #"+test+":");
            for(int i =0;i<=maxTimes;i++){
                if(timesMap.containsKey(i)){
                    for(int index : timesMap.get(i)){
                        System.out.print(" "+index);
                    }
                }
            }
            System.out.println();

        }
    }
}