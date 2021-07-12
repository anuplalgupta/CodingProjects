package practice;

public class CalculateTax {

    //aaaaaa     p= a*aTax calculation
    //
    //10000 - 10%
    //20000 - 20%
    //30k - 30%
    //... - 40%
    //
    //15k
    //
    //100k = 10k * 0.1 + 20k * 0.2 + 30k * 0.3 + 40k* 0.4 = 1 + 4 + 9 + 16 = 30k
    //
    //15k = 10k * 0.1 + 5 * 0.2 =
    //
    //20k - 10%
    //5k - 30%
    //50k - 15%
    //..
    //
    //100.23
    //
    //public int calculateTax(double[][] taxBracks, double sal){
    //
    //  int n = taxBarcks.length;
    //  double taxRes = 0;
    //
    //  for(int i =0;i<n;i++){
    //
    //    double taxBrack = taxBracks[i][0];
    //    double rate = taxBracks[i][1];
    //
    //    double taxBrackFori = 0;
    //
    //    if(i<n-1){
    //      taxBrackFori = Math.min(taxBrack, sal);
    //    }else{
    //      taxBrackFori = sal;
    //    }
    //
    //    taxRes += taxBrackFori*rate;
    //    sal = sal - taxBrackFori;
    //
    //    if(sal<=0){
    //      break;
    //    }
    //
    //  }
    //  return taxRes;
    //
    //}
    //
    //
    //boolean is_match(String s, String regex) -
}
