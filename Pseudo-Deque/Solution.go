
package main
import "math"

var front int
var pseudoDeque []int

func closestKValues(root *TreeNode, targetValue float64, targetNumberOfNodes int) []int {
    front = 0
    pseudoDeque = []int{}
    inOrderSearch(root, targetValue, targetNumberOfNodes)
    return pseudoDeque[front:]
}

func inOrderSearch(root *TreeNode, targetValue float64, targetNumberOfNodes int) {
    if root == nil {
        return
    }
    inOrderSearch(root.Left, targetValue, targetNumberOfNodes)
    updatePseudoDeque(root, targetValue, targetNumberOfNodes)
    inOrderSearch(root.Right, targetValue, targetNumberOfNodes)
}

func updatePseudoDeque(root *TreeNode, targetValue float64, targetNumberOfNodes int) {
    pseudoDeque = append(pseudoDeque, root.Val)
    if len(pseudoDeque) <= targetNumberOfNodes {
        return
    }
    if math.Abs(float64(pseudoDeque[front]) - targetValue) > math.Abs(float64(pseudoDeque[len(pseudoDeque) - 1]) - targetValue) {
        front++
        return
    }
    pseudoDeque = pseudoDeque[0 : len(pseudoDeque) - 1]
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
