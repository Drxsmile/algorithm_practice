import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
Best Meeting Point
A group of two or more people wants to meet and minimize the total travel distance. You are given a 2D grid of values 0 or 1, where each 1 marks the home of someone in the group. The distance is calculated using Manhattan Distance, where distance(p1, p2) = |p2.x - p1.x| + |p2.y - p1.y|.

For example, given three people living at (0,0), (0,4), and (2,2): Result is (0,2)

1 - 0 - 0 - 0 - 1
|   |   |   |   |
0 - 0 - 0 - 0 - 0
|   |   |   |   |
0 - 0 - 1 - 0 - 0
*/
public class App {
    public static void main(String[] args) throws Exception {
        int[][] grid = { { 1, 0, 0, 0, 1 }, { 0, 0, 0, 0, 0 }, { 0, 0, 1, 0, 0 } };
        int res = minTotalDist(grid);
        System.out.println(res);
    }

    private static int minTotalDist(int[][] grid) {

        return 0;
    }

    // answer
    public static int minTotalDistance(int[][] grid) {
        List<Integer> ipos = new ArrayList<Integer>();
        List<Integer> jpos = new ArrayList<Integer>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    ipos.add(i);
                    jpos.add(j);
                }
            }
        }
        int sum = 0;
        Collections.sort(ipos);
        Collections.sort(jpos);
        int i = 0, j = ipos.size() - 1;
        while (i < j) {
            sum += ipos.get(j) - ipos.get(i);
            sum += jpos.get(j) - jpos.get(i);
            i++;
            j--;
        }
        return sum;
    }
}
