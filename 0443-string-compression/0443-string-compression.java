class Solution {
    public int compress(char[] chars) {
        int ans = 0;

        int n = chars.length;

        for (int i = 0; i < n; i++) {
            char ch = chars[i];
            int count = 0;

            while (i < n && chars[i] == ch) {
                count++;
                i++;
            }

            chars[ans++] = ch;
            if (count != 1)
                for (char c : Integer.toString(count).toCharArray())
                    chars[ans++] = c;

            i--;
        }
        return ans;

    }
}