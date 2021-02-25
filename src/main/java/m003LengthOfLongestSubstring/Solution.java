package m003LengthOfLongestSubstring;

import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @author: Kuarker Lee
 * @date: 2021/2/3
 **/
public class Solution {

    public static void main(String[] args) {
        String s = "kckcmkkk";
        System.out.println(lengthOfLongestSubstring(s));
    }

    public static int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        int length = s.length();

        int start = -1;
        int end = 0;
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for (; end < length; end++) {
            char c = s.charAt(end);
            if (map.containsKey(c)) {
                start = Math.max(start, map.get(c));
            }
            maxLength = Math.max(maxLength, end - start );
            map.put(c, end);
        }
        return maxLength;
    }
}
