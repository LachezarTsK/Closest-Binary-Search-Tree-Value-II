
import kotlin.math.abs
import kotlin.collections.ArrayDeque

class Solution {

    fun closestKValues(root: TreeNode?, targetValue: Double, targetNumberOfNodes: Int): List<Int> {
        val queue = ArrayDeque<Int>()
        inOrderSearch(root, targetValue, targetNumberOfNodes, queue)
        return ArrayList<Int>(queue)
    }

    private fun inOrderSearch(root: TreeNode?, targetValue: Double, targetNumberOfNodes: Int, queue: ArrayDeque<Int>) {
        if (root == null) {
            return
        }
        inOrderSearch(root.left, targetValue, targetNumberOfNodes, queue)
        updateQueue(root, targetValue, targetNumberOfNodes, queue)
        inOrderSearch(root.right, targetValue, targetNumberOfNodes, queue)
    }

    private fun updateQueue(root: TreeNode, targetValue: Double, targetNumberOfNodes: Int, queue: ArrayDeque<Int>) {
        queue.add(root.`val`)
        if (queue.size <= targetNumberOfNodes) {
            return
        }
        if (abs(queue.first() - targetValue) > abs(queue.last() - targetValue)) {
            queue.removeFirst()
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
