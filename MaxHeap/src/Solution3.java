import java.util.Comparator;
import java.util.TreeMap;
import java.util.PriorityQueue;
class Solution3 {
    private class Freq {
        public int e, freq;

        public Freq(int e, int freq) {
            this.e = e;
            this.freq = freq;
        }
    }

    private class FreqComparator implements Comparator<Freq> {
        @Override
        public int compare(Freq a, Freq b) {
            return a.freq - b.freq;
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

        PriorityQueue<Freq> priorityQueue = new PriorityQueue<>(new FreqComparator());
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
