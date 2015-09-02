package com.mors741.algo.QuickSort;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class QS {
	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	public static int qSort(int[] arr) {
		return sort1(arr, 0, arr.length);
	}

	private static int sort1(int[] arr, int l, int r) {
		if (r - l <= 1) {
			return 0;
		}
		int p = arr[l + 0];
		int i = l + 1;
		for (int j = l + 1; j < r; j++) {
			if (arr[j] < p) {
				swap(arr, i, j);
				i++;
			}
		}
		swap(arr, l, i - 1);
		return r-l-1 + sort1(arr, l, i-1) + sort1(arr, i, r);
	}
	
	private static int sort2(int[] arr, int l, int r) {
		if (r - l <= 1) {
			return 0;
		}
		swap(arr, l, r-1);
		int p = arr[l];
		int i = l + 1;
		for (int j = l + 1; j < r; j++) {
			if (arr[j] < p) {
				swap(arr, i, j);
				i++;
			}
		}
		swap(arr, l, i - 1);
		return r-l-1 + sort2(arr, l, i-1) + sort2(arr, i, r);
	}
	
	private static int sort3(int[] arr, int l, int r) {
		if (r - l <= 1) {
			return 0;
		}
		swap(arr, l, medianIndex(arr, l, r));
		int p = arr[l];
		int i = l + 1;
		for (int j = l + 1; j < r; j++) {
			if (arr[j] < p) {
				swap(arr, i, j);
				i++;
			}
		}
		swap(arr, l, i - 1);
		return r-l-1 + sort3(arr, l, i-1) + sort3(arr, i, r);
	}
	
	private static int medianIndex(int arr[], int l, int r){
		
		int m = l+(r-l-1)/2;
		if (arr[l] > arr[m]){
			if (arr[m] > arr[r-1]){
				return m;
			} else {
				if (arr[l] > arr[r-1]){
					return r-1;
				} else {
					return l;
				}
			}
		} else {
			if (arr[m] < arr[r-1]){
				return m;
			} else {
				if (arr[l] > arr[r-1]){
					return l;
				} else {
					return r-1;
				}
			}
		}
	}

	public static void main(String[] args) throws FileNotFoundException {
		try (Scanner scanner = new Scanner(new File("resources/QuickSort.txt"))) {
			int[] arr = new int[10000];
			int i = 0;
			while (scanner.hasNextInt()) {
				arr[i++] = scanner.nextInt();
			}
//			int[] arr = new int[]{8, 2, 4, 5, 7, 1};
		
			int a = qSort(arr);
			for (int el : arr) {
				System.out.print(el + " ");
				if (el % 30 == 0) {
					System.out.println();
				}
			}
			System.out.println();
			System.out.println(a);
		}
	}

}
