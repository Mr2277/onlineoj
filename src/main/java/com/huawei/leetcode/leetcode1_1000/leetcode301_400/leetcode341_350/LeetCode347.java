package com.huawei.leetcode.leetcode1_1000.leetcode301_400.leetcode341_350;

import java.util.*;
import java.util.stream.Collectors;

public class LeetCode347 {

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], 1);
            } else {
                Integer value = map.get(nums[i]);
                value++;
                map.put(nums[i], value);
            }
        }
        Map<Integer, Integer> result1 = map.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));
        int count = 0;
        int[] array = new int[k];
        for (Map.Entry entry : result1.entrySet()) {
            if (count == k) {
                break;
            }
            array[count++] = (Integer)entry.getKey();
        }
        return array;

    }

    public static void main(String[] args) {
        int[] nums = new int[] {4,1,-1,2,-1,2,3};
        int[] array = new LeetCode347().topKFrequent(nums, 2);
        Arrays.stream(array).forEach(x -> System.out.println(x));
    }
}
