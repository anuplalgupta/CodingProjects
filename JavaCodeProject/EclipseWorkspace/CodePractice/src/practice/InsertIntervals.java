package practice;

import java.util.LinkedList;
import java.util.List;

/*
[] | []
[] | 0-1
[1-2, 3-4] | []
[1-4, 7-11] | [2-5]
[1-2, 3-4] | [1-2]

[1-2 6-9 | 0-7


*/
class Solution2 {
    
    public boolean isOverlapping(int[] i1, int[] i2){
        if(i1[0] >= i2[0] && i1[0] <= i2[1]){
            return true;
        }
        if(i2[0] >= i1[0] && i2[0] <= i1[1]){
            return true;
        }
        
        return false;
    }
    
    public int[] getInterval(int[] i1, int[] i2){
        int lower = i1[0] < i2[0] ? i1[0] : i2[0];
        int higher = i1[1] > i2[1] ? i1[1] : i2[1];
        
        int[] resultInterval = new int[2];
        resultInterval[0] = lower;
        resultInterval[1] = higher;
        
        return resultInterval;
    }
    public boolean isSmallerInterval(int[]i1, int[]i2){
        
        if(i1[1] < i2[0]){
            return true;
        }
        return false;
    }
    public int[][] insert(int[][] intervals, int[] newInterval) {
        boolean newIntervalInserted = false;
        
        int n = intervals.length;
        List<int[]> resultIntervals = new LinkedList<>();
        
        //Handle corner cases
        if(newInterval.length !=2 ){
            return intervals;
        }
        if(intervals.length == 0){
            resultIntervals.add(newInterval);
            return (int[][]) resultIntervals.toArray();
        }
        
        int i=0;
        for(int[] interval : intervals){
            
            if(!newIntervalInserted && isSmallerInterval(newInterval,interval)){
                resultIntervals.add(newInterval);
                newIntervalInserted = true;
            }
            if(!isOverlapping(interval, newInterval)){
            	resultIntervals.add(newInterval);
            }else{
                newInterval = getInterval(interval,newInterval);
            }
        }
        
        if(!newIntervalInserted){
        	resultIntervals.add(newInterval);
        }
        return (int[][]) resultIntervals.toArray();
        
    }
}

public class InsertIntervals {
	
	public static void printIntervals(int[][] intervals) {
		for(int[] interval : intervals) {
			System.out.print(interval[0]+"-"+interval[1]+",");
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[][] intervals = {{1,3},{6,9}};
		int[] newInterval = {2,5};
		Solution2 sol = new Solution2();
		int[][] resultIntervals = sol.insert(intervals, newInterval);

		printIntervals(resultIntervals);
	}

}
