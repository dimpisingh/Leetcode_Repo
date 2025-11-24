class Solution {
    public List<Boolean> prefixesDivBy5(int[] nums) {
        int n = nums.length;
        List<Boolean> ans = new ArrayList<>();
        int res=nums[0], m=1;
        if(nums[0]%5==0){
            ans.add(true);
        }
        else ans.add(false);
        
        for(int i=1;i<n;i++){
            res = (res * 2 + nums[i]) % 5; 
            if(res%5==0){
            ans.add(true);
            }        
            else ans.add(false);
        }
        return ans;
        
    }
}