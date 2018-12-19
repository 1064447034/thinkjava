package sort.compare;

import java.util.Arrays;

public class Quick {
	static int partition(int arr[], int left, int right) {
		int pivot = arr[right];
		int tail = left - 1;
		for (int i = left; i < right; ++i) {
			if (arr[i] <= pivot) {
				swap(arr, ++tail, i);
			}
		}
		swap(arr, tail + 1, right);
		return tail + 1;
	}

	static void swap(int A[], int i, int j) {
		int temp = A[i];
		A[i] = A[j];
		A[j] = temp;
	}

	public static void QuickSort(int arr[], int left, int right) {
		if (left >= right) {
			return;
		}
		int pivot_index = partition(arr, left, right);
		QuickSort(arr, left, pivot_index - 1);
		QuickSort(arr, pivot_index + 1, right);
	}

	public static void main(String[] args) {
		int arr[] = { 5, 2, 9, 4, 7, 6, 1, 3, 8 };
		QuickSort(arr, 0, arr.length - 1);
		System.out.println(Arrays.toString(arr));
	}
}
