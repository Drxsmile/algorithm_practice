package com.snx;

/**
 * Given an undirected graph and a number m, determine if the graph can be colored with at most m colors such that no two adjacent vertices of the graph are colored with same color.
 * Here coloring of a graph means assignment of colors to all vertices.
 * <p>
 * Input:
 * graph = {0, 1, 1, 1},
 * {1, 0, 1, 0},
 * {1, 1, 0, 1},
 * {1, 0, 1, 0}
 * Output:
 * Solution Exists:
 * Following are the assigned colors
 * 1  2  3  2
 * Explanation: By coloring the vertices
 * with following colors, adjacent
 * vertices does not have same colors
 * <p>
 * Input:
 * graph = {1, 1, 1, 1},
 * {1, 1, 1, 1},
 * {1, 1, 1, 1},
 * {1, 1, 1, 1}
 * Output: Solution does not exist.
 * Explanation: No solution exits.
 */

/**
 * Input:
 * graph = {0, 1, 1, 1},
 *         {1, 0, 1, 0},
 *         {1, 1, 0, 1},
 *         {1, 0, 1, 0}
 * Output: true
 * Solution Exists:
 * Following are the assigned colors
 *  1  2  3  2
 * Explanation: By coloring the vertices
 * with following colors, adjacent
 * vertices does not have same colors
 *
 * Input:
 * graph = {1, 1, 1, 1},
 *         {1, 1, 1, 1},
 *         {1, 1, 1, 1},
 *         {1, 1, 1, 1}
 * Output: Solution does not exist.
 * Explanation: No solution exits.
 */

import java.util.Scanner;

public class Main {


    /******************************Answer******************************/
    static boolean graphColoring(int[][] graph, int m) {
        int[] color = new int[graph.length];
        return graphColoringUtil(graph, m, color, 0);
    }

    static boolean graphColoringUtil(int graph[][], int m,
                                     int[] color, int v) {
        if (v == graph.length)
            return true;

        for (int c = 1; c <= m; c++) {
            if (isSafe(v, graph, color, c)) {
                color[v] = c;

                if (graphColoringUtil(graph, m, color, v + 1))
                    return true;
                color[v] = 0;
            }
        }
        return false;
    }
    // v是当前节点，判断当前颜色c isSafe
    static boolean isSafe(int v, int graph[][], int color[],
                          int c) {
        for (int i = 0; i < graph.length; i++)
            if (graph[v][i] == 1 && c == color[i])
                return false;
        return true;
    }

    /******************************结束写代码******************************/


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        boolean res;

        int _graph_rows = 0;
        int _graph_cols = 0;
        _graph_rows = Integer.parseInt(in.nextLine().trim());
        _graph_cols = Integer.parseInt(in.nextLine().trim());

        int[][] _graph = new int[_graph_rows][_graph_cols];
        for (int _graph_i = 0; _graph_i < _graph_rows; _graph_i++) {
            for (int _graph_j = 0; _graph_j < _graph_cols; _graph_j++) {
                _graph[_graph_i][_graph_j] = in.nextInt();

            }
        }

        if (in.hasNextLine()) {
            in.nextLine();
        }

        int _m;
        _m = Integer.parseInt(in.nextLine().trim());

        res = graphColoring(_graph, _m);
        System.out.println(String.valueOf(res ? 1 : 0));
    }
}
