package com.ee.interview;

public class Demo3 {

    public static void main(String[] args) {
        int[] a = {5, 6, 1, 0, 2, 4, 3};
        System.out.println(duplicate(a));
    }

    public static boolean duplicate(int[] nums) {
        boolean existed = false;
        loop1:
        for (int i=0; i<nums.length; i++) {
            loop2:
            while (i != nums[i]) {
                int n = nums[i];
                int nn = nums[n];
                if (n == nn) {
                    existed = true;
                    break loop1;
                } else {
                    nums[n] = n;
                    nums[i] = nn;
                }
            }
        }

        return existed;
    }

}
