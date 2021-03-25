package com.snx;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
            {5, 8, 7},
            {2, 9, 5},
            {0, 2, 3}
        };
        int[] res = topNNumbers(matrix);
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }
    }

    private static int[] topNNumbers(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[] res = new int[n];
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(n, new Comparator<Integer>() {
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        for (int i = 0; i < n; i++) {
            minHeap.offer(matrix[0][i]);
        }
        for (int i = 1; i < m; i++) {
            int[] list = new int[n];
            // 降序
            for (int j = n - 1; j >= 0; j--) {
                list[j] = minHeap.poll();
//                System.out.println("list[" + j + "] = " + list[j]);
            }
            int[] cur = matrix[i];
            // 升序
            Arrays.sort(cur);
            for (int j = 0; j < n; j++) {
                minHeap.offer(cur[n - 1] + list[j]);
//                System.out.println("top" + minHeap.peek());
            }
            for (int j = n - 2; j >= 0; j--) {
                for (int k = 0; k < n; k++) {
                    int sum = cur[j] + list[k];
                    if(sum <= minHeap.peek()) break;
                    else{
                        minHeap.poll();
                        minHeap.offer(sum);
                    }
                }
            }

        }
        for (int i = 0; i < n; i++) {
            res[i] = minHeap.poll();
        }
        return res;
    }
    // answer
    // time complexity: O(mn^2lgn)
    public List<Integer> topNumbers(int[][] numbers) {
        int m = numbers.length;
        int n = numbers[0].length;
        Comparator<Integer> comparator = new Comparator<Integer>() {
            public int compare(Integer a, Integer b) {
                return b - a;
            }
        };
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(n);
        for (int i: numbers[0]) {
            minHeap.add(i);
        }
        int[] list = new int[n];
        for (int i = 1; i < m; i ++) {
            for (int j = n - 1; j >= 0; j --) {
                list[j] = minHeap.poll();
            }
            int[] cur = numbers[i];
            // 需要将cur转换成Integer[]
//            Arrays.sort(cur, comparator);
            int largest = cur[0];
            for (int j = 0; j < n; j ++) {
                minHeap.add(largest + list[j]);
            }
            for (int j = 1; j < n; j ++) {
                for (int r = 0; r < n ; r ++) {
                    if (cur[j] + list[r] < minHeap.peek()) {
                        break;
                    }
                    minHeap.poll();
                    minHeap.add(cur[j] + list[r]);
                }
            }
        }
        List<Integer> result = new ArrayList<>();
        result.addAll(minHeap);
        Collections.sort(result, comparator);
        return result;
    }
}















