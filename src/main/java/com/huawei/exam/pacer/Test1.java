package com.huawei.exam.pacer;

import java.util.Arrays;

public class Test1 {

    public int solution(int[] A) {
        // write your code in Java SE 8
        A = Arrays.stream(A).distinct().sorted().toArray();
        int target = 1;
        for (int i = 0; i < A.length; i++) {
            if (A[i] == target) {
                target++;
            } else if (A[i] > target){
                break;
            }
        }
        return target;
    }

    public static void main(String[] args) {
        int[] A = new int[] {-1, -22, -43};
        System.out.println(new Test1().solution(A));
    }
}
