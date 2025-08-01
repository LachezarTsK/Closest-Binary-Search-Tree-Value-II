
#include <cmath>
#include <vector>
using namespace std;

/*
Struct TreeNode is inbuilt in the solution file on leetcode.com.
When running the code on the website, do not include this struct.
 */
struct TreeNode {
    int val;
    TreeNode* left;
    TreeNode* right;

    TreeNode() : val(0), left(nullptr), right(nullptr) {}
    TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
    TreeNode(int x, TreeNode* left, TreeNode* right) : val(x), left(left), right(right) {}
};


class Solution {

    int front = 0;
    vector<int> queue;

public:
    vector<int> closestKValues(TreeNode* root, double targetValue, int targetNumberOfNodes) {
        inOrderSearch(root, targetValue, targetNumberOfNodes);
        return vector<int>(queue.begin() + front, queue.end());
    }

private:
    void inOrderSearch(TreeNode* root, double targetValue, int targetNumberOfNodes) {
        if (root == nullptr) {
            return;
        }
        inOrderSearch(root->left, targetValue, targetNumberOfNodes);
        updateQueue(root, targetValue, targetNumberOfNodes);
        inOrderSearch(root->right, targetValue, targetNumberOfNodes);
    }

    void updateQueue(TreeNode* root, double targetValue, int targetNumberOfNodes) {
        queue.push_back(root->val);
        if (queue.size() <= targetNumberOfNodes) {
            return;
        }
        if (abs(queue[front] - targetValue) > abs(queue.back() - targetValue)) {
            ++front;
            return;
        }
        queue.pop_back();
    }
};
