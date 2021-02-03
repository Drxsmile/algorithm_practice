import java.util.LinkedList;
import java.util.Queue;

public class App {
    final static int targetX = 4;
    final static int targetY = 3;
    final static int startX = 0;
    final static int startY = 3;
    static char[][] maze = { { '.', 'x', '.', '.', '.', 'x' }, { '.', '.', '.', 'x', '.', 'x' },
            { 'x', 'x', '.', 'x', '.', '.' }, { '.', 'x', 'x', 'x', '.', 'x' }, { '.', '.', '.', '.', '.', 'x' },
            { '.', '.', '.', '.', '.', '.' } };

    public static void main(String[] args) throws Exception {
        int steps = -1;
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(startX, startY));
        maze[startY][startX] = 'x';
        while (!q.isEmpty()) {
            Queue<Point> q2 = new LinkedList<>();
            steps++;
            while (!q.isEmpty()) {
                Point p = q.poll();
                int x = p.x;
                int y = p.y;
                System.out.println("point: " + "(" + x + "," + y + ")");
                int[] dx = { 1, -1, 0, 0 };
                int[] dy = { 0, 0, 1, -1 };
                for (int i = 0; i < 4; i++) {
                    int newX = x + dx[i];
                    int newY = y + dy[i];
                    if (newX == targetX && newY == targetY) {
                        steps++;
                        System.out.print("minimum steps: " + steps);
                        return;
                    }
                    if (legal(newX, newY)) {
                        q2.offer(new Point(newX, newY));
                    }
                }
            }
            q = q2;
        }
        System.out.print(steps);
    }

    public static boolean legal(int x, int y) {
        if (x < 0 || y < 0 || x >= maze[0].length || y >= maze.length || maze[y][x] == 'x')
            return false;
        maze[y][x] = 'x';
        return true;
    }

}

class Point {
    int x;
    int y;

    Point() {

    }

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}