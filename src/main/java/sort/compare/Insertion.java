package sort.compare;

import java.util.Arrays;

public class Insertion {
	public static void sort(int arr[]) {
		for (int i = 1; i < arr.length; ++i) {
			int get = arr[i];
			int j = i - 1;
			while (j >= 0 && arr[j] > get) {
				arr[j + 1] = arr[j];
				j--;
			}
			arr[j + 1] = get;
		}
	}
	
	public static void main(String[] args) {
		int arr[] = { 6, 5, 3, 1, 8, 7, 2, 4 };
		sort(arr);
		System.out.println(Arrays.toString(arr));
	}
}
