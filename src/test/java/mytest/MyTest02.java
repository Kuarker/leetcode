package mytest;

/**
 * @description: Vm参数-Xmx5120m -Xms5120m -Xmn5120m
 * @author: Kuarker Lee
 * @date: 2021/3/7
 **/
public class MyTest02 {


    public static void main(String[] args) {

//        int[][] times = {{1,2},{1,3},{4,3}};
                        //  2      5   20    8
        int[][] times = {{1,2},{3,3},{6,3},{9,3}};

        System.out.println(avgTime(times));

    }

    public static double avgTime(int[][] times){
        // 开始排队时刻
        int run =times[0][0];
        // 总顾客数
        int total =times.length;
        int totalTime=0;
        for (int[] ints : times) {
            int wait=0;
            if (ints[0]>=run){
                // 不需要等待前面的顾客
                wait=ints[1];
                totalTime=wait+totalTime;
                // 开始制作时刻
                run=ints[0];
            }else {
                // 已经等待的时间+奶茶制作时间
                // 开始制作该顾客奶茶的时刻
                wait=run-ints[0]+ints[1];
                totalTime=wait+totalTime;
            }
            // 可以开始下一杯奶茶制作的时刻
            run=run+ints[1];
        }
        double avg=totalTime*1.0/total;
        return avg;
    }

}
