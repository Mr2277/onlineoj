package com.huawei.test;

import java.util.ArrayList;
import java.util.List;

public class Test7 {

    public int delArray(int[] nums) {
        List<Integer> list = new ArrayList<>();
        List<List<Integer>> lists = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (list.isEmpty()) {
                list.add(nums[i]);
            } else {
                if (nums[i] >= nums[i - 1]) {
                    list.add(nums[i]);
                } else {
                    List<Integer> copy = new ArrayList<>(list);
                    lists.add(copy);
                    list.clear();
                }
            }
        }
        List<Integer> copy = new ArrayList<>(list);
        lists.add(copy);
        list.clear();
        if (lists.size() == 2) {
            List<Integer> left = lists.get(0);
            List<Integer> right = lists.get(1);
            if (left.get(0) > right.get(right.size() - 1)) {
                int val = Integer.max(left.size(), right.size());
                return nums.length - val - Integer.min(left.size(), right.size());
            } else {
                for (int i = 0; i < right.size(); i++) {
                    for (int j = left.size() - 1; j >= 0; j--) {
                        if (left.get(j) <= right.get(j)) {
                            int leftSize = j - 0 + 1;
                            int rightSize = right.size() - i;
                            int sum = leftSize + rightSize;
                        }
                    }
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        //int[] nums = new int[] {1, 2, 3, 10, 4, 2, 3, 5};
        int[] nums = new int[] {2, 7, 8, 9, 4 ,3, 1, 2};
        Test7 test7 = new Test7();
        test7.delArray(nums);
    }
}
