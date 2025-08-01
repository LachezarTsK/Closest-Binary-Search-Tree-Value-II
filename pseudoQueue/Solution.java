
import java.util.ArrayList;
import java.util.List;

public class Solution {

    private int front;
    private List<Integer> queue = new ArrayList<>();

    public List<Integer> closestKValues(TreeNode root, double targetValue, int targetNumberOfNodes) {
        inOrderSearch(root, targetValue, targetNumberOfNodes);
        return queue.subList(front, queue.size());
    }

    private void inOrderSearch(TreeNode root, double targetValue, int targetNumberOfNodes) {
        if (root == null) {
            return;
        }
        inOrderSearch(root.left, targetValue, targetNumberOfNodes);
        updateQueue(root, targetValue, targetNumberOfNodes);
        inOrderSearch(root.right, targetValue, targetNumberOfNodes);
    }

    private void updateQueue(TreeNode root, double targetValue, int targetNumberOfNodes) {
        queue.add(root.val);
        if (queue.size() <= targetNumberOfNodes) {
            return;
        }
        if (Math.abs(queue.get(front) - targetValue) > Math.abs(queue.getLast() - targetValue)) {
            ++front;
            return;
        }
        queue.removeLast();
    }
}

/*
Class TreeNode is inbuilt in the solution file on leetcode.com. 
When running the code on the website, do not include this class.
 */
class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
