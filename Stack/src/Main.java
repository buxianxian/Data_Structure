import java.util.Random;

public class Main {

    //测试使用queue运行opCount个enqueue和dequeue操作所需要的时间，单位：秒
    private static double testQueue(Stack<Integer> stack, int opCount) {
        long start = System.nanoTime();
        Random random = new Random();
        for (int i = 0; i < opCount; i++) {
            stack.push(random.nextInt(Integer.MAX_VALUE)); //产生随机数范围0-Integer.Max_Value
        }
        for (int i = 0; i < opCount; i++) {
            stack.pop();
        }
        long end = System.nanoTime();
        //nanoTime的时间单位是纳秒
        return (end - start) / 10_0000_0000.0;
    }

    public static void main(String[] args) {
        int opCount = 100_00000;
        ArrayStack<Integer> arrayStack = new ArrayStack<>();
        double time1 = testQueue(arrayStack, opCount);
        System.out.println("ArrayStack, time: " + time1 + "s");
        LinkedListStack<Integer> linkedListStack = new LinkedListStack<>();
        double time2 = testQueue(linkedListStack, opCount);
        System.out.println("LinkedListStack, time: " + time2 + "s");

        //其实这个时间复杂的比较复杂，因为LinkedListStack包含更多new操作
    }
}