
import kotlin.math.abs

class Solution {

    private var front = 0
    private val queue = mutableListOf<Int>()

    fun closestKValues(root: TreeNode?, targetValue: Double, targetNumberOfNodes: Int): List<Int> {
        inOrderSearch(root, targetValue, targetNumberOfNodes)
        return queue.subList(front, queue.size)
    }

    private fun inOrderSearch(root: TreeNode?, targetValue: Double, targetNumberOfNodes: Int) {
        if (root == null) {
            return
        }
        inOrderSearch(root.left, targetValue, targetNumberOfNodes)
        updateQueue(root, targetValue, targetNumberOfNodes)
        inOrderSearch(root.right, targetValue, targetNumberOfNodes)
    }

    private fun updateQueue(root: TreeNode, targetValue: Double, targetNumberOfNodes: Int) {
        queue.add(root.`val`)
        if (queue.size <= targetNumberOfNodes) {
            return
        }
        if (abs(queue[front] - targetValue) > abs(queue.last() - targetValue)) {
            ++front
            return
        }
        queue.removeLast()
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
