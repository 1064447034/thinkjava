package sort.compare;

import java.util.Arrays;

public class Bubble {
	public static void sort(int arr[]) {
		for (int i = 0; i < arr.length - 1; ++i) {
			for (int j = 0; j < arr.length - i - 1; ++j) {
				if (arr[j] < arr[j + 1]) {
					int tmp = arr[j + 1];
					arr[j + 1] = arr[j];
					arr[j] = tmp;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		int arr[] = { 6, 5, 3, 1, 8, 7, 2, 4 };
		sort(arr);
		System.out.println(Arrays.toString(arr));
	}
	
}
