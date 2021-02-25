package e013RomanToInt;

/**
 * @description:
 * @author: Kuarker Lee
 * @date: 2021/2/6
 **/
public class Solution {

    public static void main(String[] args) {
        String iv = "IV";
        System.out.println(romanToInt(iv));
    }

    public static int romanToInt(String s) {
        int length = s.length();
        // 没有 IIV =3
        int pre = getValue(s.charAt(0));
        int num = 0;
        int sum = 0;
        //s 只有一个字符时，不会进入循环里，所以不会数组越界
        for (int i = 1; i < length; i++) {
            num = getValue(s.charAt(i));
            if (pre < num) {
                sum -= pre;
            } else {
                sum += pre;
            }
            pre = num;
        }
        sum += pre;
        return sum;

    }

    private static int getValue(char c) {
        //('I', 'V', 'X', 'L', 'C', 'D', 'M')
        switch (c) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return 0;

        }


    }
}
