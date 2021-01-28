package com.snx;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Main {


    /*请完成下面这个函数，实现题目要求的功能
    当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^
    ******************************开始写代码******************************/
    static int maxAreaOfIsland(int[][] grid) {
        int max = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1){
                    int cur = dfs(grid, i, j);
                    if(max < cur) max = cur;
                }
            }
        }
        return max;

    }
    static int dfs(int[][] grid, int y, int x){
        if(y < 0 || y >= grid.length || x < 0 || x >= grid[0].length || grid[y][x] == 0)
            return 0;
        grid[y][x] = 0;
        int d = dfs(grid, y+1, x);
        int l = dfs(grid, y, x-1);
        int r = dfs(grid, y, x+1);
        int u = dfs(grid, y-1, x);
        return 1 + d + l + r + u;
    }
    /******************************结束写代码******************************/


    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int res;

        int _grid_rows = 0;
        int _grid_cols = 0;
        _grid_rows = Integer.parseInt(in.nextLine().trim());
        _grid_cols = Integer.parseInt(in.nextLine().trim());

        int[][] _grid = new int[_grid_rows][_grid_cols];
        for(int _grid_i=0; _grid_i<_grid_rows; _grid_i++) {
            for(int _grid_j=0; _grid_j<_grid_cols; _grid_j++) {
                _grid[_grid_i][_grid_j] = in.nextInt();

            }
        }

        if(in.hasNextLine()) {
            in.nextLine();
        }

        res = maxAreaOfIsland(_grid);
        System.out.println(String.valueOf(res));

    }
}

