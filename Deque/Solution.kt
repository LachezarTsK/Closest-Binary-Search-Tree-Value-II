
import kotlin.math.abs
import kotlin.collections.ArrayDeque

class Solution {

    fun closestKValues(root: TreeNode?, targetValue: Double, targetNumberOfNodes: Int): List<Int> {
        val deque = ArrayDeque<Int>()
        inOrderSearch(root, targetValue, targetNumberOfNodes, deque)
        return ArrayList<Int>(deque)
    }

    private fun inOrderSearch(root: TreeNode?, targetValue: Double, targetNumberOfNodes: Int, deque: ArrayDeque<Int>) {
        if (root == null) {
            return
        }
        inOrderSearch(root.left, targetValue, targetNumberOfNodes, deque)
        updateDeque(root, targetValue, targetNumberOfNodes, deque)
        inOrderSearch(root.right, targetValue, targetNumberOfNodes, deque)
    }

    private fun updateDeque(root: TreeNode, targetValue: Double, targetNumberOfNodes: Int, deque: ArrayDeque<Int>) {
        deque.add(root.`val`)
        if (deque.size <= targetNumberOfNodes) {
            return
        }
        if (abs(deque.first() - targetValue) > abs(deque.last() - targetValue)) {
            deque.removeFirst()
            return
        }
        deque.removeLast()
    }
}

/*
Class TreeNode is inbuilt in the solution file on leetcode.com.
When running the code on the website, do not include this class.
 */
class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}
