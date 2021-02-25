package m006Zconvert;

/**
 * @description:
 * @author: Kuarker Lee
 * @date: 2021/2/4
 **/
public class Solution {

    public static void main(String[] args) {
        String s = "PAYPALISHIRING";
        int numRows = 4;
        String convert = convert(s, numRows);
        System.out.println(convert);
        System.out.println("PINALSIGYAHRPI");

    }

    public static String convert(String s, int numRows) {

        int length = s.length();

        if (numRows == 1 || length <= numRows) {
            return s;
        }
        StringBuilder string = new StringBuilder();
        int cycleLen = 2 * numRows - 2;
        for (int i = 0; i < numRows; i++) {
            // j+i < length 是因为防止 s.charAt(j+i)越界
            for (int j = 0; j + i < length; j += cycleLen) {
                string.append(s.charAt(j + i));
                // 排除第一行和最后一行，所以从第二个周期开始，此时j>=cycleLen,加一个周期再减去行数i就是字符的位置
                if (i != 0 && i != numRows - 1 && j - i + cycleLen < length) {
                    // 周期运算
                    string.append(s.charAt(j + cycleLen - i));
                }
            }
        }
        return string.toString();


    }
}
