class Solution {
    public void sortColors(int[] nums) {
        int low = 0, mid = 0, high = nums.length - 1;
        int n = nums.length;
        int k = 0, m = n - 1;
        while (mid <= high) {
            if (nums[mid] == 0) {
                int tmp = nums[low];
                nums[low] = nums[mid];
                nums[mid] = tmp;
                low++;
                mid++;

            }
            else if (nums[mid] == 2) {
                int tmp = nums[high];
                nums[high] = nums[mid];
                nums[mid] = tmp;
                high--;
            } else {
                mid++;
            }
        }
    }
}