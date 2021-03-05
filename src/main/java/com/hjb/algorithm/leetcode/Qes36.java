package com.hjb.algorithm.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * ClassName: Qes36
 * Description:
 * Created by haojingbin on 2021/3/4 9:52
 *
 * @author haojingbin
 */
public class Qes36 {

    public static boolean isValidSudoku1(char[][] board) {
        Map<String, Set<String>> map = new HashMap<>();
        for (int i = 0; i < board.length; i++) {
            Set<String> li = map.get("l" + i);
            if (null == li) {
                li = new HashSet<>();
            }
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '.') {
                    continue;
                }
                if (!li.add(String.valueOf(board[i][j]))) {
                    return false;
                }
                map.put("l" + i, li);
                Set<String> ci = map.get("c" + j);
                if (null == ci) {
                    ci = new HashSet<>();
                }
                if (!ci.add(String.valueOf(board[i][j]))) {
                    return false;
                }
                map.put("c" + j, ci);
                Set<String> tij = map.get("t" + i / 3 + j / 3);
                if (null == tij) {
                    tij = new HashSet<>();
                }
                if (!tij.add(String.valueOf(board[i][j]))) {
                    return false;
                }
                map.put("t" + i / 3 + j / 3, tij);
            }
        }
        return true;
    }

    public static boolean isValidSudoku2(char[][] board) {
        HashSet[] row = new HashSet[9];
        HashSet[] column = new HashSet[9];
        HashSet[] box = new HashSet[9];
        for (int i = 0; i < 9; i++) {
            row[i] = new HashSet();
            column[i] = new HashSet();
            box[i] = new HashSet();
        }
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    continue;
                }
                if(!row[i].add(board[i][j]) || !column[j].add(board[i][j]) || !box[(i/3)*3 + j/3].add(board[i][j])){
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        char[][] board = new char[][]{{'8', '3', '.', '.', '7', '.', '.', '.', '.'}, {'6', '.', '.', '1', '9', '5', '.', '.', '.'}, {'.', '9', '8', '.', '.', '.', '.', '6', '.'}, {'8', '.', '.', '.', '6', '.', '.', '.', '3'}, {'4', '.', '.', '8', '.', '3', '.', '.', '1'}, {'7', '.', '.', '.', '2', '.', '.', '.', '6'}, {'.', '6', '.', '.', '.', '.', '2', '8', '.'}, {'.', '.', '.', '4', '1', '9', '.', '.', '5'}, {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
        System.out.println(isValidSudoku1(board));
        System.out.println(isValidSudoku2(board));
    }
}
