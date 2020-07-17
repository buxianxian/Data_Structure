import java.util.ArrayList;
import java.util.TreeMap;

public class Solution350 {
    public int[] intersect(int[] nums1, int[] nums2) {
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        for (int num: nums1) {
            if (!treeMap.containsKey(num)) {
                treeMap.put(num, 1);
            } else {
                treeMap.put(num, treeMap.get(num) + 1);
            }
        }

        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int num: nums2) {
            if (treeMap.containsKey(num)) {
                arrayList.add(num);
                treeMap.put(num, treeMap.get(num) - 1);
                if (treeMap.get(num) == 0) {
                    treeMap.remove(num);
                }
            }
        }

        int[] res = new int[arrayList.size()];
        for (int i = 0; i < arrayList.size(); i++) {
            res[i] = arrayList.get(i);
        }
        return res;
    }
}
