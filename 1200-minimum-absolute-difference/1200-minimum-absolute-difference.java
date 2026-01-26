class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
       int OFFSET = 1_000_000;
       int RANGE = 2_000_001;
       boolean[] present = new boolean[RANGE];
       for(int num: arr){
        present[num+OFFSET] = true;
       }
       List<List<Integer>> result = new ArrayList<>();
       int prev = -1;
       int minDiff = Integer.MAX_VALUE;
       for(int i=0;i<RANGE; i++){
        if(present[i]){
            int curr = i-OFFSET;
            if(prev !=-1){
                int diff = curr-prev;
                if(diff < minDiff){
                    minDiff = diff;
                    result.clear();
                    result.add(Arrays.asList(prev,curr));
                }
                else if(diff==minDiff){
                    result.add(Arrays.asList(prev,curr));
                }
            }
            prev = curr;
        }
       }
       return result;
    }
}