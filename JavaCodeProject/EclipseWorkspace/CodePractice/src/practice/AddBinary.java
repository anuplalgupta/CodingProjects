package practice;

public class AddBinary {


        public static String addBinary(String a, String b) {

            String res = "";

            int c =0;

            int n = a.length();
            int m = b.length();

            for(int i = n-1,j=m-1;i>=0 || j>=0;i--,j--){


                int ab = i>=0 ? a.charAt(i)-'0': 0;
                int bb = j>=0 ? Integer.valueOf(b.charAt(j)): 0;

                int sb = (ab+bb+c)%2;
                c = (ab+bb+c)/2;

                res = sb + res;

            }

            if(c>0){
                res = c+res;
            }
            return res;
        }

        public static void main(String[] args){
            String a = "0", b="1";
            String s = addBinary(a,b);
            System.out.println(s);
        }

}
