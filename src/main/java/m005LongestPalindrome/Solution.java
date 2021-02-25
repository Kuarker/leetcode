package m005LongestPalindrome;

/**
 * @description:
 * @author: Kuarker Lee
 * @date: 2021/2/3
 **/
public class Solution {

    public static void main(String[] args) {

        String str="aaaaaaba";
        long begin = System.currentTimeMillis();
        longestPalindrome(str);
        long end = System.currentTimeMillis();
        System.out.println(end-begin);


    }
    public static String longestPalindrome(String s) {

        if (s == null) {
            throw new RuntimeException("输入不可为空！");
        }

        int length = s.length();
        if (length<2){
            return s;
        }
        int maxlen = 1;
        int begin = 0;

        boolean[][] dp = new boolean[length][length];
        for (int i = 0; i < length; i++) {
            dp[i][i] = true;
        }

        for (int j = 1; j < length; j++) {
            // i<j 只会计算出二维数组的对角线右上部分,因为字符串有头和尾，是有方向的，所以二位数组不需要每个位置都计算
            for (int i = 0; i < j; i++) {
                char start = s.charAt(i);
                char end = s.charAt(j);
                if (start != end) {
                    dp[i][j] = false;
                } else {
                    //
                    if (j - i < 3) {
                        dp[i][j] = true;
                    } else {
                        // 因为i<j,j<length,所以i最大智能取到length-1；
                        // 这里不会越界
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }

                if (dp[i][j] && (j - i + 1) > maxlen) {
                    maxlen = (j - i + 1);
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + maxlen);
    }
}
