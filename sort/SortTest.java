package learn;

import java.util.Arrays;

public class SortTest {
	public static void main(String[] args) {
		// int [] test = {4,7,3,6,2,9,0,1,5,8};
		int[] test = { 4, 5, 0, 9, 1, 3, 6, 2, 7, 1, 2, 3 };
		// launch different sort methods
		// bubbleSort(test);
		bubbleSort2(test);
		// insertionSort(test);
		// selectionSort(test);
		// mergeSort(test);
		// quickSort(test,0,test.length-1);
		System.out.println(Arrays.toString(test));
	}

	public static void bubbleSort(int[] arr) {
		if (arr == null)
			return;
		int n = arr.length;
		for (int i = 0; i < n; i++) {
			boolean sorted = true;
			for (int j = 1; j < n - i; j++) {
				if (arr[j - 1] > arr[j]) {
					int temp = arr[j];
					arr[j] = arr[j - 1];
					arr[j - 1] = temp;
					sorted = false;
				}
			}
			if (sorted)
				break;
		}
	}

	public static void bubbleSort2(int[] a) {
		if (a == null)
			return;
		int n = a.length;
		int index = n;
		for (int i = 0; i < n - 1; i++) {
			int j;
			boolean sorted = true;
			for (j = 1; j < index; j++) {
				if (a[j] < a[j - 1]) {
					int t = a[j];
					a[j] = a[j - 1];
					a[j - 1] = t;
					sorted = false;
				}

			}
			if (sorted)
				return;
			index = j;

		}

	}

	public static void insertionSort(int[] a) {
		if (a == null)
			return;
		int n = a.length;
		if (n < 1)
			return;
		for (int i = 1; i < n; i++) {
			int t = a[i];
			int j;
			for (j = i; j > 0; j--) {
				if (t < a[j - 1]) {
					a[j] = a[j - 1];

				} else {
					break;
				}
			}
			a[j] = t;
		}
	}

	public static void insertionSort2(int[] a) {
		if (a.length < 2)
			return;
		for (int i = 1; i < a.length; i++) {
			for (int j = i; j > 0; j--) {
				if (a[j] < a[j - 1]) {
					int temp = a[j];
					a[j] = a[j - 1];
					a[j - 1] = temp;
				} else
					break;
			}
		}
	}

	public static void selectionSort(int[] a) {
		if (a == null)
			return;
		int n = a.length;
		for (int i = 0; i < n; i++) {
			int min = a[i];
			int minIndex = i;
			int j;
			for (j = i; j < n; j++) {
				if (a[j] < min) {
					min = a[j];
					minIndex = j;
				}
			}
			a[minIndex] = a[i];
			a[i] = min;
		}
	}

	public static void mergeSort(int[] a) {
		mergeSort(a, 0, a.length - 1);
	}

	public static void mergeSort(int[] a, int begin, int end) {
		if (begin < end) {
			int mid = (begin + end) / 2;
			mergeSort(a, begin, mid);
			mergeSort(a, mid + 1, end);
			merge(a, begin, mid, end);
		}
	}

	public static /* int[] */ void merge(int[] a, int left, int lfend, int rtend) {
		// int len1 = lfend - left +1;
		// int len2 = rtend - lfend;
		// int[] m = new int[len1 + len2];
		int[] m = new int[rtend - left + 1];
		int p = left;
		int q = lfend + 1;
		int r = 0;
		while (p <= lfend && q <= rtend) {
			if (a[p] <= a[q]) {
				m[r] = a[p];
				p++;
			} else {
				m[r] = a[q];
				q++;
			}
			r++;
		}
		if (p > lfend) {
			for (; r < m.length; r++, q++)
				m[r] = a[q];
		}
		if (q > rtend) {
			for (; r < m.length; r++, p++)
				m[r] = a[p];
		}
		// System.out.print("m = ");
		// System.out.println(Arrays.toString(m));
		for (int i = 0; i < rtend - left + 1; i++) {
			a[left + i] = m[i];
		}
		// return m;
	}

	public static void quickSort(int[] a, int begin, int end) {
		if (begin >= end)
			return;
		int pivotIndex = partition(a, begin, end);
		quickSort(a, begin, pivotIndex - 1);
		quickSort(a, pivotIndex + 1, end);

	}

	public static int partition(int[] a, int begin, int end) {
		int pivot = a[begin];
		while (begin < end) {
			while (end > begin && a[end] >= pivot) {
				end--;
			}
			a[begin] = a[end];
			while (begin < end && a[begin] <= pivot) {
				begin++;
			}
			a[end] = a[begin];

		}
		a[end] = pivot;
		return end;
	}
}
