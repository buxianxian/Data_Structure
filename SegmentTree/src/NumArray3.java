public class NumArray3 {
    private SegmentTree<Integer> segmentTree;

    public NumArray3(int[] nums) {
        if (nums.length > 0) {
            Integer[] data = new Integer[nums.length];
            for (int i = 0; i < data.length; i++) {
                data[i] = nums[i];
            }
            segmentTree = new SegmentTree<>(data, new Merger<Integer>() {
                @Override
                public Integer merge(Integer a, Integer b) {
                    return a + b;
                }
            });
        }
    }

    public void update(int index, int val) {
        if (segmentTree == null) {
            throw new IllegalArgumentException("Segment Tree is null");
        }
        segmentTree.set(index, val);
    }

    public int sumRange(int i, int j) {
        if (segmentTree == null) {
            throw new IllegalArgumentException("Segment Tree is null");
        }
        return segmentTree.query(i, j);
    }
}
