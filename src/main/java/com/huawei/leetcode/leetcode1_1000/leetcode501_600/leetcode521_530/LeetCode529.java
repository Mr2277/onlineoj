package com.huawei.leetcode.leetcode1_1000.leetcode501_600.leetcode521_530;

import java.util.Scanner;

public class LeetCode529 {

    public static char[][] updateBoard(char[][] board, int[] click) {
        return null;
    }

    public static int DFS(char[][] board, int x, int y) {
        int rows = board.length;
        int cols = board[0].length;
        if (x < 0 || x >= rows || y < 0 || y >= cols || board[x][y] != 'E') {
            return 0;
        }
        if (board[x][y] == 'M') {
            return 1;
        }
        board[x][y] = 'B';
        int up = DFS(board, x - 1, y);
        int rightUp = DFS(board, x - 1, y + 1);
        int right = DFS(board, x, y + 1);
        int rightDown = DFS(board, x + 1, y + 1);
        int down = DFS(board, x + 1, y);
        int leftDown = DFS(board, x + 1, y - 1);
        int left = DFS(board, x, y - 1);
        int leftUp = DFS(board, x - 1, y - 1);
        int sum = up + rightUp + right + rightDown + down + left + leftDown + leftUp;
        char cur = sum == 0 ? 'B' : (char) ('0' + sum);
        board[x][y] = cur;
        return sum;
    }
    public static void main(String[] args) {
        char[][] board = new char[][] {
                {'E', 'E', 'E', 'E', 'E'},
                {'E', 'E', 'M', 'E', 'E'},
                {'E', 'E', 'E', 'E', 'E'},
                {'E', 'E', 'E', 'E', 'E'}
        };

    }
}
