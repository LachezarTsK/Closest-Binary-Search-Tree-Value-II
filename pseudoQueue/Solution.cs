
using System;
using System.Collections.Generic;

public class Solution
{
    private int front;
    private List<int> queue = new List<int>();
    public IList<int> ClosestKValues(TreeNode root, double targetValue, int targetNumberOfNodes)
    {
        InOrderSearch(root, targetValue, targetNumberOfNodes);
        return queue.Slice(front, queue.Count - front);
    }

    private void InOrderSearch(TreeNode root, double targetValue, int targetNumberOfNodes)
    {
        if (root == null)
        {
            return;
        }
        InOrderSearch(root.left, targetValue, targetNumberOfNodes);
        UpdateQueue(root, targetValue, targetNumberOfNodes);
        InOrderSearch(root.right, targetValue, targetNumberOfNodes);
    }

    private void UpdateQueue(TreeNode root, double targetValue, int targetNumberOfNodes)
    {
        queue.Add(root.val);
        if (queue.Count <= targetNumberOfNodes)
        {
            return;
        }
        if (Math.Abs(queue[front] - targetValue) > Math.Abs(queue.Last() - targetValue))
        {
            ++front;
            return;
        }
        queue.RemoveAt(queue.Count - 1);
    }
}

/*
Class TreeNode is inbuilt in the solution file on leetcode.com. 
When running the code on the website, do not include this class.
 */
public class TreeNode
{
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode(int val = 0, TreeNode left = null, TreeNode right = null)
    {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
