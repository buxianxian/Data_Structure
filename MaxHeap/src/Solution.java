import java.util.TreeMap;

class Solution {
    private class Freq implements Comparable<Freq> {
        public int e, freq;

        public Freq(int e, int freq) {
            this.e = e;
            this.freq = freq;
        }

        @Override
        public int compareTo(Freq another) {
            if (this.freq < another.freq) {
                return 1;
            } else if (this.freq > another.freq) {
                return -1;
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
            if (priorityQueue.getSize() < k) {
                priorityQueue.enqueue(new Freq(num, treeMap.get(num)));
            } else if (treeMap.get(num) > priorityQueue.getFront().freq) {
                priorityQueue.dequeue();
                priorityQueue.enqueue(new Freq(num, treeMap.get(num)));
            }
        }

        int[] res = new int[priorityQueue.getSize()];
        int i = 0;
        while (!priorityQueue.isEmpty()) {
            res[i++] = priorityQueue.dequeue().e;
        }
        return res;
    }
}
