import lombok.extern.slf4j.Slf4j;

/**
 * @description:
 * @author: Kuarker Lee
 * @date: 2021/2/3
 **/
@Slf4j
public class MyTest {


    public static void main(String[] args) {

        for (int i = 0; i < 10; i++) {
            int j=(i+2);
            int k=j>>1;
            int m=(i+12)/2;

            int n=i+(12-i)/2;
            System.out.println("i: "+i+" "+"j: "+j+" k: "+k);
        }
    }
}
