package com.ee.interview;

public class Demo11 {

    public static void main(String[] args) {
        int[] nums = {14,16,23,45,66,3,8};
        System.out.println(min(nums, 0 , nums.length-1));
    }

    public static int min(int[] nums, int l, int h) {
        if (l == h) {
            return nums[l];
        }
        if (l == h - 1) {
            return nums[l] > nums[h] ? nums[h] : nums[l];
        }

        int m = l + (h - l) / 2;
        if (nums[m] > nums[l]) {
            return min(nums, m + 1, h);
        } else {
            return min(nums, l, m);
        }
    }
}
