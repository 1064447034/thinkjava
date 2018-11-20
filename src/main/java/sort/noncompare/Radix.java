package sort.noncompare;

import java.util.Arrays;

public class Radix {
	private static final int dn = 3;

	static int GetDigit(int x, int d)          // 获得元素x的第d位数字
	{
	    int radix[] = { 1, 1, 10, 100 };// 最大为三位数，所以这里只要到百位就满足了
	    return (x / radix[d]) % 10;
	}
	 
	public static void sort(int arr[], int d) {
		int k = 10;
		int c[] = new int[100];
		int b[] = new int[100];
		
		for (int i = 0; i < arr.length; i++) {
	        c[GetDigit(arr[i], d)]++;
	    }
		
		for (int i = 1; i < k; i++) {
	        c[i] = c[i] + c[i - 1];
	    }
		for (int i = arr.length - 1; i >=0; --i) {
			 int dight = GetDigit(arr[i], d);  // 元素A[i]当前位数字为dight  
		     b[--c[dight]] = arr[i];        
		}
		for (int i = 0; i < arr.length; i++) {
	        arr[i] = b[i];
	    }
	}
	
	public static void main(String[] args) {
		int arr[] = { 20, 90, 64, 289, 998, 365, 852, 123, 789, 456 };
		for (int d = 1; d <= dn; d++) {
		       sort(arr, d); 			
		}
		System.out.println(Arrays.toString(arr));
	}
}
