
package main
import "math"

var front int
var queue []int

func closestKValues(root *TreeNode, targetValue float64, targetNumberOfNodes int) []int {
    front = 0
    queue = []int{}
    inOrderSearch(root, targetValue, targetNumberOfNodes)
    return queue[front:]
}

func inOrderSearch(root *TreeNode, targetValue float64, targetNumberOfNodes int) {
    if root == nil {
        return
    }
    inOrderSearch(root.Left, targetValue, targetNumberOfNodes)
    updateQueue(root, targetValue, targetNumberOfNodes)
    inOrderSearch(root.Right, targetValue, targetNumberOfNodes)
}

func updateQueue(root *TreeNode, targetValue float64, targetNumberOfNodes int) {
    queue = append(queue, root.Val)
    if len(queue) <= targetNumberOfNodes {
        return
    }
    if math.Abs(float64(queue[front]) - targetValue) > math.Abs(float64(queue[len(queue) - 1]) - targetValue) {
        front++
        return
    }
    queue = queue[0 : len(queue) - 1]
}

/*
Struct TreeNode is inbuilt in the solution file on leetcode.com.
When running the code on the website, do not include this struct.
*/
type TreeNode struct {
    Val   int
    Left  *TreeNode
    Right *TreeNode
}
