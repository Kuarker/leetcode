package m017LetterCombinations;

import java.util.*;

/**
 * @description:
 * @author: Kuarker Lee
 * @date: 2021/2/11
 **/
class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        String nums="";
        solution.letterCombinations(nums);
    }

    public List<String> letterCombinations(String ds) {
        if (ds==null||ds.length()==0){
            return Collections.emptyList();
        }

        Map<String, String[]> map = new HashMap<String, String[]>(){{
            put("2", new String[]{"a", "b", "c"});
            put("3", new String[]{"d", "e", "f"});
            put("4", new String[]{"g", "h", "i"});
            put("5", new String[]{"j", "k", "l"});
            put("6", new String[]{"m", "n", "o"});
            put("7", new String[]{"p", "q", "r", "s"});
            put("8", new String[]{"t", "u", "v"});
            put("9", new String[]{"w", "x", "y", "z"});
        }};
        int length = ds.length();
        ArrayList<String> ans = new ArrayList<>();
        dfs(ds,0,length,new StringBuilder(),ans,map);
        return ans;
    }
    void dfs(String ds, int index, int length, StringBuilder sb, List<String> ans,Map<String, String[]> map) {

        if (index==length){
            // 调用了这个不代表这个对象就结束，只是调用一个方法，返回了String而已，sb对象依然可以继续使用
            ans.add(sb.toString());
            return;
        }
        String key=ds.substring(index,index+1);
        String[] strings = map.get(key);
        for (String string : strings) {
            sb.append(string);
            dfs(ds,index+1,length,sb,ans,map);
            // 删除sb.append(string)放进去的string
            sb.deleteCharAt(index);
        }
    }

}

