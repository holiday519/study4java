package com.ee.pxene.algorithm;

public class Insertion<T extends Comparable<T>> extends Sorting<T> {

	@Override
	public void sort(T[] a) {
		int N = a.length;
		for (int i=1; i<N; i++) {
			for (int j=i; j>0 && less(a[j], a[j-1]); j--) {
				exch(a, j, j-1);
			}
		}
	}

}
