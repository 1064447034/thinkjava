package sort.compare;

import java.util.Arrays;

public class Selection {
	public static void sort(int arr[]) {
		for (int i = 0; i < arr.length - 1; ++i) {
			int min = i;
			for (int j = i + 1; j < arr.length; ++j) {
				if (arr[j] < arr[min]) {
					int temp = arr[j];
					arr[j] = arr[min];
					arr[min] = temp;
				}
			}
			if (min != i) {
				int temp = arr[min];
				arr[min] = arr[i];
				arr[i] = temp;
			}
		}
	}
	
	public static void main(String[] args) {
		int arr[] = { 8, 5, 2, 6, 9, 3, 1, 4, 0, 7 };
		sort(arr);
		System.out.println(Arrays.toString(arr));
	}
}
