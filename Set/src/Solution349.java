import java.util.ArrayList;
import java.util.TreeSet;

public class Solution349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        TreeSet<Integer> treeSet = new TreeSet<>();
        for (int num: nums1) {
            treeSet.add(num);
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int num: nums2) {
            if (treeSet.contains(num)) {
                arrayList.add(num);
                treeSet.remove(num);
            }
        }
        int[] res = new int[arrayList.size()];
        for (int i = 0; i < arrayList.size(); i++) {
            res[i] = arrayList.get(i);
        }
        return res;
    }
}
