import java.util.ArrayList;

class Maze{
	public static void main(String[] args) {
		char[][] maze = {
			{'.','x','.','.','.','x'},
			{'.','.','.','x','.','x'},
			{'x','x','.','x','.','.'},
			{'.','x','x','x','.','x'},
			{'.','.','.','.','.','x'},
			{'.','.','.','.','.','.'}
		};
		//boolean solved = solution(maze, 0, 0, 5, 5);
		//boolean solved2 = solu(maze, 0, 0, 5, 5);
		//boolean solved3 = path(maze, 0, 0, 5, 5);
		boolean solved4 = path2(maze, 0, 0, 5, 5, "");
		//boolean solved5 = solveMaze(maze, 0, 0, 5, 5, "");
		System.out.println(/*solved + "---" +*/solved4);
	}

	public static boolean solution(char[][] maze, 
								int startX, int startY, int tarX, int tarY){
		//base case
		//1. out of bound 2. meet the wall
		if(startX < 0 || startX >= maze[0].length
			|| startY <0 || startY >= maze.length
			|| maze[startY][startX] == 'x')
			return false;
		//3. meet the target
		if(startX == tarX && startY == tarY)
			return true;
		// mark visited spot with 'x'
		maze[startY][startX] = 'x';
		
		//recursion rule

		return  solution(maze, startX + 1, startY, tarX, tarY) ||
				solution(maze, startX, startY + 1, tarX, tarY) ||
				solution(maze, startX - 1, startY, tarX, tarY) ||
				solution(maze, startX, startY - 1, tarX, tarY) ;
			
	}

	public static boolean solu(char[][] maze, 
								int startX, int startY, int tarX, int tarY){
		
		//base case
		//3. meet the target
		if(startX == tarX && startY == tarY)
			return true;
		// mark visited spot with 'x'
		maze[startY][startX] = 'x';
		
		//recursion rule
		int[] dx = {1, 0, -1, 0};
		int[] dy = {0, 1, 0, -1};
		for (int i = 0; i < 4; i++) {
			int newX = startX + dx[i];
			int newY = startY + dy[i];
			if(newX < 0 || newX >= maze[0].length
			|| newY <0 || newY >= maze.length
			|| maze[newY][newX] == 'x')
				continue;
			if(solu(maze, newX, newY, tarX, tarY))
				return true;
		}
		return false;
			
	}

	public static boolean path(char[][] maze, 
								int startX, int startY, int tarX, int tarY){
		for (int x = 0;x < maze.length; x++) {
			for (int y = 0;y < maze[0].length; y++) {
				System.out.print(maze[y][x]+ " ");
				if(y == maze[0].length-1) 
					System.out.println();
			}

		}
		System.out.println();
		//base case
		//3. meet the target
		if(startX == tarX && startY == tarY)
			return true;
		// mark visited spot with 'x'
		maze[startY][startX] = 'v';
		
		//recursion rule
		int[] dx = {1, 0, -1, 0};
		int[] dy = {0, 1, 0, -1};
		for (int i = 0; i < 4; i++) {
			int newX = startX + dx[i];
			int newY = startY + dy[i];
			if(newX < 0 || newX >= maze[0].length
			|| newY <0 || newY >= maze.length
			|| maze[newY][newX] == 'x' || maze[newY][newX] == 'v')
				continue;
			if(path(maze, newX, newY, tarX, tarY))
				return true;
		}
		return false;
			
	}

	public static boolean path2(char[][] maze, 
								int startX, int startY, int tarX, int tarY,
								String path){
		//base case
		//3. meet the target
		if(startX == tarX && startY == tarY){
			System.out.println(path);
			return true;
		}
			
		// mark visited spot with 'x'
		maze[startY][startX] = 'x';
		
		//recursion rule
		int[] dx = {1, 0, -1, 0};
		int[] dy = {0, 1, 0, -1};
		char[] dir = {'R', 'D', 'L', 'U'};
		for (int i = 0; i < 4; i++) {
			int newX = startX + dx[i];
			int newY = startY + dy[i];
			String newPath = path + dir[i] + " ";
			if(newX < 0 || newX >= maze[0].length
			|| newY <0 || newY >= maze.length
			|| maze[newY][newX] == 'x')
				continue;

			if(path2(maze, newX, newY, tarX, tarY, newPath)){
				return true;
			}
		}
		return false;

	}

	public static boolean solveMaze(char[][] maze, 
                                int startX, int startY, int targetX, int targetY,
                                ArrayList<Character> path) {
    if (startX < 0 || startX >= maze.length ||
        startY < 0 || startY >= maze[0].length ||
        maze[startX][startY] == 'X') {
      return false;
    }
    if (startX == targetX && startY == targetY) {
      System.out.println(path);
      return true;
    }
    maze[startX][startY] = 'X';
    int[] dx = {1, 0, -1, 0};
    int[] dy = {0, 1, 0, -1};
    char[] direction = {'D', 'R', 'U', 'L'};
    for (int i = 0; i < 4; i++) {
      path.add(direction[i]);
      if (solveMaze(maze, startX+dx[i], startY+dy[i], targetX, targetY, path)) {
        return true;
      }
      path.remove(path.size()-1);
    }
    return false;
}
}

