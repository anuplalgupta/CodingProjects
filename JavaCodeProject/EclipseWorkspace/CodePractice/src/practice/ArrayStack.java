package practice;

public class ArrayStack {
	private static long[] stack = new long[10];
	private static int topIndex = -1;
	
	
	public static void push(long val) {
		//Limit on size of stack = 10
		if(topIndex >9) {
			return;
		}
		topIndex++;
		stack[topIndex] = val;
	}
	
	public static long pop() {
		
		//check if stack is empty
		if(topIndex <0) {
			return -99999L;
		}
		
		long retVal = stack[topIndex];
		topIndex--;
		return retVal;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		push(1);
		push(2);
		System.out.println(pop());
		System.out.println(pop());
	}

}
