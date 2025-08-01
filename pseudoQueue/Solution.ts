
function closestKValues(root: TreeNode | null, targetValue: number, targetNumberOfNodes: number): number[] {
    const util = new Util();
    inOrderSearch(root, targetValue, targetNumberOfNodes, util);
    return util.queue.slice(util.front, util.queue.length);
};

function inOrderSearch(root: TreeNode, targetValue: number, targetNumberOfNodes: number, util: Util): void {
    if (root === null) {
        return;
    }
    inOrderSearch(root.left, targetValue, targetNumberOfNodes, util);
    updateQueue(root, targetValue, targetNumberOfNodes, util);
    inOrderSearch(root.right, targetValue, targetNumberOfNodes, util);
}

function updateQueue(root: TreeNode, targetValue: number, targetNumberOfNodes: number, util: Util): void {
    util.queue.push(root.val);
    if (util.queue.length - util.front <= targetNumberOfNodes) {
        return;
    }
    if (Math.abs(util.queue[util.front] - targetValue) > Math.abs(util.queue[util.queue.length - 1] - targetValue)) {
        ++util.front;
        return;
    }
    util.queue.pop();
}

class Util {
    front: number = 0;
    queue: number[] = new Array();
}

/*
 Class TreeNode is inbuilt in the solution file on leetcode.com. 
 When running the code on the website, do not include this class.
 */
class TreeNode {
    val: number;
    left: TreeNode | null;
    right: TreeNode | null;
    constructor(val?: number, left?: TreeNode | null, right?: TreeNode | null) {
        this.val = (val === undefined ? 0 : val);
        this.left = (left === undefined ? null : left);
        this.right = (right === undefined ? null : right);
    }
}
