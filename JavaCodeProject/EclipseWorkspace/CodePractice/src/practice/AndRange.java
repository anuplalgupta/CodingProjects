package practice;

public class AndRange
{
	public static int rangeBitwiseAnd(int m, int n) {

		int k = (int) (Math.log(m)/Math.log(2));

		int res =0;

		for(int l=k;l>=0;l--){
			int lMask = (int)Math.pow(2,l);
			if((m & lMask) >0){
				int temp = lMask*2;
				temp = temp | res;
				if(l<30 && temp >= m && temp <=n){
					return res;
				}else{
					res+=lMask;
				}
			}
		}
		return res;

	}
	public static void main(String[] args){
		System.out.println(rangeBitwiseAnd(2147483646,2147483647));
	}
}
