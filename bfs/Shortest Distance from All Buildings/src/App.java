import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class App {
    static class Point {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    int num = 0;

    /*
     * 请完成下面这个函数，实现题目要求的功能 当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^ 开始写代码
     ******************************/
    static int shortestDistance(int[][] grid) {
        /*
         * 不是每个0都能走到1, 我的答案没有考虑这种情况
         */
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < grid[0].length; i++) {
            for (int j = 0; j < grid.length; j++) {
                if (grid[j][i] == 0) {
                    int build = path(i, j, grid);
                    if (min > build)
                        min = build;
                }
            }
        }

        return min != Integer.MAX_VALUE ? min : -1;
    }

    static int path(int xx, int yy, int[][] grid) {
        int res = 0;
        Queue<Point> q = new LinkedList<>();
        int[] dx = { 1, -1, 0, 0 };
        int[] dy = { 0, 0, 1, -1 };
        int step = 0;
        q.offer(new Point(xx, yy));
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        while (!q.isEmpty()) {
            Queue<Point> q2 = new LinkedList<>();
            step++;
            System.out.println("step: " + step);
            while (!q.isEmpty()) {
                Point p = q.poll();
                visited[p.y][p.x] = true;
                for (int i = 0; i < dx.length; i++) {
                    int x = p.x;
                    int y = p.y;
                    System.out.println("111: " + x + ',' + y);
                    x += dx[i];
                    y += dy[i];
                    System.out.println("222: " + x + ',' + y);
                    if (x >= 0 && x < grid[0].length && y >= 0 && y < grid.length && grid[y][x] != 2
                            && visited[y][x] != true) {
                        if (grid[y][x] == 1) {
                            System.out.println("before 1: " + step);
                            res += step;

                            visited[y][x] = true;
                            System.out.println("res: " + res);
                        } else {
                            q2.offer(new Point(x, y));
                        }
                    }

                }
            }
            q = q2;
        }
        return res;
    }

    static int shortestDistance2(int[][] grid) {
        if (grid == null || grid[0].length == 0)
            return 0;
        final int[] shift = new int[] { 0, 1, 0, -1, 0 };

        int row = grid.length, col = grid[0].length;
        int[][] distance = new int[row][col];
        int[][] reach = new int[row][col];
        int buildingNum = 0;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1) {
                    buildingNum++;
                    Queue<int[]> myQueue = new LinkedList<int[]>();
                    myQueue.offer(new int[] { i, j });

                    boolean[][] isVisited = new boolean[row][col];
                    int level = 1;

                    while (!myQueue.isEmpty()) {
                        int qSize = myQueue.size();
                        for (int q = 0; q < qSize; q++) {
                            int[] curr = myQueue.poll();

                            for (int k = 0; k < 4; k++) {
                                int nextRow = curr[0] + shift[k];
                                int nextCol = curr[1] + shift[k + 1];

                                if (nextRow >= 0 && nextRow < row && nextCol >= 0 && nextCol < col
                                        && grid[nextRow][nextCol] == 0 && !isVisited[nextRow][nextCol]) {
                                    // The shortest distance from [nextRow][nextCol] to thic building
                                    // is 'level'.
                                    distance[nextRow][nextCol] += level;
                                    reach[nextRow][nextCol]++;

                                    isVisited[nextRow][nextCol] = true;
                                    myQueue.offer(new int[] { nextRow, nextCol });
                                }
                            }
                        }
                        level++;
                    }
                }
            }
        }
        printArray(grid);
        System.out.println();
        printArray(reach);
        System.out.println();
        printArray(distance);
        int shortest = Integer.MAX_VALUE;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 0 && reach[i][j] == buildingNum) {
                    shortest = Math.min(shortest, distance[i][j]);
                }
            }
        }

        return shortest == Integer.MAX_VALUE ? -1 : shortest;
    }

    public static void printArray(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    /****************************** 结束写代码 ******************************/

    public static void main(String[] args) {
        // Scanner in = new Scanner(System.in);

        // int _grid_rows = 0;
        // int _grid_cols = 0;
        // _grid_rows = Integer.parseInt(in.nextLine().trim());
        // _grid_cols = Integer.parseInt(in.nextLine().trim());
        //
        // int[][] _grid = new int[_grid_rows][_grid_cols];
        // for (int _grid_i = 0; _grid_i < _grid_rows; _grid_i++) {
        // for (int _grid_j = 0; _grid_j < _grid_cols; _grid_j++) {
        // _grid[_grid_i][_grid_j] = in.nextInt();
        //
        // }
        // }
        //
        // if (in.hasNextLine()) {
        // in.nextLine();
        // }

        int res;
        int[][] _grid = { { 1, 0, 2, 0, 1 }, { 0, 2, 0, 2, 0 }, { 0, 0, 1, 0, 0 } };
        res = shortestDistance(_grid);
        res = shortestDistance2(_grid);
        System.out.println(String.valueOf(res));

    }
}
