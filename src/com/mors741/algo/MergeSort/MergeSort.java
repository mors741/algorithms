package com.mors741.algo.MergeSort;

public class MergeSort {
	private static String arrToSting(int[] ar){
		StringBuilder sb = new StringBuilder(31);
		sb.append("[");
		for (int i : ar){
			sb.append(i + " ");
		}
		sb.append("]");
		return sb.toString();
	}
	
	public static void mergeSort(int[] ar){
		if (ar.length <= 1){
			return;
		}
		int i = 0, j = 0, k = 0;
		int[] left = new int[ar.length/2];
		int[] right = new int[ar.length - ar.length/2];
		while (k < ar.length/2){
			left[i++] = ar[k++];
		}
		while (k < ar.length){
			right[j++] = ar[k++];
		}
		System.out.println(arrToSting(ar) + "->" + arrToSting(left)
				+ " + " + arrToSting(right));
		mergeSort(left);
		mergeSort(right);
		i = j = k = 0;
		while (i < left.length && j < right.length){
			if (left[i]<right[j]){
				ar[k++] = left[i++];
			} else {
				ar[k++] = right[j++];
			}
		}
		if (i == left.length){
			while (j < right.length){
				ar[k++] = right[j++];
			}
		} else if (j == right.length){
			while (i < left.length){
				ar[k++] = left[i++];
			}
		}
		System.out.println("   " + arrToSting(left)
		+ " + " + arrToSting(right)+ "->" + arrToSting(ar));
	}
}
