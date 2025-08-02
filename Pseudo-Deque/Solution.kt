
import kotlin.math.abs

class Solution {

    private var front = 0
    private val pseudoDeque = mutableListOf<Int>()

    fun closestKValues(root: TreeNode?, targetValue: Double, targetNumberOfNodes: Int): List<Int> {
        inOrderSearch(root, targetValue, targetNumberOfNodes)
        return pseudoDeque.subList(front, pseudoDeque.size)
    }

    private fun inOrderSearch(root: TreeNode?, targetValue: Double, targetNumberOfNodes: Int) {
        if (root == null) {
            return
        }
        inOrderSearch(root.left, targetValue, targetNumberOfNodes)
        updatePseudoDeque(root, targetValue, targetNumberOfNodes)
        inOrderSearch(root.right, targetValue, targetNumberOfNodes)
    }

    private fun updatePseudoDeque(root: TreeNode, targetValue: Double, targetNumberOfNodes: Int) {
        pseudoDeque.add(root.`val`)
        if (pseudoDeque.size <= targetNumberOfNodes) {
            return
        }
        if (abs(pseudoDeque[front] - targetValue) > abs(pseudoDeque.last() - targetValue)) {
            ++front
            return
        }
        pseudoDeque.removeLast()
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
