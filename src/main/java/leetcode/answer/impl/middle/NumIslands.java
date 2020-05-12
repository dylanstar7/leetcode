package leetcode.answer.impl.middle;

import leetcode.answer.model.TreeNode;

import java.util.*;

/**
 * TODO
 *
 * @author lijiakun
 * @date 2020/04/20 11:36
 */
public class NumIslands {

    int[][] directions = new int[][]{{0,-1},{0,1},{1,0},{-1,0}};

    /**
     * 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
     * <p>
     * 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
     * <p>
     * 此外，你可以假设该网格的四条边均被水包围。
     * <p>
     * 输入:
     * 11110
     * 11010
     * 11000
     * 00000
     * 输出: 1
     * <p>
     * 输入:
     * 11000
     * 11000
     * 00100
     * 00011
     * 输出: 3
     *
     * @param grid
     * @return
     */
    public void dfs(char[][] grid, int x, int y) {
        int xlength = grid.length;
        int ylength = grid[0].length;

        if (x < 0 || y < 0 || x >= xlength || y >= ylength || grid[x][y] == '0') {
            return;
        }
        grid[x][y] = '0';
        dfs(grid, x - 1, y);
        dfs(grid, x + 1, y);
        dfs(grid, x, y - 1);
        dfs(grid, x, y + 1);
    }


    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int xlength = grid.length;
        int ylength = grid[0].length;

        int number = 0;
        for (int x = 0; x < xlength; x++) {
            for (int y = 0; y < ylength; y++) {
                if (grid[x][y] == '1') {
                    number++;
                    //将岛屿相邻岛屿一起置为0
                    dfs(grid, x, y);
                }
            }
        }

        return number;


    }

    public int numIslands1(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        int n = grid.length, m = grid[0].length;

        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '0') continue; // 剪枝
                res++;
                Queue<int[]> queue = new LinkedList<>();
                queue.add(new int[]{i,j});
                grid[i][j] = '0';
                while (!queue.isEmpty()){
                    int[] top = queue.poll();
                    for (int k = 0; k < 4; k++) {
                        int newX = top[0] + directions[k][0];
                        int newY = top[1] + directions[k][1];
                        if (newX < 0 || newX >= n || newY < 0 || newY >= m || grid[newX][newY] == '0') continue;
                        queue.add(new int[]{newX, newY});
                        grid[newX][newY] = '0';
                    }
                }
            }
        }
        return res;
    }


    public static void main(String[] args) {
        NumIslands islands = new NumIslands();
//        char[][] grid = new char[][]{{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}};
        char[][] grid = new char[][]{{'1', '1', '0', '0', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '1', '0', '0'}, {'0', '0', '0', '1', '1'}};
        int number = islands.numIslands1(grid);


        System.out.println(number);
    }


    public int balancedStringSplit(String s) {
        Queue<Integer> queue = new LinkedList();
        int length = s.length();
        int number = 0;
        if(length == 0){
            return number;
        }
        queue.add(1);
        for(int i =1; i<length;i++){
            if(s.charAt(i) == s.charAt(i-1)){
                queue.add(1);
            }else{
                queue.poll();
            }
            if(queue.isEmpty()){
                number++;
            }
        }
        return number;
    }



    

}
