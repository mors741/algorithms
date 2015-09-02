package com.mors741.algo.Karatsuba;

public class KaratsubaInt {
	
//	private static int getNumberOfDigits(int x) {
//		int num = 0;
//		while (x % 10 > 0){
//			x = x / 10;
//			num ++;
//		}
//		return num;
//	}
	
	private static int getNumberOfDigits(int n) {
		return (int)(Math.log10(n)+1);
	}
	
	public static int multiply(int x, int y){
		// Base case
		if (x<10 || y<10){
			return x * y;
		}
		// General case
		int pow2 = Math.max(getNumberOfDigits(x),getNumberOfDigits(y))/2;
		int a = x / (int) Math.pow(10, pow2);
		int b = x % (int) Math.pow(10, pow2);
		int c = y / (int) Math.pow(10, pow2);
		int d = y % (int) Math.pow(10, pow2);
		int ac = multiply(a,c);
		int bd = multiply(b,d);
		int abcd = multiply(a+b,c+d);		
		
		return ac*(int)Math.pow(10, 2*pow2)
				+ (abcd-ac-bd)*(int)Math.pow(10, pow2)
				+ bd;
	}

}
