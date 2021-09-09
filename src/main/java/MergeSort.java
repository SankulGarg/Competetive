import java.util.Arrays;

public class MergeSort {

	public void mergeSort(int arr[], int l, int r) {

		if (l < r) {

			int m = l + (r - l) / 2;
			mergeSort(arr, l, m);
			mergeSort(arr, m + 1, r);

			merge(arr, l, m, r);
		}

	}

	private void merge(int[] arr, int l, int m, int r) {

		int n1 = m - l + 1;
		int n2 = r - m;

		int lArr[] = new int[n1];
		int rArr[] = new int[n2];

		for (int i = 0; i < n1; i++) {
			lArr[i] = arr[l+i];
		}

		for (int i = 0; i < n2; i++) {
			rArr[i] = arr[m + 1 + i];
		}

		int i = 0, j = 0, k = l;

		while (i < n1 && j < n2) {
			if (lArr[i] <= rArr[j]) {
				arr[k] = lArr[i];
				i++;
			} else {
				arr[k] = rArr[j];
				j++;
			}
			k++;
		}

		while (i < n1) {
			arr[k] = lArr[i];
			i++;
			k++;
		}
		while (j < n2) {
			arr[k] = rArr[j];
			j++;
			k++;
		}
	}
	public static void main(String[] args) {
		int arr[]= {42,2,5,6,1,-3};
		new MergeSort().mergeSort(arr, 0, arr.length-1);
		System.out.println(Arrays.toString(arr));
	}

}
