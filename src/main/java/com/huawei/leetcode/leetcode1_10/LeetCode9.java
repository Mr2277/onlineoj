package com.huawei.leetcode.leetcode1_10;

import java.util.Scanner;

public class LeetCode9 {
    public static boolean isPalindrome(int x) {
        if(x < 0)
            return false;
        int cur = 0;
        int num = x;
        while(num != 0) {
            cur = cur * 10 + num % 10;
            num /= 10;
        }
        return cur == x;


    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int num = scanner.nextInt();
            isPalindrome(num);
        }
        

    }
}
