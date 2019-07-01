package com.hackerrank;

public class sort {
	public static void main(String[] args) {
		int[] a = new int[] {1,2,100,4,5};
		for (int i = 0; i < a.length; i++) {
			for (int j = i + 1; j < a.length; j++) {
				if (a[i] < a[j]) {
					int temp = a[i];
					a[i] = a[j];
					a[j] = temp;
				}
			}
		}
		
		for (int number : a) {
			System.out.println(number);
		}
	}
}
