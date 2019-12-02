package practice;

public class BuildA0 {
	
	public static boolean canBuildA0(int[] arr, int i, int count){
        if(i>= arr.length){
            return false;
        }
        if(arr[i] >= count){
            return true;
        }
        return canBuildA0(arr,i+1,(count - arr[i])*2);
     }
        
    public static String canBuild(int[] A){
        
        return canBuildA0(A,0,1) ? "Possible" : "Impossible";
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {0,1};
		System.out.println(canBuild(arr));
	}

}
