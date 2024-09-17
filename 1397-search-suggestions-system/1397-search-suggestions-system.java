class Solution {
    private int lowerBound(String[] products, String prefix, int start) {
        int low = start, high = products.length;

        while (low < high) {
            int mid = (low + high) / 2;
            if (products[mid].compareTo(prefix) < 0) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return low;
    }

    public List<List<String>> suggestedProducts(String[] products, String searchWord) {

        Arrays.sort(products);
        int n = products.length;
        List<List<String>> ans = new ArrayList<>();
        int bstart = 0;
        String st = "";
        for (char c : searchWord.toCharArray()) {
            st += c;
            int start = lowerBound(products, st, bstart);

            List<String> suggestion = new ArrayList<>();
            for (int i = start; i < Math.min(start + 3, n) && products[i].startsWith(st); i++) {
                suggestion.add(products[i]);
            }

            ans.add(suggestion); // Add the current suggestions to the result
            bstart = start;
        }
        return ans;
    }

}