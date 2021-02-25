package m22GenerateParenthesis;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @description: https://leetcode-cn.com/problems/generate-parentheses/
 * @author: Kuarker Lee
 * @date: 2021/2/14
 **/
class Solution {
    public static void main(String[] args) {
        List<String> strings = generateParenthesis(5);
    }
    public static List<String> generateParenthesis(int n) {
        if (n==0){
            return Collections.emptyList();
        }
        List<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        dfs(sb, 0, 0, n, list);
        return list;

    }

    static void dfs(StringBuilder sb, int left, int right, int num, List<String> strings) {
        if (left == num && right == num) {
            strings.add(sb.toString());
            return;
        }

        if (left <num&&left>=right) {
            sb.append("(");
            dfs(sb, left + 1, right, num, strings);
            // 要深度遍历，所以回溯的时候，需要删除，不能影响后续
            sb.deleteCharAt(left + right);
        }
        if (right <num&&left>=right) {
            sb.append(")");
            dfs(sb, left, right + 1, num, strings);
            sb.deleteCharAt(left + right);
        }

    }
}