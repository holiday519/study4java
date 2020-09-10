package com.ee.algorithm.sort;

public class MaxPQ<T extends Comparable<T>> extends Sorting<T> {

	private T[] pq;
	// 最后一个元素的位置
	private int N = 0;
	
	public MaxPQ(int maxN) {
		pq = (T[]) new Comparable[maxN + 1];
	}
	
	private void swim(int k) {
		while (k > 1 && less(pq[k/2], pq[k])) {
			exch(pq, k/2, k);
			k = k/2;
		}
	}
	
	public void insert(T v) {
		pq[++N] = v;
		swim(N);
	}
	
	public T delMax() {
		T max = pq[1];
		exch(pq, 1, N--);
		pq[N+1] = null;
		sink(1);
		return max;
	}
	
	private void sink(int k) {
		while (2*k <= N) {
			int j = 2*k;
			// 找出左右节点中大的一个
			if (j < N && less(pq[j], pq[j+1])) j++;
			if (!less(pq[k], pq[j])) break;
			exch(pq, k, j);
			k = j;
		}
	}

	@Override
	public void sort(T[] a) {
		
	}
}
