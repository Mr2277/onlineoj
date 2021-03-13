package com.huawei.kexin.array;

public class SingleNum {

    public int findMin(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (i == 0 && nums[i] != nums[i + 1]) {
                return nums[i];
            }
            if (i == nums.length - 1 && nums[i] != nums[i - 1]) {
                return nums[i - 1];
            }
            if (i > 0 && i < nums.length - 1 && nums[i] != nums[i - 1] && nums[i] != nums[i + 1]) {
                return nums[i];
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {2, 2, 3, 4, 4};
        SingleNum singleNum = new SingleNum();
        System.out.println(singleNum.findMin(nums));
    }
}
