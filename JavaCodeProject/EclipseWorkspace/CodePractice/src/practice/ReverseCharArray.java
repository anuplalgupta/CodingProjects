package practice;

public class ReverseCharArray {
	
	
	public static char[] reverseCharArray(char[] carr) {
		//reversed array will of same size as input array
		char[] reverseCharArray = new char[carr.length];
		
		int index = carr.length -1;
		for(char temp:carr) {
			reverseCharArray[index] = temp;
			index--;
		}
		
		return reverseCharArray;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		char[] charArray = {'h','e','l','l','o'};
		
		System.out.println(reverseCharArray(charArray));
	}

}
