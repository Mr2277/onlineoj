package com.huawei.leetcode.leetcode1_1000.leetcode101_200.leetcode121_130;

public class LeetCode130 {

    public static void solve(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if ((i == 0 || i == board.length - 1) && board[i][j] == 'O') {
                    dfsSetA(board, i, j);
                    continue;
                }
                if ((j == 0 || j == board[0].length - 1) && board[i][j] == 'O') {
                    dfsSetA(board, i, j);
                    continue;
                }
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'O') {
                    dfsSetX(board, i, j);
                }
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] = board[i][j] == 'A' ? 'O' : board[i][j];
            }
        }
    }

    public static void dfsSetA(char[][] board, int x, int y) {
        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length || board[x][y] != 'O') {
            return;
        }
        board[x][y] = 'A';
        int[][] dir = new int[][] {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
        for (int[] d : dir) {
            int nextX = x + d[0];
            int nextY = y + d[1];
            dfsSetA(board, nextX, nextY);
        }

    }

    public static void dfsSetX(char[][] board, int x, int y) {
        if (x <= 0 || x >= board.length - 1 || y <= 0 || y >= board[0].length - 1 || board[x][y] != 'O') {
            return;
        }
        board[x][y] = 'X';
        int[][] dir = new int[][] {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
        for (int[] d : dir) {
            int nextX = x + d[0];
            int nextY = y + d[1];
            dfsSetX(board, nextX, nextY);
        }
    }

    public static void main(String[] args) {
        char[][] board = new char[][]{
                {'X', 'X', 'X', 'X'},
                {'X', 'O', 'O', 'X'},
                {'X', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'X'}
        };
        solve(board);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}
