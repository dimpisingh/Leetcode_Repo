class Solution {
public:
    bool canPlaceFlowers(vector<int>& flowerbed, int n) {
     int n1 = flowerbed.size();
        if (n1 == 1) {
            if ((n == 1 && flowerbed[0] == 0) || n == 0) {
                return true;
            } else {
                return false;
            }
        }
        for (int i = 0; i < n1; i++) {
            if(i==0){
            if (flowerbed[i] == 0 && flowerbed[i + 1] == 0 && i == 0) {
                n--;
                flowerbed[i] = 1;
            }
            }  
            if(i==n1-1)
            {if (flowerbed[i] == 0 && i == n1 - 1 &&
                       flowerbed[i - 1] == 0) {
                n--;
                flowerbed[i] = 1;
            }
            }
            if (i > 0 and i < n1 - 1) {
                if (flowerbed[i] == 0 && flowerbed[i + 1] == 0 &&
                    flowerbed[i - 1] == 0) {
                    n--;
                    flowerbed[i] = 1;
                }
            }

            if (n <= 0) {
                return true;
            }
        }
        return false;   
    }
};