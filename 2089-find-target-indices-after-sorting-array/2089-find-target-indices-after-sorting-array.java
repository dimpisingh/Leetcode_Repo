class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        
        List<Integer> ans = new ArrayList<>();
        int i =0, j=0; 
        for(int x:nums){
            if(x<target) i++;
            else if(x==target) j++;
        }
        for(int k =0; k<j; k++){
            ans.add(k+i);
        }
        return ans;
    }
}