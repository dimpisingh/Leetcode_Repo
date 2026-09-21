class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> merged = new ArrayList<>();
        int[] prev = intervals[0];
        for (int[] interval : intervals) {
            int st = interval[0];
            int end = interval[1];
            if (st <= prev[1]) {
                prev[1] = Math.max(prev[1], end);
            } else {
                merged.add(prev);
                prev = interval;
            }
        }
        merged.add(prev);
        return merged.toArray(new int[merged.size()][]);
    }
}