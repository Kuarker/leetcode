package m040CombinationSum2;

import java.util.*;

/**
 * @description:
 * @author: Kuarker Lee
 * @date: 2021/3/6
 **/
public class Solution {

    public static void main(String[] args) {


        int[] can={2,3,4,4,6,8,9,9,9,10,3,4,6,7,8,4,5,1,1,2,3};
        List<List<Integer>> lists = combinationSum2(can, 18);
        lists.forEach(ele->{
            ele.forEach(e->{
                System.out.printf(e.toString());
            });
            System.out.println();
        });
    }
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {

        final Set<List<Integer>> ans = new HashSet<>();
        // 先排序
        Arrays.sort(candidates);
        List<Integer> temp =new ArrayList<>();
        dfs(candidates,target,0,temp,ans);
        return new ArrayList<>(ans);
    }

    public static void dfs(int[] candidates,int target,int index,List<Integer> temp,Set<List<Integer>> ans ){

        if (target==0){
            // 一定要重新new 一个对象，不然重复使用堆里的List会出错
            ans.add(new ArrayList<>(temp));
        }

        if (index>=candidates.length||target<0) return;
        // 使用candidates[index]
        temp.add(candidates[index]);
        dfs(candidates,target-candidates[index],index+1,temp,ans);

        // 不使用candidates[index]
        temp.remove(temp.size()-1);
        dfs(candidates,target,index+1,temp,ans);
    }



}
