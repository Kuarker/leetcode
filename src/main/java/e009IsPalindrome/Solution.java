package e009IsPalindrome;

/**
 * @description:
 * @author: Kuarker Lee
 * @date: 2021/2/4
 **/
public class Solution {
    private String nnn="jjjj";

    public static void main(String[] args) {


        boolean palindrome = isPalindrome(12344321);
        System.out.println(palindrome);
    }

    public static  boolean isPalindrome(int x) {
        // 分开写判断条件，性能差异竟然有这么大
        if (x==0) return true;
        if (x < 0) {
            return false;
        }
        if(x%10==0){
            return false;
        }
        int temp2 = 0;
        while (x > temp2) {
            temp2 = temp2 * 10 + x % 10;
            x /= 10;
        }
        return temp2 == x||x==temp2/10;

    }
    class MyTest{
        public void test(){

            Solution solution = new Solution();
            System.out.println(solution.nnn);
        }
    }
}
