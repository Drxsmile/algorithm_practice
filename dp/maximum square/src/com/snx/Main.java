package com.snx;

public class Main{
    public static void main(String[] args){
        Solution s = new Solution();
        char[][] matrix = {
                {'1','0','1','0','0'},
                {'1','0','1','1','1'},
                {'1','1','1','1','1'},
                {'1','0','0','1','0'}
        };
        char[][] m = {
                {'0'},{'1'}
        };
        int res = s.maximalSquare(m);
//        int res = s.maximalSquare(matrix);
        System.out.println(res);
    }

}
class Solution {
    public int maximalSquare1(char[][] matrix) {
        int row = matrix.length;
        if(row == 0) return 0;
        int col = matrix[0].length;
        if(col == 0) return 0;
        int[][] dp = new int[row][col];
        int max = 0;
        for(int i = 0; i < row; i++){
            if(matrix[i][0] == '1') dp[i][0] = 1;
        }
        for(int i = 1; i < col; i++){
            if(matrix[0][i] == '1') dp[0][i] = 1;
        }
        for(int i = 1; i < row; i++){
            for(int j = 1; j < col; j++){
                if(matrix[i][j] == 0) continue;
                dp[i][j] = 1 + Math.min(dp[i - 1][j], Math.min(dp[i - 1][j - 1], dp[i][j - 1]));
                if(dp[i][j] > max) max = dp[i][j];
            }
        }
        printDp(dp);
        return max * max;
    }
    public int maximalSquare(char[][] matrix) {
        int row = matrix.length;
        if(row == 0) return 0;
        int col = matrix[0].length;
        if(col == 0) return 0;
        char max = '0';
        for(int i = 0; i < row; i++){
            if(matrix[i][0] == '1'){
                max = '1';
                break;
            }

        }
        if(max == '0'){
            for(int i = 1; i < col; i++){
                if(matrix[0][i] == '1'){
                    max = '1';
                    break;
                }
            }
        }
        for(int i = 1; i < row; i++){
            for(int j = 1; j < col; j++){
                if(matrix[i][j] == '0') continue;
                // if(max < '1') max = '1';
                char t = matrix[i - 1][j];
                if(matrix[i - 1][j - 1] < t) t = matrix[i - 1][j - 1];
                if(matrix[i][j - 1] < t) t = matrix[i][j - 1];
                matrix[i][j] = (char)(1 + t);
                if(matrix[i][j] > max) max = matrix[i][j];
            }
        }
        printDp(matrix);
        int res = max - '0';
        return res * res;
    }
    public static void printDp(int[][] dp){
        int row = dp.length;
        int col = dp[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(dp[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }
    }
    public static void printDp(char[][] dp){
        int row = dp.length;
        int col = dp[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(dp[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}