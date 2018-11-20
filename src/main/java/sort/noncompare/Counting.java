package sort.noncompare;

import java.util.Arrays;

// 计数排序
public class Counting {
	public static void sort(int arr[]) {
		int k = 100;
		int c[] = new int[k]; 
		int b[] = new int[arr.length];
		
		for (int i = 0; i < arr.length; ++i) {
			c[arr[i]]++;
		}
		for (int i = 1; i < k; ++i) {
			c[i] = c[i] + c[i - 1];
		}
		for (int i = arr.length - 1; i >= 0; --i) {
			b[--c[arr[i]]] = arr[i];
		}
		
		for (int i = 0; i < arr.length; ++i) {
			arr[i] = b[i];
		}
	}
	
	public static void main(String[] args) {
		int arr[] = { 15, 22, 19, 46, 27, 73, 1, 19, 8 };
		sort(arr);
		System.out.println(Arrays.toString(arr));
	}
}
