package practice;

public class ClosestValueInSortedArray {
    public int binarySearchClosest(int[] arr,int v, int i, int j){
        //Algo
        //Modified binary search
        //  i = j-1 return closer element
        //look at mid if its equal to the val return mid
        //else if mid< v  (mid,j)
        // else (i,mid)
        if(i>=j-1){
            return Math.abs(arr[i]-v)<Math.abs(arr[j]-v)? arr[i] : arr[j];
        }

        int mid = (i+j)/2;
        if(arr[mid]== v){
            return v;
        }else if(arr[mid]<v){
            return binarySearchClosest(arr,v,mid,j);
        }else{
            return binarySearchClosest(arr,v,i,mid);
        }

    }
    public int closestValue(int[] arr, int v){

        return binarySearchClosest(arr,v,0,arr.length-1);
    }
}
