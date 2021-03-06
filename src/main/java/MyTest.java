import lombok.extern.slf4j.Slf4j;

/**
 * @description:
 * @author: Kuarker Lee
 * @date: 2021/2/3
 **/
@Slf4j
public class MyTest {


    public static void main(String[] args) {
        System.out.println(strTranslateToInt("39k9270"));
        System.out.println();
//
//
//        MyTest myTest = new MyTest();
//        myTest.go(10);
//
////        for (int i = 0; i < 10; i++) {
////            int j=(i+2);
////            int k=j>>1;
////            int m=(i+12)/2;
////
////            int n=i+(12-i)/2;
////            System.out.println("i: "+i+" "+"j: "+j+" k: "+k);
////        }
//    }
//    public void  go(int i){
//        if (i==0) return;
//        System.out.println(i);
//        MyTest.this.go(--i);
    }

    public static int strTranslateToInt(String str){
        char zero='0';
        char nine='9';
        int ans=0;
        for (int i = 0; i < str.length(); i++) {

            char temp=str.charAt(i);
            if (temp>nine||temp<zero){
                break;
            }
            int num = temp - zero;
            ans=ans*10+num;
        }
        return ans;
    }

}
