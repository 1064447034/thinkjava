package sort.compare;

import java.util.Arrays;

public class Merge {
	public static void mergeSortRecursion(int arr[], int left, int right) {
		if (left == right) {
			return;
		}
		int mid = (left + right) / 2;
		mergeSortRecursion(arr, left, mid);
		mergeSortRecursion(arr, mid + 1, right);
		merge(arr, left, mid, right);
	}
	
	private static void merge(int arr[], int left, int mid, int right) {
		int len = right - left + 1;
		int index = 0;
		int i = left;
		int j = mid + 1;
		int temp[] = new int[len];
		while (i <= mid && j <= right) {
			temp[index++] = arr[i] <= arr[j] ? arr[i++] : arr[j++];
		}
		while (i <= mid) {
			temp[index++] = arr[i++];
		}
		while (j <= right) {
			temp[index++] = arr[j++];
		}
		for (int k = 0; k < len; ++k) {
			arr[left++] = temp[k];
		}
	}
	
	public static void main(String[] args) {
		int arr[] = { 6, 5, 3, 1, 8, 7, 2, 4 };
		mergeSortRecursion(arr, 0, arr.length - 1);
		System.out.println(Arrays.toString(arr));
	}
}
