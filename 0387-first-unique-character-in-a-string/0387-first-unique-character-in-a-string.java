class Solution {
    public int firstUniqChar(String s) {
        int ans = -1;
        // for (char c : s.toCharArray()) {
        // if (s.indexOf(c) == s.lastIndexOf(c)) {

        // return s.indexOf(c);
        // }
        // }

        int a[] = new int[26];
        for (int i = 0; i < s.length(); i++) {
            a[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            if (a[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }
        return ans;
    }

}