class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        Map<String, String> d = new HashMap<>();
        for (var k : knowledge)
            d.put(k.get(0), k.get(1));

        StringBuilder ans = new StringBuilder();
         for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                int j = s.indexOf(")", i + 1);
                ans.append(d.getOrDefault(s.substring(i + 1, j), "?"));
                i = j;
            }else{
                ans.append(s.charAt(i));
            }
    }
    return ans.toString();
    }
}