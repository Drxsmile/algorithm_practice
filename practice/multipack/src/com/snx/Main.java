package com.snx;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

// 恰好装满
public class Main {

    public static void main(String[] args) {
	// write your code
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int w = sc.nextInt();
        int[] nums = new int[n];
        int[] val = new int[n];
        int[] cost = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
            cost[i] = sc.nextInt();
            val[i] = sc.nextInt();
        }
        //  5 10 3 2 6 2 4 16 5 1 2 1 3 9 6 6 20
        // 2 10 5 2 4 3 3 12
//        System.out.println(maxValue(n, w, nums, val, cost));
        System.out.println(solution1(w, nums, val, cost));
        System.out.println(solution2(w, nums, val, cost));
        System.out.println(solution3(w, nums, val, cost));
    }
    private static int maxValue(int N, int C, int[] s, int[] w, int[] v) {
        int[] dp = new int[C + 1];
        for (int i = 0; i < N; i++) {
            for (int j = C; j >= v[i]; j--) {
                for (int k = 0; k <= s[i] && j >= k * v[i]; k++) {
                    dp[j] = Math.max(dp[j], dp[j - k * v[i]] + k * w[i]);
                }
                System.out.print(dp[j] + ",");
            }
            System.out.println();

        }
        return dp[C];
    }

    // common solution o(wN^2)
    // f(i, j) = max(f(i - 1, j - k * cost[i]) + k * val[i]) (k >= 0 && k <= min(nums[i], j / cost[i]))
    // f(j) = max(f(j - k * cost[i]) + k * val[i]) (k >= 0 && k <= min(nums[i], j / cost[i]))
    private static int solution1(int w, int[] nums, int[] val, int[] cost) {
        int[] dp = new int[w + 1];
        // base case
        for (int i = 1; i <= w; i++) {
            dp[i] = Integer.MIN_VALUE;
        }
        // dp
        for(int i = 1; i <= nums.length; i++){
            int index = i - 1;
            for (int j = w; j >= cost[index]; j--) {
                for (int k = 1; k <= Math.min(nums[index], j / cost[index]); k++) {
                    dp[j] = Math.max(dp[j], dp[j - k * cost[index]] + k * val[index]);
                }
//                System.out.print(dp[j] + ",");
            }
            System.out.println();
        }
        return dp[w];
    }
    // binary solution o(wlg(sigma nums[i]))
    // nums[i] ---> 2^0, 2^1, ..., 2^(k - 1), nums[i] - (2^k - 1)   (2^k < nums[i] + 1)
    private static int solution2(int w, int[] nums, int[] val, int[] cost) {
        List<Integer> n = new LinkedList<>();
        List<Integer> v = new LinkedList<>();
        List<Integer> c = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            int k = 1;
            for (; k < nums[i] + 1; k <<= 1) {
                n.add(k);
                v.add(val[i]);
                c.add(cost[i]);
            }
            n.add(nums[i] + 1 - k);
            v.add(val[i]);
            c.add(cost[i]);
        }
        int[] dp = new int[w + 1];
        for (int i = 1; i <= w; i++) {
            dp[i] = Integer.MIN_VALUE;
        }
        for (int i = 0; i < n.size(); i++) {
            for (int j = w; j >= c.get(i); j--) {
                dp[j] = Math.max(dp[j], dp[j - c.get(i)] + v.get(i));
            }
        }
        return dp[w];
    }
    //https://blog.csdn.net/flyinghearts/article/details/5898183?utm_medium=distribute.pc_relevant_t0.none-task-blog-2%7Edefault%7EBlogCommendFromMachineLearnPai2%7Edefault-1.control&depth_1-utm_source=distribute.pc_relevant_t0.none-task-blog-2%7Edefault%7EBlogCommendFromMachineLearnPai2%7Edefault-1.control
    // o(wN) deque
    // f(i, j) = max(f(i - 1, j - m * cost[i]) + m * val[i]) (0 <= m && m <= min(nums[i], j / cost[i]))
    // 令 a = j / cost[i]; j = a * cost[i] + mod; k = a - m (a - min(nums[i], j / cost[i]) <= k && k <= a)
    // f(i, j) = max(f(i - 1, k * cost[i] + mod) - k * val[i]) + a * val[i]
    // f(j) = max(f(k * cost[i] + mod) - k * val[i]) + a * val[i]  (reverse order)
    private static int solution3(int w, int[] nums, int[] val, int[] cost) {
        int[] dp = new int[w + 1];

//        for (int i = 1; i <= w; i++) {
//            dp[i] = -1000000;
//        }
        for(int i = 0; i < nums.length; i++){
            int[] g = dp.clone();// dp[i - 1][j]
            for(int mod = 0; mod < cost[i]; mod++){
                Deque<Integer> dq = new LinkedList<>();
                for (int k = 0; k * cost[i] + mod <= w; k++) {
                    int j = k * cost[i] + mod;
                    int y = g[j] - k * val[i];
                    if(!dq.isEmpty() && k - dq.peekFirst() / cost[i] > nums[i]){
                        dq.pollFirst();
                    }
                    while(!dq.isEmpty() && g[dq.peekLast()] - (dq.peekLast() / cost[i]) * nums[i] < y){
                        dq.pollLast();
                    }
                    dq.offerLast(j);
                    dp[j] = g[dq.peekFirst()]  - (dq.peekFirst() / cost[i]) * val[i] + k * val[i];
                }
            }
            for (int j = 0; j < dp.length; j++) {

                System.out.print(dp[j] + ",");
            }
            System.out.println();
        }
        return dp[w];
    }
//    private static int multiPack(int N, int V, int[] v, int[] w, int[] s){
//        int[] dp = new int[V + 1];
//        int[] g = new int[V + 1];
//        for(int i = 0; i < N; i++){
//            g = dp.clone();// dp[i - 1][j]
//            for(int mod = 0; mod < v[i]; mod++){
//                Deque<Integer> dq = new LinkedList<>();
//                for(int k = 0; (k * v[i] + mod) <= V; k++){
//                    int j = k * v[i] + mod;
//                    int y = g[j] - k * w[i];
//                    if(!dq.isEmpty() && k - dq.peekFirst() / v[i] > s[i]){
//                        dq.pollFirst();
//                    }
//                    while(!dq.isEmpty() && g[dq.peekLast()] - (dq.peekLast() / v[i]) * w[i] < y){
//                        dq.pollLast();
//                    }
//                    dq.offerLast(j);
//                    dp[j] = g[dq.peekFirst()]  - (dq.peekFirst() / v[i]) * w[i] + k * w[i];
//                }
//            }
//        }
//        return dp[V];
//    }
    private static int maxValue2(int N, int C, int[] s, int[] v, int[] w) {
        int[] dp = new int[C + 1];
        int[] g = new int[C + 1]; // 辅助队列，记录的是上一次的结果
        int[] q = new int[C + 1]; // 主队列，记录的是本次的结果

        // 枚举物品
        for (int i = 0; i < N; i++) {
            int vi = v[i];
            int wi = w[i];
            int si = s[i];
            // 将上次算的结果存入辅助数组中
            g = dp.clone();

            // 枚举余数
            for (int j = 0; j < vi; j++) {
                int hh = 0, tt = -1;
                // 枚举同一余数情况下，有多少种方案。例如余数为 1 的情况下有：1、vi + 1、2 * vi + 1、3 * vi + 1 ...
                for (int k = j; k <= C; k+=vi) {
                    dp[k] = g[k];
                    if (hh <= tt && q[hh] < k - si * vi) hh++;
                    if (hh <= tt) dp[k] = Math.max(dp[k], g[q[hh]] + (k - q[hh]) / vi * wi);
                    while (hh <= tt && g[q[tt]] - (q[tt] - j) / vi * wi <= g[k] - (k - j) / vi * wi) tt--;
                    q[++tt] = k;
                }
            }
        }
        return dp[C];
    }

    // o(wN) 不考虑价值的时候，能不能填满背包
    // f(i, j)表示用了前 i 种物品填满容量为 j 的背包后，最多还剩下下几个第 i 种物品可用
    //
    private static int solution4(int w, int[] nums, int[] val, int[] cost) {
        int[][] dp = new int[nums.length + 1][w + 1];
        // base case
        for (int i = 1; i <= w; i++) {
            dp[0][i] = Integer.MIN_VALUE;
        }
        // dp
        for (int i = 1; i <= nums.length; i++) {
            for (int j = 0; j <= w; j++) {
                if(dp[i - 1][j] >= 0){
                    dp[i][j] = nums[i - 1];
                }else{
                    dp[i][j] = Integer.MIN_VALUE;
                }
            }
            for (int j = 0; j <= w - cost[i - 1]; j++){
                if(dp[i][j] > 0){
                    dp[i][j + cost[i - 1]] = Math.max(dp[i][j] - 1, dp[i][j + cost[i - 1]]);

                }
            }
        }
        return dp[nums.length][w];

    }
}
