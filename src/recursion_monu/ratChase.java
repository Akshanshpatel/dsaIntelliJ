package recursion_monu;

import java.util.*;

public class ratChase {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int r = sc.nextInt();
        int c = sc.nextInt();
        char[][] maze = new char[r][c];

        for (int i = 0; i < r; i++) {
            String s = sc.next();
            for (int j = 0; j < c; j++) {
                maze[i][j] = s.charAt(j);
            }
        }

        boolean found=path(maze, 0, 0);

        System.out.println(found ? "Path exists" : "No path");
    }

    public static boolean path(char[][] maze, int r, int c) {

        // destination reached
        if (r == maze.length - 1 && c == maze[0].length - 1) {
            return true;
        }

        // invalid cell
        if (r < 0 || c < 0 ||
                r >= maze.length || c >= maze[0].length ||
                maze[r][c] != '0') {
            return false;
        }

        // mark visited
        maze[r][c] = '#';

        boolean found = path(maze, r + 1, c) ||  path(maze, r - 1, c) || path(maze, r, c + 1) || path(maze, r, c - 1);

        // backtrack
        maze[r][c] = '0';

        return found;
    }
}
