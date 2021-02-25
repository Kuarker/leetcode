package m012IntToRoman;

/**
 * @description:
 * @author: Kuarker Lee
 * @date: 2021/2/6
 **/
public class Solution {
    public static void main(String[] args) {
        int num=111111;
        System.out.println(intToRoman(num));
    }

    static int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    static String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

    public static String intToRoman(int num) {
        int length = values.length;
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i <length&&num>0; i++) {
            // 从左侧开始工作。因此，使用贪心算法是有意义的。
            // 贪心算法是一种在当前时间做出最佳可能决策的算法；
            // 在这种情况下，它会取出最大可能的符号
            while (num>=values[i]){
                num-=values[i];
                builder.append(symbols[i]);
            }
        }
        return builder.toString();
    }
}
