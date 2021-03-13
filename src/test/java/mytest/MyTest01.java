package mytest;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: Vm参数-Xmx5120m -Xms5120m -Xmn5120m
 * @author: Kuarker Lee
 * @date: 2021/3/7
 **/
public class MyTest01 {



    private static Map<String, byte[]> staticMap =new HashMap<>();

    public static void main(String[] args) {

        for (int i = 0; i < 100; i++) {
            // 1 gb
            byte[] bytes = new byte[1024 * 1024 * 1024];
            staticMap.put(String.valueOf(i),bytes);
            bytes=null;
            if ((i%3)==0){
                System.out.println("========");
                staticMap.clear();
//                System.gc();
            }

        }

    }


}
