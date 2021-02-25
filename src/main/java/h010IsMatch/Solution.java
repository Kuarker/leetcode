package h010IsMatch;

import lombok.extern.slf4j.Slf4j;

/**
 * @description:
 * @author: Kuarker Lee
 * @date: 2021/2/5
 **/
@Slf4j
public class Solution {

    public static void main(String[] args) {
        String s = "bs";
        String p="b*s";
        boolean match = isMatch(s, p);
    }

    public static boolean isMatch(String s, String p) {

        int lenS = s.length();
        int lenP = p.length();
        char asterisk = '*';
        boolean[][] dp = new boolean[lenS +1 ][lenP+1 ];

        dp[0][0] = true;

        for (int i = 0; i <=lenS; i++) {
            for (int j = 1; j <= lenP; j++) {
                //  p 不能只是 * 开头
                if (p.charAt(j - 1) == asterisk) {
                    // p 不能只是 *
                    //s=bs  p=b*s 时  dp[1][1]直接等于d[1][0]
                    int k=j - 2;
                    dp[i][j] = dp[i][k];
                    if (macth(s, p, i, j - 1)) {
                        //
                        dp[i][j] = dp[i][j] || dp[i - 1][j];
                    }
                } else {
                    if (macth(s, p, i, j)) {
                        // s的前i个字符是否和p的前j个字符匹配，和s的前i-1个字符是否和p的前j-1个字符匹配一致
                        dp[i][j] = dp[i - 1][j - 1];
                    }
                }

            }

        }

        return dp[lenS][lenP];
    }

    // s 的前i个字符是否与p的前j个字符匹配
    private static boolean macth(String s, String p, int i, int j) {
        if (i == 0) {
            return false;
        }
        if (p.charAt(j - 1) == '.') {
            return true;
        }
        if (s.charAt(i - 1) == p.charAt(j - 1)) {
            return true;
        }
        return false;
    }
}
