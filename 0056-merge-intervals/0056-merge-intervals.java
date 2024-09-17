class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        int a = intervals[0][0];
        int b = intervals[0][1];
        List<int[]> ans = new ArrayList<>();
        for (int i = 1; i < intervals.length; i++) {
            if (b >= intervals[i][0]) {
                b = Math.max(b, intervals[i][1]);
            } else {
                ans.add(new int[] { a, b });
                a = intervals[i][0];
                b = intervals[i][1];
            }
        }
        ans.add(new int[] { a, b });
        return ans.toArray(new int[ans.size()][]);
    }
}