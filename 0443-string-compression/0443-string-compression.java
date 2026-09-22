class Solution {
    public int compress(char[] chars) {
        int ans = 0;
        int k = 0;
        for (int i = 0; i < chars.length; i++) {
            int cnt = 0;
            char ch = chars[i];
            while (i < chars.length && chars[i] == ch) {
                cnt++;
                i++;
            }
            chars[k++] = ch;
            if (cnt != 1)

                for (char c : Integer.toString(cnt).toCharArray())
                    chars[k++] = c;
            i--;

        }
        return k;

    }
}