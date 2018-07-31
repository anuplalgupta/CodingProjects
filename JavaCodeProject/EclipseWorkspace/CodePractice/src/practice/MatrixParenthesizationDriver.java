package practice;

public class MatrixParenthesizationDriver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 4;
		int[] matDim = {40, 20, 30, 10, 30};
		
		MatrixParenthesization matParen = new MatrixParenthesization(n,matDim);
		int cost = matParen.costPrintParenthesizationDPMemoization(1, n);
		
		System.out.println("\n"+cost);

	}

}
