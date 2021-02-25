package e020IsValid;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @description:
 * @author: Kuarker Lee
 * @date: 2021/2/14
 **/
public class Solution {
    public static void main(String[] args) {
        String s = "()(){}[{}]";
        boolean valid = isValid(s);
    }

    public static boolean isValid(String s) {
        if (s == null || s.isEmpty() || s.length() % 2 != 0) {
            return false;
        }
        Map<Character, Character> map = new HashMap<Character, Character>() {{
            put('(', ')');
            put('{', '}');
            put('[', ']');
        }};
        Deque<Character> deque = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (map.containsKey(c)) {
                deque.push(c);
            } else {
                if (deque.isEmpty()||(char)map.get(deque.peek())!=(c)){
                    return false;
                }
                deque.pop();

            }

        }
        return deque.isEmpty();
    }
}
