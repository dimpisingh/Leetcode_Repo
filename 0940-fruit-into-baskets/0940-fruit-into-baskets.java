class Solution {
    public int totalFruit(int[] fruits) {
        int left = 0, right = 0, mx = 0;
        HashMap<Integer, Integer> mp = new HashMap<>();
        while (right < fruits.length) {
            mp.put(fruits[right], mp.getOrDefault(fruits[right], 0) + 1);
            while (mp.size() >= 3) {
                mp.put(fruits[left], mp.get(fruits[left]) - 1);
                if (mp.get(fruits[left]) == 0)
                    mp.remove(fruits[left]);
                left++;

            }
            int currlen = right - left + 1;
            mx = Math.max(mx, currlen);
            right++;
        }
        return mx;
    }
}