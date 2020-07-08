package com.ee.algorithm.sort;

import java.util.Arrays;
import java.util.Random;

public class Quick<T extends Comparable<T>> extends Sorting<T> {

	@Override
	public void sort(T[] a) {
		shuffle(a);
		sort(a, 0, a.length-1);
	}
	
	private void shuffle(T[] a) {
		Random random = new Random();
        for (int i=a.length-1; i >= 0; i--) { 
            exch(a, random.nextInt(i+1), i);
        }  
    }  
	
	private void sort(T[] a, int lo, int hi) {
		if (hi <= lo) return;
		int j = partition(a, lo, hi);
		sort(a, lo, j-1);
		sort(a, j+1, hi);
	}
	
	private int partition(T[] a, int lo, int hi) {
		int i = lo, j = hi+1;
		T v = a[lo];
		while (true) {
			while (less(a[++i], v)) if (i == hi) break;
			while (less(v, a[--j])) if (j == lo) break;
			if (i >= j) break;
			exch(a, i, j);
		}
		exch(a, lo, j);
		return j;
	}
	
	public static void main(String[] args) {
		Random random = new Random();
		Integer[] a = new Integer[100];
		for (int i=0; i<100; i++) {
			a[i] = random.nextInt(1000);
		}
		System.out.println(Arrays.toString(a));
		Quick<Integer> quick = new Quick<Integer>();
		quick.sort(a);
		System.out.println(Arrays.toString(a));
	}

}

