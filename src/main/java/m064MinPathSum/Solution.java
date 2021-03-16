package m064MinPathSum;

/**
 * @description:
 * @author: Kuarker Lee
 * @date: 2021/3/16
 **/
public class Solution {

    public static void main(String[] args) {
        int[][] ints={{1,3,1},{1,5,1},{4,2,1}};
        System.out.println(minPathSum(ints));

    }


    public static int minPathSum(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int top = i > 0 ? dp[i - 1][j] + grid[i][j] : Integer.MAX_VALUE;
                int left = j > 0 ? dp[i][j - 1] + grid[i][j] : Integer.MAX_VALUE;
                if (!(i==0&&j==0)){
                    dp[i][j]=Math.min(top,left);
                }
            }
        }
        return dp[m - 1][n - 1];
    }

}
