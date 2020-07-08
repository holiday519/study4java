package com.ee.algorithm.sort;

public abstract class Sorting<T extends Comparable<T>> {
	
	protected boolean less(T v, T w) {
		return v.compareTo(w) < 0;
	}
	
	protected void exch(T[] a, int i, int j) {
		T t = a[i];
		a[i] = a[j];
		a[j] = t;
	}
	
	public abstract void sort(T[] a);  

}
