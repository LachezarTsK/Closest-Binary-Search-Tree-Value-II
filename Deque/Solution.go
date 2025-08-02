
package main
import (
    "container/list"
    "math"
)

func closestKValues(root *TreeNode, targetValue float64, targetNumberOfNodes int) []int {
    deque := list.New()
    inOrderSearch(root, targetValue, targetNumberOfNodes, deque)
    return convertListToSlice(deque)
}

func inOrderSearch(root *TreeNode, targetValue float64, targetNumberOfNodes int, deque *list.List) {
    if root == nil {
        return
    }
    inOrderSearch(root.Left, targetValue, targetNumberOfNodes, deque)
    updateDeque(root, targetValue, targetNumberOfNodes, deque)
    inOrderSearch(root.Right, targetValue, targetNumberOfNodes, deque)
}

func updateDeque(root *TreeNode, targetValue float64, targetNumberOfNodes int, deque *list.List) {
    deque.PushBack(root.Val)
    if deque.Len() <= targetNumberOfNodes {
        return
    }
    if math.Abs(float64(deque.Front().Value.(int)) - targetValue) > math.Abs(float64(deque.Back().Value.(int)) - targetValue) {
        deque.Remove(deque.Front())
        return
    }
    deque.Remove(deque.Back())
}

func convertListToSlice(deque *list.List) []int {
    index := 0
    result := make([]int, deque.Len())

    for element := deque.Front(); element != nil; element = element.Next() {
        result[index] = element.Value.(int)
        index++
    }
    return result
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
