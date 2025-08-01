
#include <cmath>
#include <deque>
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

public:
    vector<int> closestKValues(TreeNode* root, double targetValue, int targetNumberOfNodes) const {
        deque<int> queue;
        inOrderSearch(root, targetValue, targetNumberOfNodes, queue);
        return vector<int>(queue.begin(), queue.end());
    }

private:
    void inOrderSearch(TreeNode* root, double targetValue, int targetNumberOfNodes, deque<int>& queue) const {
        if (root == nullptr) {
            return;
        }
        inOrderSearch(root->left, targetValue, targetNumberOfNodes, queue);
        updateQueue(root, targetValue, targetNumberOfNodes, queue);
        inOrderSearch(root->right, targetValue, targetNumberOfNodes, queue);
    }

    void updateQueue(TreeNode* root, double targetValue, int targetNumberOfNodes, deque<int>& queue) const {
        queue.push_back(root->val);
        if (queue.size() <= targetNumberOfNodes) {
            return;
        }
        if (abs(queue.front() - targetValue) > abs(queue.back() - targetValue)) {
            queue.pop_front();
            return;
        }
        queue.pop_back();
    }
};
