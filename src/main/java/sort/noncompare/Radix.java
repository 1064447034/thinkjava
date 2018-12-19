package sort.noncompare;

import java.util.Arrays;

// 基数排序
public class Radix {
	public static void sort(int arr[], int d) {
		int n = 1;
		boolean hasNum = false;
		int[][] temp = new int[d][arr.length];
		int[] order = new int[d];
		while (true) {
			if (n != 1 && !hasNum) {
				break;
			}
			
			hasNum = false;
			for (int i = 0; i < arr.length; ++i) {
				int x = arr[i] / (n * 10);
				if (x != 0) {
					hasNum = true;
				}
				int lsd = x % 10;
				temp[lsd][order[lsd]] = arr[i];
				order[lsd]++;
			}
			int k = 0; 
			for (int i = 0; i < d; ++i) {
				if (order[i] != 0) {
					for (int j = 0; j < order[i]; ++j) {
						arr[k] = temp[i][j];
						k++;
					}
				}
				order[i] = 0;
			}
			n++;
		}
	}
	
	public static void main(String[] args) {
		int arr[] = { 20, 90, 64, 289, 998, 365, 852, 123, 789, 456 };
		sort(arr, 10);
		System.out.print(Arrays.toString(arr));	
//		for (int i = 0; i < arr.length; ++i) {
//			System.out.print(Arrays.toString(arr) + " ");			
//		}
	}
}
