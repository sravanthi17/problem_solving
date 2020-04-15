import java.util.LinkedList;
import java.util.Queue;

/* Walls and Gates https://leetcode.com/problems/walls-and-gates/
* You are given a m x n 2D grid initialized with these three possible values.

-1 - A wall or an obstacle.
0 - A gate.
INF - Infinity means an empty room. We use the value 231 - 1 = 2147483647 to represent INF as you may assume that the distance to a gate is less than 2147483647.
Fill each empty room with the distance to its nearest gate. If it is impossible to reach a gate, it should be filled with INF.

Example:

Given the 2D grid:

INF  -1  0  INF
INF INF INF  -1
INF  -1 INF  -1
  0  -1 INF INF
After running your function, the 2D grid should be:

  3  -1   0   1
  2   2   1  -1
  1  -1   2  -1
  0  -1   3   4 */
public class WallsAndGates {

    public static void main(String[] args) {
        // write your code here
        int[][] input = new int[][]{{2147483647, -1, 0, 2147483647}, {2147483647, 2147483647, 2147483647, -1}, {2147483647, -1, 2147483647, -1}, {0, -1, 2147483647, 2147483647}};
        wallsAndGates(input);
    }

    public static void wallsAndGates(int[][] rooms) {
        if (rooms == null || (rooms.length == 0)) return;
        Queue<int[]> gateQueue = new LinkedList<>();
        int empty = 0;
        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[0].length; j++) {
                if (rooms[i][j] == 0) {
                    gateQueue.offer(new int[]{i, j});
                }
                if (rooms[i][j] == 2147483647) {
                    empty++;
                }
            }
        }
        if (empty == 0) return;
        int[][] directions = new int[][]{{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
        while (!gateQueue.isEmpty()) {
            int[] ele = gateQueue.poll();
            for (int[] dir : directions) {
                int x = ele[0] + dir[0];
                int y = ele[1] + dir[1];
                if (x < 0 || y < 0 || x >= rooms.length || y >= rooms[0].length || rooms[x][y] == -1)
                    continue;
                if (rooms[x][y] == 2147483647) {
                    rooms[x][y] = rooms[ele[0]][ele[1]] + 1;
                    empty--;
                    gateQueue.offer(new int[]{x, y});
                }
            }
            if (empty <= 0) {
                break;
            }
        }
    }

}
