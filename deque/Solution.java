
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<Integer> closestKValues(TreeNode root, double targetValue, int targetNumberOfNodes) {
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        inOrderSearch(root, targetValue, targetNumberOfNodes, queue);
        return new ArrayList<>(queue);
    }

    private void inOrderSearch(TreeNode root, double targetValue, int targetNumberOfNodes, ArrayDeque<Integer> queue) {
        if (root == null) {
            return;
        }
        inOrderSearch(root.left, targetValue, targetNumberOfNodes, queue);
        updateQueue(root, targetValue, targetNumberOfNodes, queue);
        inOrderSearch(root.right, targetValue, targetNumberOfNodes, queue);
    }

    private void updateQueue(TreeNode root, double targetValue, int targetNumberOfNodes, ArrayDeque<Integer> queue) {
        queue.add(root.val);
        if (queue.size() <= targetNumberOfNodes) {
            return;
        }
        if (Math.abs(queue.getFirst() - targetValue) > Math.abs(queue.getLast() - targetValue)) {
            queue.removeFirst();
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
