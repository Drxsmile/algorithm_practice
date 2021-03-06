/**
 * a knapsack can hold w pounds of items every item has its weight and value how
 * to get the most value?
 */
public class App {
    public static void main(String[] args) throws Exception {
        int[] w = { 1, 3, 4, 5 };
        int[] v = { 3, 8, 4, 7 };
        int res = knapsack(7, w, v);
        System.out.println(res);
        System.out.println("Hello, World!");
    }
    public static int knapsack(int cap, int[] weights, int[] values){
        int index = weights.length;
        if(index == 0 || index != values.length || cap == 0) return -1;
        int[] dp = new int[cap + 1];
        for (int i = 0; i < index; i++) {
            for (int w = cap; w >= weights[i]; w--) {
                int m = w - weights[i];
                dp[w] = Math.max(dp[w], dp[m] + values[i]);
            }
        }
        return dp[cap];
    }
    public static int knapsack1(int capacity, int[] weights, int[] values) {
        int length = weights.length;
        if (capacity == 0 || length == 0)
            return 0;
        int[][] w = new int[length + 1][capacity + 1];
        // int默认值就是0，所以不需要额外填充
        for (int i = 1; i <= length; i++) {
            int index = i - 1;
            for (int j = 1; j <= capacity; j++) {
                if (j < weights[index]) {
                    w[i][j] = w[i - 1][j];
                } else if (w[i - 1][j - weights[index]] + values[index] > w[i - 1][j]) {
                    w[i][j] = w[i - 1][j - weights[index]] + values[index];
                } else {
                    w[i][j] = w[i - 1][j];
                }
            }
        }
        printDp(w);
        return w[length][capacity];
    }

    public static int knapsack2(int cap, int[] weights, int[] values) {
        int index = weights.length;
        if (cap == 0 || index == 0 || values.length != index)
            return 0;
        int[][] dp = new int[index + 1][cap + 1];
        for (int i = 0; i < index; i++) {
            dp[i][0] = 0;
        }
        for (int i = 1; i <= cap; i++) {
            dp[0][i] = 0;
        }
        for (int i = 1; i <= index; i++) {
            for (int j = 1; j <= cap; j++) {
                dp[i][j] = dp[i - 1][j];
                int reserve = j - weights[i - 1];
                if (reserve >= 0) {
                    dp[i][j] = Math.max(dp[i - 1][reserve] + values[i - 1], dp[i][j]);
                }
            }
        }
        printDp(dp);
        return dp[index][cap];
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

