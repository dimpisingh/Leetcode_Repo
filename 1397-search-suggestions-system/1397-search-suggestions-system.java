class Solution {
    // private int lowerBound(String[] products, String prefix, int start) {
    // int low = start, high = products.length;

    // while (low < high) {
    // int mid = (low + high) / 2;
    // if (products[mid].compareTo(prefix) < 0) {
    // low = mid + 1;
    // } else {
    // high = mid;
    // }
    // }

    // return low;
    // }

    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        // using sorting and binary search
        // Arrays.sort(products);
        // int n = products.length;
        // List<List<String>> ans = new ArrayList<>();
        // int bstart = 0;
        // String st = "";
        // for (char c : searchWord.toCharArray()) {
        // st += c;
        // int start = lowerBound(products, st, bstart);

        // List<String> suggestion = new ArrayList<>();
        // for (int i = start; i < Math.min(start + 3, n) && products[i].startsWith(st);
        // i++) {
        // suggestion.add(products[i]);
        // }

        // ans.add(suggestion); // Add the current suggestions to the result
        // bstart = start;
        // }
        // return ans;

        // using Trie
        TrieNode root = buildTrie(products);
        List<List<String>> ans = new ArrayList<>();
        for (int i = 0; i < searchWord.length(); i++) {
            ans.add(findTopThree(root, searchWord.substring(0, i + 1)));
        }
        return ans;
    }

    List<String> findTopThree(TrieNode root, String searchTerm) {
        List<String> res = new ArrayList<>();
        TrieNode node = root;
        for (char c : searchTerm.toCharArray()) {
            if (node.children[c - 'a'] == null) {
                return res;
            } else {
                node = node.children[c - 'a'];
            }
        }
        if (node.isWord)
            res.add(searchTerm);
        for (TrieNode child : node.children) {
            if (child != null) {
                List<String> thisRes = dfs(child, searchTerm, new ArrayList());
                res.addAll(thisRes);
                if (res.size() >= 3) {
                    return res.subList(0, 3);
                }
            }
        }
        return res;
    }

    private List<String> dfs(TrieNode root, String word, List<String> res) {
        if (root.isWord) {
            res.add(word + root.c);
            if (res.size() >= 3) {
                return res;
            }
        }
        for (TrieNode child : root.children) {
            if (child != null)
                dfs(child, word + root.c, res);
        }
        return res;
    }

    class TrieNode {
        char c;
        boolean isWord;
        TrieNode[] children;

        TrieNode(char c) {
            this.c = c;
            this.isWord = false;
            this.children = new TrieNode[26];
        }
    }

    private void insert(String product, TrieNode root) {
        TrieNode node = root;
        for (int i = 0; i < product.length(); i++) {
            char c = product.charAt(i);
            if (node.children[c - 'a'] == null) {
                node.children[c - 'a'] = new TrieNode(c);
            }
            node = node.children[c - 'a'];
        }
        node.isWord = true;
    }

    private TrieNode buildTrie(String[] products) {
        TrieNode root = new TrieNode(' ');
        for (String product : products) {
            insert(product, root);
        }
        return root;
    }
}
