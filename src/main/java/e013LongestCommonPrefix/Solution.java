package e013LongestCommonPrefix;

/**
 * @description:
 * @author: Kuarker Lee
 * @date: 2021/2/10
 **/
public class Solution {
    public static void main(String[] args) {
        String[] strings = {"fl","f","fl"};
        System.out.println(longestCommonPrefix(strings));
    }
    public static String longestCommonPrefix(String[] strs) {

        if (strs == null || strs.length == 0) {
            return "";
        }
        // 排除空对象
        for (int s = 0; s < strs.length; s++) {
            if (strs[s] == null) {
                return "";
            }
        }
        int len = strs.length;
        StringBuilder sb = new StringBuilder();
        String first = strs[0];
        for (int i = 0; i < first.length(); i++) {
            // 第一个不再比较
            for (int j = 1; j < len; j++) {
                //
                if ( strs[j].length()<i+1||first.charAt(i) != strs[j].charAt(i)) {
                    return sb.toString();
                }
            }
            sb.append(first.charAt(i));

        }
        return sb.toString();
    }
}
