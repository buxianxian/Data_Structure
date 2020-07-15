import java.util.Random;

public class Main {

    //测试使用queue运行opCount个enqueue和dequeue操作所需要的时间，单位：秒
    private static double testQueue(Queue<Integer> queue, int opCount) {
        long start = System.nanoTime();
        Random random = new Random();
        for (int i = 0; i < opCount; i++) {
            queue.enqueue(random.nextInt(Integer.MAX_VALUE)); //产生随机数范围0-Integer.Max_Value
        }
        for (int i = 0; i < opCount; i++) {
            queue.dequeue();
        }
        long end = System.nanoTime();
        //nanoTime的时间单位是纳秒
        return (end - start) / 10_0000_0000.0;
    }

    public static void main(String[] args) {
        int opCount = 10_0000;
        /*ArrayQueue<Integer> arrayQueue = new ArrayQueue<>();
        double time1 = testQueue(arrayQueue, opCount);
        System.out.println("ArrayQueue, time: " + time1 + "s");*/

        LoopQueue<Integer> loopQueue = new LoopQueue<>();
        double time2 = testQueue(loopQueue, opCount);
        System.out.println("LoopQueue, time: " + time2 + "s");

        LinkedListQueue<Integer> linkedListQueue = new LinkedListQueue<>();
        double time3 = testQueue(linkedListQueue, opCount);
        System.out.println("LinkedListQueue, time: " + time3 + "s");
    }
}
