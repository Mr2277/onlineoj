package com.huawei.leetcode.leetcode1_1000.leetcode901_1000.leetcode971_980;

import java.util.Arrays;

public class LeetCode977 {

    public int[] sortedSquares(int[] nums) {
        nums = Arrays.stream(nums).boxed().map(integer -> Math.abs(integer) * Math.abs(integer)).sorted().mapToInt(Integer::intValue).toArray();
        return nums;
    }

    /*
    public void change(int[] nums) {
        nums[0] = 9999;
    }
    */

    public static void main(String[] args) {
        int[] nums = new int[] {-4, -1, 0, 3, 10};
        //nums = new LeetCode977().sortedSquares(nums);
        LeetCode977 leetCode977 = new LeetCode977();
        //leetCode977.change(nums);
        nums = leetCode977.sortedSquares(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}
