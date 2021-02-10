package com.huawei.leetcode.leetcode1_1000.leetcoe1_100.leetcode71_80;

public class LeetCode79 {

    public boolean strExist = false;

    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (word.length() == 1) {
                        strExist = true;
                    } else {
                        boolean[][] flag = new boolean[board.length][board[0].length];
                        dfs(board, flag, word, i, j, 0);
                    }
                }
            }
        }
        return strExist;
    }

    public int[][] dir = new int[][] {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};

    public void dfs(char[][] board, boolean[][] flag, String word, int x, int y, int index) {
        if (index == word.length() - 1 && board[x][y] == word.charAt(index)) {
            strExist = true;
            return;
        }
        if (word.charAt(index) != board[x][y]) {
            return;
        }

        flag[x][y] = true;
        for (int[] d : dir) {
            int nextX = x + d[0];
            int nextY = y + d[1];
            if (nextX >= 0 && nextX < board.length && nextY >= 0 && nextY < board[0].length && !flag[nextX][nextY]) {
                if (!strExist) {
                    dfs(board, flag, word, nextX, nextY, index + 1);
                }
            }
        }
        flag[x][y] = false;
    }

    public static void main(String[] args) {
        char[][] board = new char[][] {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'E', 'S'},
                {'A', 'D', 'E', 'E'}

        };
        String word = "ABCESEEEFS";
        System.out.println(new LeetCode79().exist(board, word));
    }
}
