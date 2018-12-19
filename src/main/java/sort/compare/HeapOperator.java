package sort.compare;

import java.util.Arrays;

// 二叉堆, 最小堆为例
public class HeapOperator {
	public static void upAdjust(int[] array) {
		int childIndex = array.length - 1;
		int parentIndex = (childIndex - 1) / 2;
		
		int temp = array[childIndex];
		while (childIndex > 0 && temp < array[parentIndex]) {
			array[childIndex] = array[parentIndex];
			childIndex = parentIndex;
			parentIndex = (parentIndex - 1) / 2; 
		}
		array[childIndex] = temp;
	}
	
	public static void downAdjust(int[] array, int parentIndex, int length) {
		int temp = array[parentIndex];
		int childIndex = 2 * parentIndex + 1;
		while (childIndex < length) {
			if (childIndex + 1 < length && array[childIndex + 1] < array[childIndex]) {
				childIndex++;
			}
			if (temp <= array[childIndex]) {
				break;
			}
			array[parentIndex] = array[childIndex];
			parentIndex = childIndex;
			childIndex = 2 * childIndex + 1;
		}
		array[parentIndex] = temp;
	}
	
	public static void buildHeap(int[] array) {
		for (int i = array.length / 2; i >= 0; --i) {
			downAdjust(array, i, array.length - 1);
		}
	}
	
	public static void insert(int[] array, int value) {
		int[] newArr = new int[array.length + 1];
		System.arraycopy(array, 0, newArr, 0, array.length);// Arrays.copyOf(array, array.length);
		newArr[array.length] = value;
		upAdjust(newArr);
		System.out.println(Arrays.toString(newArr));
	}
	
	public static void remove(int[] array, int index) {
		if (index > array.length -1 || index < 0) {
			return;
		}
		int[] newArray = new int[array.length - 1];
		array[index] = array[array.length - 1];
		System.arraycopy(array, 0, newArray, 0, array.length - 1);
		downAdjust(newArray, 0, newArray.length - 1);
		System.out.println(Arrays.toString(newArray));
	}
	
	public static void heapSort(int[] array) {
		for (int i = (array.length - 2) / 2; i >= 0; --i) {
			downAdjust(array, i, array.length);
		}
		System.out.println(Arrays.toString(array));
		for (int i = array.length - 1; i > 0; --i) {
			System.out.print(array[0] + " ");
			int temp = array[i];
			array[i] = array[0];
			array[0] = temp;
			downAdjust(array, 0, i);
		}
	}
	
	public static void main(String[] args) {
		int[] array = new int[] {1, 3, 2, 6, 5, 7, 8, 9, 10, 0};
		upAdjust(array);
		System.out.println(Arrays.toString(array));
		
		downAdjust(array, 0, array.length - 1);
		System.out.println(Arrays.toString(array));
		
		array = new int[] {7, 1, 3, 10, 5, 2, 8, 9, 6};
		buildHeap(array);
		System.out.println(Arrays.toString(array));

		insert(array, 0);
		
		remove(array, 0);
		
		heapSort(array);
	}
	
}
