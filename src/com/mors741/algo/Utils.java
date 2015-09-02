package com.mors741.algo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Utils {
	
	public static int[] loadFromFile(String fileName, int lenght) throws FileNotFoundException{
		Scanner s = new Scanner(new File(fileName));
		int[] ar = new int[lenght];
		for (int i = 0; i < lenght; i++)
			ar[i] = s.nextInt();
		return ar;
	}
	
	public static long[] loadLongsFromFile(String fileName, int lenght) throws FileNotFoundException{
		Scanner s = new Scanner(new File(fileName));
		long[] ar = new long[lenght];
		for (int i = 0; i < lenght; i++)
			ar[i] = s.nextLong();
		return ar;
	}

}
