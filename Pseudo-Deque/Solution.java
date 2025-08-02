
mport java.util.ArrayList;
import java.util.List;

public class Solution {

    private int front;
    private List<Integer> pseudoDeque = new ArrayList<>();

    public List<Integer> closestKValues(TreeNode root, double targetValue, int targetNumberOfNodes) {
        inOrderSearch(root, targetValue, targetNumberOfNodes);
        return pseudoDeque.subList(front, pseudoDeque.size());
    }

    private void inOrderSearch(TreeNode root, double targetValue, int targetNumberOfNodes) {
        if (root == null) {
            return;
        }
        inOrderSearch(root.left, targetValue, targetNumberOfNodes);
        updatePseudoDeque(root, targetValue, targetNumberOfNodes);
        inOrderSearch(root.right, targetValue, targetNumberOfNodes);
    }

    private void updatePseudoDeque(TreeNode root, double targetValue, int targetNumberOfNodes) {
        pseudoDeque.add(root.val);
        if (pseudoDeque.size() <= targetNumberOfNodes) {
            return;
        }
        if (Math.abs(pseudoDeque.get(front) - targetValue) > Math.abs(pseudoDeque.getLast() - targetValue)) {
            ++front;
            return;
        }
        pseudoDeque.removeLast();
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
