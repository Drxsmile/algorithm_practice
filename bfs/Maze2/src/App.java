import java.util.LinkedList;
import java.util.Queue;

public class App {
    final static int startX = 3;
    final static int startY = 4;
    final static int targetX = 1;
    final static int targetY = 0;
    final static int[][] maze = { { 0, 0, 0, 0, 0 }, { 1, 1, 0, 0, 1 }, { 0, 0, 0, 0, 0 }, { 0, 1, 0, 0, 1 },
            { 0, 1, 0, 0, 0 } };

    public static void main(String[] args) throws Exception {
        // maze2();
        maze3();
        System.out.println("steps");
    }

    private static void maze3() {
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(startX, startY));
        int[] dx = { 1, -1, 0, 0 };
        int[] dy = { 0, 0, 1, -1 };
        String[] dir = { "r", "l", "d", "u" };
        String[][] path = new String[maze.length][maze[0].length];
        int[][] distance = new int[maze.length][maze[0].length];
        for (int i = 0; i < distance.length; i++) {
            for (int j = 0; j < distance[0].length; j++) {
                distance[i][j] = Integer.MAX_VALUE;
                path[i][j] = "";
            }
        }
        distance[startY][startX] = 0;
        while (!q.isEmpty()) {
            Point p = q.poll();
            for (int i = 0; i < dx.length; i++) {
                int x = p.x;
                int y = p.y;
                System.out.println("point: " + "(" + x + "," + y + ")");
                int dist = distance[y][x];
                String curPath = path[y][x];
                while (x >= 0 && y >= 0 && x < maze[0].length && y < maze.length && maze[y][x] == 0
                        && (x != targetX || y != targetY)) {
                    x += dx[i];
                    y += dy[i];
                    dist++;
                }
                if (x != targetX || y != targetY) {
                    x -= dx[i];
                    y -= dy[i];
                    dist--;
                }

                String newPath = dist == 0 ? curPath : curPath + dir[i];
                System.out.println("figure: " + "(" + x + "," + y + ")");
                if (dist < distance[y][x] || (dist == distance[y][x] && newPath.compareTo(path[y][x]) < 0)) {
                    distance[y][x] = dist;
                    path[y][x] = newPath;
                    if (x != targetX || y != targetY) {
                        q.offer(new Point(x, y));
                    }
                }
            }

        }
        String resPath = path[targetY][targetX];
        int res = distance[targetY][targetX];
        System.out.println(res);
        System.out.println(resPath);
    }

    public static void maze2() {
        int[][] distance = new int[maze.length][maze[0].length];
        for (int i = 0; i < distance.length; i++) {
            for (int j = 0; j < distance[0].length; j++) {
                distance[i][j] = Integer.MAX_VALUE;
            }
        }
        distance[startY][startX] = 0;
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(startX, startY));
        int[] dx = { 1, -1, 0, 0 };
        int[] dy = { 0, 0, 1, -1 };
        while (!q.isEmpty()) {
            Point p = q.poll();
            for (int i = 0; i < dy.length; i++) {
                int x = p.x;
                int y = p.y;
                System.out.println("point: " + "(" + x + "," + y + ")");
                int dist = distance[y][x];
                while (x >= 0 && x < maze[0].length && y < maze.length && y >= 0 && maze[y][x] == 0) {

                    x = x + dx[i];
                    y = y + dy[i];
                    dist++;
                }
                x -= dx[i];
                y -= dy[i];
                dist--;
                if (dist < distance[y][x]) {
                    distance[y][x] = dist;
                    if (x != targetX || y != targetY) {
                        q.offer(new Point(x, y));
                    }
                }
            }
            maze[p.y][p.x] = 1;

        }
        int res = distance[targetY][targetX] == Integer.MAX_VALUE ? -1 : distance[targetY][targetX];
        System.out.println(res);

    }
}

class Point {
    int x;
    int y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
