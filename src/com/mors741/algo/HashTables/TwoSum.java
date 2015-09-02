package com.mors741.algo.HashTables;

import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Set;

import com.mors741.algo.Utils;
import com.mors741.algo.Heaps.MedianMaintanence;

public class TwoSum {
	public static int compute(long[] input) {
		Set<Long> inH = new HashSet<Long>(1000000);
		int count = 0;
		for (long i : input){
			inH.add(i);
		}
		for (int t = -10000; t < 10001; t++){
			for (Long x : inH){
				if (inH.contains(t-x) && x*2 != t){
					count++;
					break;
				}
			}
			if (t % 100 == 0) {
				System.out.println("t: "+ t + ", count: "+ count);
			}
		}
		return count;
	}
	
	public static void main(String[] args) throws FileNotFoundException{
		int res = TwoSum.compute(Utils.loadLongsFromFile("resources/algo1-programming_prob-2sum.txt", 1000000));
		System.out.println(res);
	}
}
