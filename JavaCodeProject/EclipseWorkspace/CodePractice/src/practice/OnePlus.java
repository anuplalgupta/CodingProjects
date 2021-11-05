package practice;

public class OnePlus {
    public static int[] plusOne(int[] digits) {


        int carry =1;

        for(int i=digits.length-1;i>=0 && carry>0;i--){

            if(digits[i]==9){
                digits[i]=0;
            }else{
                digits[i]++;
                carry=0;
            }
        }

        if(carry>0){
            int[] res = new int[digits.length+1];
            res[0]=1;
            return res;
        }

        return digits;
    }
    public static void main(String[] args){
        int[] d = {1,2,3};
        int[] r = plusOne(d);
        System.out.println(r);
    }
}
