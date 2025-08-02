
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
        deque<int> deque;
        inOrderSearch(root, targetValue, targetNumberOfNodes, deque);
        return vector<int>(deque.begin(), deque.end());
    }

private:
    void inOrderSearch(TreeNode* root, double targetValue, int targetNumberOfNodes, deque<int>& deque) const {
        if (root == nullptr) {
            return;
        }
        inOrderSearch(root->left, targetValue, targetNumberOfNodes, deque);
        updateDeque(root, targetValue, targetNumberOfNodes, deque);
        inOrderSearch(root->right, targetValue, targetNumberOfNodes, deque);
    }

    void updateDeque(TreeNode* root, double targetValue, int targetNumberOfNodes, deque<int>& deque) const {
        deque.push_back(root->val);
        if (deque.size() <= targetNumberOfNodes) {
            return;
        }
        if (abs(deque.front() - targetValue) > abs(deque.back() - targetValue)) {
            deque.pop_front();
            return;
        }
        deque.pop_back();
    }
};
