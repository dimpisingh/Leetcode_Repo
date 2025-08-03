class Solution {
    public boolean isValid(String p) {
        Stack<Character> st = new Stack<>();
        char c = ' ';
        char[] s = p.toCharArray();
        for (int i = 0; i < s.length; i++) {

            if (s[i] == '{' || s[i] == '(' || s[i] == '[') {
                st.push(s[i]);
            }

            else {
                if (st.isEmpty())
                    return false;
                c = st.peek();
                if ((c == '{' && s[i] == '}') || (c == '(' && s[i] == ')') || (c == '[' && s[i] == ']')) {
                    st.pop();
                } else {
                    return false; // mismatched pair
                }
            }
        }
        return st.isEmpty();
    }
}