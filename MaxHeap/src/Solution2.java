import java.util.TreeMap;
import java.util.PriorityQueue;
class Solution2 {
    private class Freq implements Comparable<Freq> {
        public int e, freq;

        public Freq(int e, int freq) {
            this.e = e;
            this.freq = freq;
        }

        @Override
        public int compareTo(Freq another) {
            if (this.freq < another.freq) {
                return -1;
            } else if (this.freq > another.freq) {
                return 1;
            } else {
                return 0;
            }
        }
    }

    public int[] topKFrequent(int[] nums, int k) {
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        for (int num : nums) {
            if (treeMap.containsKey(num)) {
                treeMap.put(num, treeMap.get(num) + 1);
            } else {
                treeMap.put(num, 1);
            }
        }

        PriorityQueue<Freq> priorityQueue = new PriorityQueue<>();
        for (int num : treeMap.keySet()) {
            if (priorityQueue.size() < k) {
                priorityQueue.add(new Freq(num, treeMap.get(num)));
            } else if (treeMap.get(num) > priorityQueue.peek().freq) {
                priorityQueue.remove();
                priorityQueue.add(new Freq(num, treeMap.get(num)));
            }
        }

        int[] res = new int[priorityQueue.size()];
        int i = 0;
        while (!priorityQueue.isEmpty()) {
            res[i++] = priorityQueue.remove().e;
        }
        return res;
    }
}
