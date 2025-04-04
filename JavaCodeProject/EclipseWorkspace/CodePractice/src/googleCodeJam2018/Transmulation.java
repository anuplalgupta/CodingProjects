package googleCodeJam2018;

import java.util.Scanner;

class MetalPair{
	int first,second;

	public MetalPair(int first, int second) {
		super();
		this.first = first;
		this.second = second;
	}

	public int getFirst() {
		return first;
	}

	public void setFirst(int first) {
		this.first = first;
	}

	public int getSecond() {
		return second;
	}

	public void setSecond(int second) {
		this.second = second;
	}

}

public class Transmulation {
	
	public static boolean ispossiblePerGram(MetalPair[] formula, int[] quantity, int metalIndex, int[] visited) {
		if(visited[metalIndex] ==1)
			return false;
		
		visited[metalIndex] = 1;
		int metalFirst = formula[metalIndex].getFirst();
		int metalSecond = formula[metalIndex].getSecond();
		if(quantity[metalFirst] >0 && quantity[metalSecond]>0)
		{
			return true;
			
		}
		else {
			boolean ret = true;
			if(quantity[metalFirst] <=0) {
				quantity[metalSecond]--;
				
				if(!ispossiblePerGram(formula,quantity,metalFirst,visited) ) {
					return false;
				}
				
			}
			if(quantity[metalSecond]<=0) {
				quantity[metalFirst]--;
				
				if(!ispossiblePerGram(formula,quantity,metalSecond,visited) ) {
					return false;
				}
			}
			return ret;
			
		}

	}
	public static boolean isPossible(MetalPair[] formula, int[] quantity) {
		int leadFormulaFirst = formula[0].getFirst();
		int leadFormulaSecond = formula[0].getSecond();
		if(quantity[leadFormulaFirst] >0 && quantity[leadFormulaSecond]>0) {
			quantity[leadFormulaFirst]--;
			quantity[leadFormulaSecond]--;
			return true;
			
		}
		else {
			int[] visited = new int[quantity.length];
			boolean ret = true;
			if(quantity[leadFormulaFirst] <=0) {
				quantity[leadFormulaSecond]--;
				
				if(!ispossiblePerGram(formula,quantity,leadFormulaFirst,visited) ) {
					return false;
				}
			}
			if(quantity[leadFormulaSecond]<=0){
				quantity[leadFormulaFirst]--;
				
				if(!ispossiblePerGram(formula,quantity,leadFormulaSecond,visited) ) {
					return false;
				}
			}
			return ret;
			
		}

		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int T;
		T = input.nextInt();
		int n = T;
		while(T>0) {
			T--;
			int m = input.nextInt();
			MetalPair formula[] = new MetalPair[m]; 
			for(int i =0;i<m;i++) {
				int first,second;
				first = input.nextInt()-1;
				second = input.nextInt()-1;
				formula[i] = new MetalPair(first, second);
			}
			int quantity[] = new int[m];
			for(int i =0;i<m;i++) {
				quantity[i] = input.nextInt();
			}
			int sum = quantity[0];
			quantity[0] =0;
			while(isPossible(formula,quantity)) {
				
				sum++;
				
			}
			System.out.println("Case #"+(n-T)+": "+sum);
			
		}
		input.close();
	}

}
