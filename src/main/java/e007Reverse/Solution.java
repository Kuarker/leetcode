package e007Reverse;

/**
 * @description:
 * @author: Kuarker Lee
 * @date: 2021/2/4
 **/
public class Solution {
    public static void main(String[] args) {
        // 2^31-1=2147483647,-2^31=-2147483648
        int x=12345;
        System.out.println(reverse(x));

    }
    public static int reverse(int x) {

        long ans=0;

        while (x!=0){
            ans=ans*10+x%10;
            x=x/10;
        }
        int temp= (int) ans;
        return temp==ans? (int) ans :0;



    }
}
