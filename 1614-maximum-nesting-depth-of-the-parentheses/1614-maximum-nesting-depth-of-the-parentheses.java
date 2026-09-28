class Solution {
    public int maxDepth(String s) {
        Stack<Character> st = new Stack<>();
        int mx = 0;
        for(char c : s.toCharArray()){
            if(c=='(') st.push('(');
            else if(c==')') {
                mx = Math.max(mx, st.size());
                st.pop();
            }
        }
        return mx;
    }
}