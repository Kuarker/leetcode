import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;

/**
 * @description:
 * @author: Kuarker Lee
 * @date: 2021/2/3
 **/
@Slf4j
public class MyTest {

    private static ConcurrentHashMap map= new ConcurrentHashMap<String,String>();


    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(10000);

        for (int i = 0; i < 10000; i++) {

            int finalI = i;
            Thread thread = new Thread(() -> {
//                countDownLatch.countDown();
                map.put("1", new StringBuilder('1').append(1));
                map.put("1", new StringBuilder('2').append(2));
                map.put("1", new StringBuilder('3').append(3));
                map.put("1", new StringBuilder('4').append(4));
                map.put("1", new StringBuilder('5').append(5));
                System.out.println(finalI);
            });
            thread.start();
            thread.join();
//
//            synchronized (MyTest.class){
//                thread.wait();
//            }
        }

//        countDownLatch.await();
        System.out.println(map.get("1").toString());


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
