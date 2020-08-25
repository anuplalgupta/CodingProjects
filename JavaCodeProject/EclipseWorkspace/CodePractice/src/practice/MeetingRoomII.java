package practice;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;


class MeetingRoomIISchedule
{
	public int maxRoomNeede(int[][] schedule){
		int res=Integer.MAX_VALUE;
		Arrays.sort(schedule, new Comparator<int[]>()
		{
			@Override
			public int compare(final int[] t1, final int[] t2)
			{
				return Integer.compare(t1[0],t2[0]);
			}
		});

		PriorityQueue<Integer> endTimePriority = new PriorityQueue<>();
		for(int[] sch : schedule){
			int start = sch[0];
			int end = sch[1];
			if(endTimePriority.peek()<start){
				endTimePriority.remove();
			}
			endTimePriority.add(end);
			res = Math.max(res,endTimePriority.size());
		}
		return res;
	}
}
public class MeetingRoomII{
	public static void main(String[] args){

	}
}
