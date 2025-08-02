
using System;
using System.Collections.Generic;

public class Solution
{
    private int front;
    private List<int> pseudoDeque = new List<int>();

    public IList<int> ClosestKValues(TreeNode root, double targetValue, int targetNumberOfNodes)
    {
        InOrderSearch(root, targetValue, targetNumberOfNodes);
        return pseudoDeque.Slice(front, pseudoDeque.Count - front);
    }

    private void InOrderSearch(TreeNode root, double targetValue, int targetNumberOfNodes)
    {
        if (root == null)
        {
            return;
        }
        InOrderSearch(root.left, targetValue, targetNumberOfNodes);
        UpdatePseudoDeque(root, targetValue, targetNumberOfNodes);
        InOrderSearch(root.right, targetValue, targetNumberOfNodes);
    }

    private void UpdatePseudoDeque(TreeNode root, double targetValue, int targetNumberOfNodes)
    {
        pseudoDeque.Add(root.val);
        if (pseudoDeque.Count <= targetNumberOfNodes)
        {
            return;
        }
        if (Math.Abs(pseudoDeque[front] - targetValue) > Math.Abs(pseudoDeque.Last() - targetValue))
        {
            ++front;
            return;
        }
        pseudoDeque.RemoveAt(pseudoDeque.Count - 1);
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
