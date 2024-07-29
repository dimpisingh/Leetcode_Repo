/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
class Codec {
public:
    // Encodes a tree to a single string.
    string serialize(TreeNode* root) {
        vector<string> res;
        dfs(root, res);
        return join(res, ",");
    }

    // Decodes your encoded data to tree.
    TreeNode* deserialize(string data) {
        vector<string> vals = split(data, ',');
        int i = 0;
        return dfsDeserialize(vals, i);
    }

private:
    void dfs(TreeNode* root, vector<string>& res) {
        if (!root) {
            res.push_back("N");
            return;
        }
        res.push_back(to_string(root->val));
        dfs(root->left, res);
        dfs(root->right, res);
    }

    TreeNode* dfsDeserialize(vector<string>& data, int& i) {
        if (data[i] == "N") {
            i++;
            return NULL;
        }
        TreeNode* node = new TreeNode(stoi(data[i]));
        i++;
        node->left = dfsDeserialize(data, i);
        node->right = dfsDeserialize(data, i);
        return node;
    }
    vector<string> split(const string& s, char delim) {
        vector<string> elems;
        stringstream ss(s);
        string item;
        while (getline(ss, item, delim)) {
            elems.push_back(item);
        }
        return elems;
    }

    string join(const vector<string>& v, const string& delim) {
        ostringstream s;
        for (const auto& i : v) {
            if (&i != &v[0])
                s << delim;
            s << i;
        }
        return s.str();
    }
};

// Your Codec object will be instantiated and called as such:
// Codec ser, deser;
// TreeNode* ans = deser.deserialize(ser.serialize(root));