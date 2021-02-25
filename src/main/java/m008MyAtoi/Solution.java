package m008MyAtoi;

import lombok.extern.slf4j.Slf4j;

/**
 * @description:
 * @author: Kuarker Lee
 * @date: 2021/2/4
 **/
@Slf4j
public class Solution {

    public static void main(String[] args) {
        System.out.println(myAtoi("-2147483647"));
    }

    public static int myAtoi(String s) {
        char blank = ' ';
        char positive = '+';
        char negative = '-';
        char[] chars = s.toCharArray();
        int length = chars.length;
        int index = 0;
        // 去掉空格
        while (index < length && chars[index] == blank) {
            index++;
        }
        if (index >= length) {
            return 0;
        }
        // 处理正负符号
        int sign = 1;
        if (chars[index] == negative) {
            sign = -1;
            index++;
        } else if (chars[index] == positive) {
            index++;
        }
        int ans = 0;
        //
        while (index < length) {
            char cur = chars[index];
            index++;
            if (cur > '9' || cur < '0') {
                break;
            }
            int temp = (cur - '0')* sign;
            // 数字变量前加 - 可以直接改变符号
            // 1） 处理边界问题,因为还会有数字增加进来，如果 cur > Integer.MAX_VALUE / 10,那么cur增大后必然越界
            // 2） (cur == Integer.MAX_VALUE / 10 && temp > Integer.MAX_VALUE % 10) temp 是末尾数，如果依然大于Integer.MAX_VALUE的尾数，那么最后必然越界
            if (ans > Integer.MAX_VALUE / 10 || (ans == Integer.MAX_VALUE / 10 && temp > Integer.MAX_VALUE % 10)) {
                return Integer.MAX_VALUE;
            }
            if (ans < Integer.MIN_VALUE / 10 || (ans == Integer.MIN_VALUE/10 && temp < Integer.MIN_VALUE % 10)) {
                return Integer.MIN_VALUE;
            }
            // 要注意符号， 其中temp等于0 不会影响
            ans = ans * 10 + temp ;
        }
        return ans;
    }
}
