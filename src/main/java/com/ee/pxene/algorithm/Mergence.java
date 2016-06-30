package com.ee.pxene.algorithm;

import java.util.Arrays;
import java.util.Random;

public class Mergence<T extends Comparable<T>> extends Sorting<T> {
	
	private T[] aux;

	/*
	 * 归并算法
	 */
	private void merge(T[] a, int lo, int mid, int hi) {
		// a[lo..mid]和a[mid+1..hi]都是有序的
		int i = lo, j = mid + 1;
		for (int k=lo; k<=hi; k++) {
			aux[k] = a[k];
		}
		for (int k=lo; k<=hi; k++) {
			if (i>mid) a[k] = aux[j++];
			else if (j>hi) a[k] = aux[i++];
			else if (less(aux[i], aux[j])) a[k] = aux[i++];
			else a[k] = aux[j++];
		}
	}
	
	private void sort(T[] a, int lo, int hi) {
		if (lo >= hi) return; 
		int mid = lo + (hi - lo)/2;
		sort(a, lo, mid);
		sort(a, mid+1, hi);
		merge(a, lo, mid, hi);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public void sort(T[] a) {
		aux = (T[])new Comparable<?>[a.length];
		sort(a, 0, a.length-1);
	}

	public static void main(String[] args) {
		Random random = new Random();
		Integer[] a = new Integer[100];
		for (int i=0; i<100; i++) {
			a[i] = random.nextInt(1000);
		}
		System.out.println(Arrays.toString(a));
		Mergence<Integer> mergence = new Mergence<Integer>();
		mergence.sort(a);
		System.out.println(Arrays.toString(a));
	}

}
