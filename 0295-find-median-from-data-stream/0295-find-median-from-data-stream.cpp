class MedianFinder {
public:
    MedianFinder() {}
    // using quickselect
    // void addNum(int num) { nums.push_back(num); }
    // double findMedian() {
    //     int n = nums.size();
    //     if (n % 2 == 1)
    //         return quickSelect(0, n - 1, n / 2);
    //     else
    //         return (quickSelect(0, n - 1, n / 2 - 1) +
    //                 quickSelect(0, n - 1, n / 2)) /
    //                2.0;
    // }
    // int quickSelect(int left, int right, int k) {
    //     if (left == right) {
    //         return nums[left];
    //     }
    //     int pivotIndex = left + rand() % (right - left + 1);
    //     pivotIndex = partition(left, right, pivotIndex);
    //     if (k == pivotIndex) {
    //         return nums[k];
    //     } else if (k < pivotIndex) {
    //         return quickSelect(left, pivotIndex - 1, k);
    //     } else {
    //         return quickSelect(pivotIndex + 1, right, k);
    //     }
    // }
    // int partition(int left, int right, int pivotIndex) {
    //     int pivotValue = nums[pivotIndex];
    //     swap(nums[pivotIndex], nums[right]);
    //     int storeIndex = left;

    //     for (int i = left; i < right; ++i) {
    //         if (nums[i] < pivotValue) {
    //             swap(nums[i], nums[storeIndex]);
    //             ++storeIndex;
    //         }
    //     }
    //     swap(nums[storeIndex], nums[right]);
    //     return storeIndex;
    // }
    // vector<int> nums;
    // using min amd max heap
     void addNum(int num) {
         if (lower.empty()) {
             lower.push(num);
             return;
         }
         if (lower.size() > higher.size()) {
             if (lower.top() > num) {
                 higher.push(lower.top());
                 lower.pop();
                 lower.push(num);
             } else
                 higher.push(num);
         } else {
             if (num > higher.top()) {
                 lower.push(higher.top());
                 higher.pop();
                 higher.push(num);
             } else
                 lower.push(num);
         }
     }

    double findMedian() {
        double result = 0.0;
        if (lower.size() == higher.size()) {
            result = lower.top() + (higher.top() - lower.top()) / 2.0;
        } else {
            if (lower.size() > higher.size())
                result = lower.top();
            else
                result = higher.top();
        }
        return result;
    }

    priority_queue<int> lower;
    priority_queue<int, vector<int>, greater<int>> higher;
};

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder* obj = new MedianFinder();
 * obj->addNum(num);
 * double param_2 = obj->findMedian();
 */