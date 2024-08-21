class Solution {
public:
    bool circularArrayLoop(vector<int>& nums) {
        int n = nums.size(); // size of nums
        for (int i = 0; i < n; i++) {
            if (nums[i] >
                -10000) { // we are giving value to index which we are visiting
                          // and value will be less than equal to -10000
                int ind = i, val = -10000 - i, pos = nums[i] / abs(nums[i]),
                    count = 0; // ind is starting index .... val which we be
                               // giving now .... pos be its negative or
                               // positive  // count to find out self loop
                while (nums[ind] >
                       -9999) { // if value is less than -9999 means already
                                // visited there for no need to visit
                    if (pos * nums[ind] < 0)
                        break; // checking if it have same sign number or not if
                               // not then there is no need to check loop
                    int pos =
                        ((nums[ind] + ind) % n + n) %
                        n; // pos of next pointer the ind index is pointing
                    nums[ind] = val; // we will give it specific value so we can
                                     // recognize if it is visited in this loop
                                     // or previous
                    if (ind == pos)
                        count = 1; // for self loop .. it is to check if node is
                                   // pointing in itself
                    ind = pos;     // if not self loop then next node
                }
                if (nums[ind] == val && count != 1)
                    return true; // if the next node is visited in this  loop
                                 // means we visited this in this loop and we
                                 // check if it contain self loop if not return
                                 // true
            }
        }
        return false; // if no loop found
    }
};