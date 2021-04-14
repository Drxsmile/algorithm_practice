package com.snx;

import java.util.ArrayList;
import java.util.List;

public class Main {
    static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) {
        // write your code here
        int[][] matrix = {
                {1, 1, 0}, {1, 1, 0}, {0, 0, 1}
        };
        int res = circles(matrix);
        System.out.println(res);
    }

    public static int circles(int[][] matrix) {
        int n = matrix.length;
        if (n == 0) return 0;
        int res = n;
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (matrix[i][j] == 1) {
                    union(i, j);
                    res--;
                }
            }
        }
        return res;
    }

    public static int find(int i) {
        while (i != list.get(i)) {
            i = list.get(i);
        }
        return i;
    }

    public static boolean union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);
        if (rootA == rootB) return false;
        list.set(rootB, rootA);
        return true;
    }
}
