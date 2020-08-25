package practice;

class StringShifts {

	public static String leftShift(String str, int offset){
		String suffix = str.substring(0,offset);
		String prfix = str.substring(offset,str.length());
		return prfix+suffix;
	}
	// public String rightShift(String str, int offset){
	//     String suffix = str.substring(0,str.length()-offset-1);
	//     String prefix =
	// }
	public static String stringShift(String s, int[][] shift) {
		int totalShift =0;

		for(int[] shiftEntry : shift){
			totalShift += (shiftEntry[0]==0?shiftEntry[1]:(-1)*shiftEntry[1]);
		}

		totalShift %= s.length();
		if(totalShift == 0){
			return s;
		}else if(totalShift >0 ){
			return leftShift(s, totalShift);
		}else{
			return leftShift(s, s.length()-Math.abs(totalShift));
		}

	}

	public static void main(String[] args){
		int[][] arr =  {{0,1},{1,2}};
		String str = "abc";
		System.out.println(stringShift(str,arr));
	}
}