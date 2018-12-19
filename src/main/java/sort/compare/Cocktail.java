package sort.compare;

import java.util.Arrays;

/**
 * 鸡尾酒排序，也叫定向冒泡排序，是冒泡排序的一种改进。此算法与冒泡排序的不同处在于从低到高然后从高到低，
 * 而冒泡排序则仅从低到高去比较序列里的每个元素。他可以得到比冒泡排序稍微好一点的效能。
 */
public class Cocktail {
	public static void sort(int arr[]) {
		int left = 0;
		int right = arr.length - 1;
		while (left < right) {
			for (int i = left; i < right; ++i) {
				if (arr[i] > arr[i + 1]) {
					int temp = arr[i];
					arr[i] = arr[i + 1];
					arr[i + 1] = temp;
				}
			}
			right--;
			for (int j = right; j > left; --j) {
				if (arr[j - 1] > arr[j]) {
					int temp = arr[j - 1];
					arr[j - 1] = arr[j];
					arr[j] = temp;
				}
			}
			left++;
		}
	}

	public static void main(String[] args) {
		int arr[] = { 6, 5, 3, 1, 8, 7, 2, 4 };
		sort(arr);
		System.out.println(Arrays.toString(arr));
	}
}
