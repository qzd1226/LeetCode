package DFS;
// LeetCode 1102
//给定一个 m x n 的整数矩阵 grid，返回从 (0,0) 开始到 (m - 1, n - 1) 在四个基本方向上移动的路径的最大 分数 。
//
//        一条路径的 分数 是该路径上的最小值。
//
//        例如，路径 8 → 4 → 5 → 9 的得分为 4 。
//         
//
//        来源：力扣（LeetCode）
//        链接：https://leetcode.cn/problems/path-with-maximum-minimum-value
//        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
public class minRoot {

    public static void main(String[] args) {
        int[][] grid = new int[3][3];
        grid[0] = new int[]{5, 4, 5};
        grid[1] = new int[]{1, 2, 6};
        grid[2] = new int[]{7, 4, 6};
        boolean[][] visited = new boolean[3][3];
        int ans = dfs(grid,0,0,visited);
        System.out.println(ans);
    }

    public static int dfs(int[][] grid, int row, int col, boolean[][] visited){
        if(row == grid.length - 1  && col == grid[0].length - 1){
            return grid[row][col];
        }else{
            visited[row][col] = true;
            int up = -1;
            int down = -1;
            int left = -1;
            int right = -1;
            if(row < grid.length - 1 && visited[row+1][col] == false){
                up = dfs(grid, row + 1, col, visited);
                visited[row+1][col] = false;
            }
            if(row > 0 && visited[row-1][col] == false){
                down = dfs(grid,row-1,col,visited);
                visited[row-1][col] = false;
            }
            if(col < grid.length - 1 && visited[row][col + 1] == false){
                right = dfs(grid,row,col+1,visited);
                visited[row][col+1] = false;
            }
            if(col > 0 && visited[row][col - 1] == false){
                left = dfs(grid,row,col-1,visited);
                visited[row][col-1] = false;
            }
            int curMax = up;
            curMax = Math.max(curMax, up);
            curMax = Math.max(curMax, down);
            curMax = Math.max(curMax, left);
            curMax = Math.max(curMax, right);
//            if(curMax == up && row < grid.length - 1){
//                visited[row + 1][col] = true;
//            }else if(curMax == down){
//                visited[row-1][col] = true;
//            }else if(curMax == left){
//                visited[row][col - 1] = true;
//            }else{
//                if(col < grid[0].length - 1){
//                    visited[row][col + 1] = true;
//                }
//            }
            //System.out.println("curMax:" + curMax);
            visited[row][col] = false;
            return Math.min(curMax,grid[row][col]);

        }
    }
}
