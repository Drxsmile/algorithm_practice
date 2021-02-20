package com.snx;

/*
* Give A1,A2,.....,An n different matrixs

Find minimum of multiplication it needs to get the result

input: An array P with n+1 numbers

A1 = p0*p1, An = Pn-1*Pn
* */

public class Main {

    public static void main(String[] args) {
        int[] p = new int[]{3, 6, 7, 2, 1};
        int res = minMulti(p);
        int res1 = MatrixChain(p);
        System.out.println(res);
        System.out.println(res == res1);
    }

    private static int minMulti(int[] p) {
        int n = p.length - 1;
        if(n == 0 || n == -1) return 0;
        int[][] dp = new int[n][n];
        for (int len = 2; len <= n; len++) {
            for (int i = 1; i <= n - len + 1; i++) {
                int j = i + len - 1;
                dp[i - 1][j - 1] = p[i - 1] * p[i] * p[j] + dp[i][j - 1]; // k = i
                for (int k = i + 1; k < j; k++) {
                    int t = dp[i - 1][k - 1] + dp[k][j - 1] + p[i - 1] * p[k] * p[j];
                    dp[i - 1][j - 1] = Math.min(t, dp[i - 1][j - 1]);
                }
            }
        }
        printDp(dp);
        return dp[0][n - 1];
    }

    public static int MatrixChain(int[] p)
    {
        int n = p.length;
        n --;//矩阵数量
        int[][] m = new int[n][n];
        for(int i = 0; i < n; i++)
            m[i][i] = 0;
        for(int r = 2; r <= n; r++)//len of chain
        {   //j - i + 1 = r
            for(int i = 0; i < n - r + 1; i ++)
            {
                int j = i + r - 1;
                // i到j之间取在k处截取中的最小值
                m[i][j] = m[i + 1][j]  + p[i] * p[i+1] * p[j + 1];
                for(int k = i + 1; k < j; k++)
                {
                    int t = m[i][k] + m[k + 1][j] + p[i] * p[k+1] * p[j+1];
                    if( t < m[i][j])
                        m[i][j] = t;
                }
            }
        }
        printDp(m);
        return m[0][n-1];
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
}
