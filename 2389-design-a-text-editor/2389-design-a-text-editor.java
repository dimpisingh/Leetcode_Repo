class TextEditor {
    Stack<Character> left = new Stack<>();
    Stack<Character> right = new Stack<>();

    public TextEditor() {

    }

    public void addText(String text) {
        for (int i = 0; i < text.length(); i++) {
            left.add(text.charAt(i));
        }

    }

    public int deleteText(int k) {
        int cnt = 0;
        while (left.size() != 0 && k != 0) {
            left.pop();
            k--;
            cnt++;
        }
        return cnt;
    }

    public String cursorLeft(int k) {
        while (left.size() != 0 && k != 0) {
            char p = left.peek();
            left.pop();
            right.add(p);
            k--;
        }
        return kLeft();
    }

    public String cursorRight(int k) {
        while (right.size() != 0 && k != 0) {
            char p = right.peek();
            right.pop();
            left.add(p);
            k--;
        }
        return kLeft();
    }

    String kLeft() {
        int s = left.size();
        int cnt = Math.min(10, s);
        StringBuilder ans = new StringBuilder();
        // Iterator<Character> iterator = left.iterator();
        // while (s > cnt) {
        //     iterator.next();
        //     s--;
        // }
        // while (cnt > 0) {
        //     ans.append(iterator.next());
        //     cnt--;
        // }
        for(int i = s-cnt;i<left.size();i++){
            ans.append(left.get(i));
        }
        return ans.toString();
    }

    // optimized solution
    // StringBuffer sb = new StringBuffer();
    // int cursor = 0;
    // public TextEditor() {
    //     sb = new StringBuffer();
    //     cursor = 0;
    // }
    // public void addText(String text) {
    //     sb.insert(cursor, text);
    //     cursor=cursor+text.length();
    // }
    // public int deleteText(int k) {
    //     int old = cursor;
    //     sb.delete(Math.max(0,cursor-k),cursor);
    //     cursor = Math.max(0,cursor-k);
    //     return old-cursor;
    // }
    // public String cursorLeft(int k) {
    //     cursor = Math.max(0,cursor-k);
    //     return getLast10Characters();
    // }
    
    // public String cursorRight(int k) {

    //     cursor = Math.min(sb.length(), cursor+k);
    //     return getLast10Characters();
    // }
    // String getLast10Characters(){
    //     int start = Math.max(0, cursor-10);
    //     return sb.substring(start, cursor);
    // }
    
}

/**
 * Your TextEditor object will be instantiated and called as such:
 * TextEditor obj = new TextEditor();
 * obj.addText(text);
 * int param_2 = obj.deleteText(k);
 * String param_3 = obj.cursorLeft(k);
 * String param_4 = obj.cursorRight(k);
 */