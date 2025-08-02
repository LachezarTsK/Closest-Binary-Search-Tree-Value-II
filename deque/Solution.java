
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<Integer> closestKValues(TreeNode root, double targetValue, int targetNumberOfNodes) {
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        inOrderSearch(root, targetValue, targetNumberOfNodes, deque);
        return new ArrayList<>(deque);
    }

    private void inOrderSearch(TreeNode root, double targetValue, int targetNumberOfNodes, ArrayDeque<Integer> deque) {
        if (root == null) {
            return;
        }
        inOrderSearch(root.left, targetValue, targetNumberOfNodes, deque);
        updateDeque(root, targetValue, targetNumberOfNodes, deque);
        inOrderSearch(root.right, targetValue, targetNumberOfNodes, deque);
    }

    private void updateDeque(TreeNode root, double targetValue, int targetNumberOfNodes, ArrayDeque<Integer> deque) {
        deque.add(root.val);
        if (deque.size() <= targetNumberOfNodes) {
            return;
        }
        if (Math.abs(deque.getFirst() - targetValue) > Math.abs(deque.getLast() - targetValue)) {
            deque.removeFirst();
            return;
        }
        deque.removeLast();
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
