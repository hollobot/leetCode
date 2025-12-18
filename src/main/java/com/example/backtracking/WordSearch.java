package com.example.backtracking;

import java.util.ArrayList;
import java.util.List;

public class WordSearch {

    public static void main(String[] args) {

        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        String word = "SEE";
        System.out.println(new WordSearch().exist(board, word));
    }

    List<Character> cur = new ArrayList();

    public boolean exist(char[][] board, String word) {
        int len = word.length();
        int x = 0, y = 0;
        boolean flog = true;
        // 寻找第一个点
        for (int i = 0; i < board.length && flog; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    y = i;
                    x = j;
                    flog = false;
                    break;
                }
            }
        }

        if (flog) {
            return false;
        }

        return dfs(x, y, board, word, 0, len);
    }

    public boolean dfs(int x, int y, char[][] board, String word, int depath, int len) {

        if (depath == len) {
            return true;
        }

        int yLen = board.length;
        int xLen = board[0].length;

        // 校验边界
        if (!(x < xLen && x >= 0 && y < yLen && y >= 0)) {
            return false;
        }

        if (board[y][x] != word.charAt(depath)) {
            return false;
        }

        boolean b1 = dfs(x, y - 1, board, word, depath + 1, len);
        boolean b2 = dfs(x + 1, y, board, word, depath + 1, len);
        boolean b3 = dfs(x, y + 1, board, word, depath + 1, len);
        boolean b4 = dfs(x - 1, y, board, word, depath + 1, len);
        return b1 || b2 || b3 || b4;
    }
}
