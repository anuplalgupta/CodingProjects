package practice;

public class RearrangeNegativePositive {

	public void reversePositive(int[] arr, int startIndex, int endIndex) {

		if (arr[endIndex] < 0)
			return;
		int positiveStart = startIndex;
		//for (; arr[positiveStart] < 0; positiveStart++) ;

		for (int i = positiveStart, j = endIndex; i < j; i++, j--) {
			int temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
		}
	}


	public void reverseNegative(int[] arr, int startIndex, int endIndex) {

		if (arr[startIndex] > 0)
			return;
		int negativeEnd = startIndex;
		//for (; arr[negativeEnd] < 0 && negativeEnd <= endIndex; negativeEng++) ;

		negativeEnd--;
		for (int i = startIndex, j = negativeEnd; i < j; i++, j--) {
			int temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
		}
	}

	public void reverseLpRn(int[] arr, int startIndexL, int endIndex) {

		if (arr[endIndex] < 0)
			return;

		int positiveStart = startIndexL;
		for (; arr[positiveStart] < 0 && positiveStart <= endIndex; positiveStart++) ;

		int negativeEnd = positiveStart + 1;

		if (negativeEnd > endIndex)
			return;

		for (; arr[negativeEnd] < 0 && negativeEnd <= endIndex; negativeEnd++)
			;
		negativeEnd--;
		for (int i = positiveStart, j = negativeEnd; i < j; i++, j--) {
			int temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
		}
	}

	public void printArray(int[] arr) {
		for (int i : arr) {
			System.out.print(i + "  ");
		}
	}


	public void rearrange(int[] arr, int startIndexL, int endIndexL, int startIndexR, int endIndexR) {
		reversePositive(arr, startIndexL, endIndexL);
		reverseNegative(arr, startIndexR, endIndexR);

		reverseLpRn(arr, startIndexL, endIndexR);

		return;
	}


	public void mergeRearrange(int[] arr, int startIndex, int endIndex) {
		if (startIndex == endIndex)
			return;

		int mid = (startIndex + endIndex) / 2;
		mergeRearrange(arr, startIndex, mid);
		mergeRearrange(arr, mid + 1, endIndex);

		rearrange(arr, startIndex, mid, mid + 1, endIndex);
		return;
	}
// -9 4 -8 3 -10

	public int[] rearrangeNegativePositive(int[] arr) {
		//varient of merge sort logic.
		//LnLpRnRp -->revert Lp and Rn --> LnLp'Rn'Rp
		//revert the Lp'Rn' together -->LnRnLpRp


		//mergerRearange(arr, 0, arr.length - 1);
		return arr;
	}
}

