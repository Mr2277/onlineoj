package com.huawei.leetcode.leetcode1_1000.leetcode401_500.leetcode491_500;

public class LeetCode494 {
    public int findTargetSumWays(int[] nums, int S) {
        return find(nums,0,S);
    }
    public int find(int[] nums, int index, int S){
        if(index==nums.length){
            if(S==0){
                return 1;
            }else{
                return 0;
            }
        }
        return find(nums, index+1, S+nums[index])+
                find(nums, index+1, S-nums[index]);
    }
    /*
    public int findTargetSumWays(int[] nums, int S) {
        Queue<Integer>queue = new LinkedList<>();
        queue.add(nums[0]);
        queue.add(0 - nums[0]);
        int index = 1;
        while (!queue.isEmpty()) {
            if (index == nums.length) {
                break;
            }
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Integer curSum = queue.poll();
                int sum = curSum;
                sum += nums[index];
                queue.add(sum);
                sum = curSum;
                sum += (0 - nums[index]);
                queue.add(sum);
            }
            index++;
            if (index == nums.length) {
                break;
            }
        }
        //System.out.println(queue.size());
        List<Integer> list = queue.stream().filter(element -> element == S).collect(Collectors.toList());
        return list.size();
    }
    */
}
