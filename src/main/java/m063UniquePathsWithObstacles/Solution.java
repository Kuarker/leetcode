package m063UniquePathsWithObstacles;

/**
 * @description:
 * @author: Kuarker Lee
 * @date: 2021/3/16
 **/
public class Solution {

    public static void main(String[] args) {

        int[][] ints={{0,0,0},{0,1,0},{0,0,0}};

        System.out.println(uniquePathsWithObstacles(ints));

    }


        public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
            int m=obstacleGrid.length;
            int n=obstacleGrid[0].length;
            int[][] dp=new int[m][n];

            dp[0][0]=obstacleGrid[0][0]==1?0:1;

            for (int i = 0; i < m; i++) {

                for (int j = 0; j < n; j++) {

                    if (obstacleGrid[i][j]!=1){

                        if (i>0&&j>0){
                            dp[i][j]=dp[i-1][j]+dp[i][j-1];
                        }else if(i==0&&j>0){
                            dp[i][j]=dp[i][j-1];
                        }else if(i>0&&j==0){
                            dp[i][j]=dp[i-1][j];
                        }
                    }

                }

            }
            return dp[m-1][n-1];

        }
}
