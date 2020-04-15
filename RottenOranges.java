import java.util.*;
/* Rotten Oranges : https://leetcode.com/problems/rotting-oranges/
In a given grid, each cell can have one of three values:

the value 0 representing an empty cell;
the value 1 representing a fresh orange;
the value 2 representing a rotten orange.
Every minute, any fresh orange that is adjacent (4-directionally) to a rotten orange becomes rotten.

Return the minimum number of minutes that must elapse until no cell has a fresh orange.  If this is impossible, return -1 instead.
* */
public class RottenOranges {

    public static void main(String[] args) {
        // write your code here
        int[][] input = new int[][]{{1}, {2}, {1}, {1}};
        System.out.println(orangesRotting(input));
    }

    public static int orangesRotting(int[][] grid) {
        int fresh = 0;
        if(grid == null || grid.length == 0) return 0;
        Queue<int[]> rottenQueue = new LinkedList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {//fresh oranges
                    fresh++;
                }
                if (grid[i][j] == 2) {
                    rottenQueue.offer(new int[]{i, j});
                }
            }
        }
        int[][] directions = new int[][]{{1, 0}, {0, 1}, {0, -1}, {-1, 0}};
        int count = 0;
        if(fresh == 0) return 0;
        while (!rottenQueue.isEmpty()) {
            ++count;
            int size = rottenQueue.size();
            for (int i = 0; i < size; i++) {
                int[] rottenElement = rottenQueue.poll();
                for (int[] dir : directions) {
                    int x = rottenElement[0] + dir[0];
                    int y = rottenElement[1] + dir[1];
                    if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length || grid[x][y] == 0 || grid[x][y] == 2)
                        continue;
                    grid[x][y] = 2;
                    fresh--;
                    rottenQueue.offer(new int[]{x, y});
                }
            }
        }
        return fresh == 0 ? count-1 : -1;
    }
}
