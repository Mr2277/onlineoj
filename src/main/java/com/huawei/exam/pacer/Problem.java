package com.huawei.exam.pacer;

import java.util.HashSet;
import java.util.Set;

public class Problem {

    public int solution(int[] A) {
        // write your code in Java SE 8
        int res = 0;
        for (int i = 0; i < A.length - 1; i++) {
            int start = i;
            int end = start + 1;
            int count = 0;
            Set<Integer> indexSet = new HashSet<>();
            while (start < A.length) {
                int sum = A[start] + A[end];
                if ((sum & 1) != 1) {
                    if (!indexSet.contains(start) && !indexSet.contains(end)) {
                        indexSet.add(start);
                        indexSet.add(end);
                        count++;
                        start += 2;
                        end = start + 1;


                    }
                } else {
                    start++;
                    end = start + 1;
                }
                if (end >= A.length) {
                    end = end - A.length;
                }
            }
            res = count > res ? count : res;
        }
        return res;
    }


    public static void main(String[] args) {
        int[] A = new int[] {14, 21, 16, 35, 22};
        System.out.println(new Problem().solution(A));
    }
}
