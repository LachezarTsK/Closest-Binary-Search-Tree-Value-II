
function closestKValues(root: TreeNode | null, targetValue: number, targetNumberOfNodes: number): number[] {
    const util = new Util();
    inOrderSearch(root, targetValue, targetNumberOfNodes, util);
    return util.pseudoDeque.slice(util.front, util.pseudoDeque.length);
};

function inOrderSearch(root: TreeNode, targetValue: number, targetNumberOfNodes: number, util: Util): void {
    if (root === null) {
        return;
    }
    inOrderSearch(root.left, targetValue, targetNumberOfNodes, util);
    updatePseudoDeque(root, targetValue, targetNumberOfNodes, util);
    inOrderSearch(root.right, targetValue, targetNumberOfNodes, util);
}

function updatePseudoDeque(root: TreeNode, targetValue: number, targetNumberOfNodes: number, util: Util): void {
    util.pseudoDeque.push(root.val);
    if (util.pseudoDeque.length - util.front <= targetNumberOfNodes) {
        return;
    }
    if (Math.abs(util.pseudoDeque[util.front] - targetValue) > Math.abs(util.pseudoDeque[util.pseudoDeque.length - 1] - targetValue)) {
        ++util.front;
        return;
    }
    util.pseudoDeque.pop();
}

class Util {
    front: number = 0;
    pseudoDeque: number[] = new Array();
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
