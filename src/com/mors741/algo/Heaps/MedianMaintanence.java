package com.mors741.algo.Heaps;

import java.io.FileNotFoundException;
import java.util.PriorityQueue;

import com.mors741.algo.Utils;

public class MedianMaintanence {
	private PriorityQueue<Integer> lowH;
	private PriorityQueue<Integer> highH;
	
	public MedianMaintanence(){
		lowH = new PriorityQueue<Integer>(10000, (a, b) -> (b - a));
		highH = new PriorityQueue<Integer>(10000);
	}
	public void add(int i) {
		if (lowH.isEmpty()) {
			lowH.add(i);
			//System.out.println("i " + i + ", l " + lowH + ", h " + highH + " >>> med " + getMedian());
			return;
		}
		if (i > lowH.peek()) {
			highH.add(i);
		} else {
			lowH.add(i);
		}

		if (lowH.size() - highH.size() > 1){
			highH.add(lowH.poll());
		} else if (lowH.size() - highH.size() < -1) {
			lowH.add(highH.poll());
		}
		//System.out.println("i " + i + ", l " + lowH + ", h " + highH + " >>> med " + getMedian());
	}
	public int getMedian() {
		if (lowH.size() >= highH.size()) {
			return lowH.peek();
		} else {
			return highH.peek();
		}
	}
	
	public static void main(String[] args) throws FileNotFoundException{
//		int[] ar = loadFromFile("/home/mors/Downloads/IntegerArray.txt");
//		long res = MergeInvCount.mergeInvCount(ar);
//		for (int i = 0; i < ar.length; i++){
//			System.out.print(ar[i] + " ");
//			if (i % 30 == 29){
//				System.out.println();
//			}
//		}
//		System.out.println();
//		System.out.println(res);
		//int res = TwoSum.compute(new long[] {1, 2, 98, 50});
		//PriorityQueue<Integer> lowH = new PriorityQueue<Integer>((a, b) -> (b - a));
		int medSum = 0;
		MedianMaintanence m = new MedianMaintanence();
		for (int i : Utils.loadFromFile("resources/Median.txt", 10000)) {
			m.add(i);
			medSum += m.getMedian();
		}
		System.out.println(medSum);
	}
}
