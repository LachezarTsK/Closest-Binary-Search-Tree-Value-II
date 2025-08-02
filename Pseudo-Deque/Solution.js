
/**
 * @param {TreeNode} root
 * @param {number} targetValue
 * @param {number} targetNumberOfNodes
 * @return {number[]}
 */
var closestKValues = function (root, targetValue, targetNumberOfNodes) {
    const util = new Util();
    inOrderSearch(root, targetValue, targetNumberOfNodes, util);
    return util.pseudoDeque.slice(util.front, util.pseudoDeque.length);
};

/**
 * @param {TreeNode} root
 * @param {number} targetValue
 * @param {number} targetNumberOfNodes
 * @param {Util} util 
 * @return {void}
 */
function inOrderSearch(root, targetValue, targetNumberOfNodes, util) {
    if (root === null) {
        return;
    }
    inOrderSearch(root.left, targetValue, targetNumberOfNodes, util);
    updatePseudoDeque(root, targetValue, targetNumberOfNodes, util);
    inOrderSearch(root.right, targetValue, targetNumberOfNodes, util);
}

/**
 * @param {TreeNode} root
 * @param {number} targetValue
 * @param {number} targetNumberOfNodes
 * @param {Util} util 
 * @return {void}
 */
function updatePseudoDeque(root, targetValue, targetNumberOfNodes, util) {
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
    front = 0;
    pseudoDeque = new Array();
}

/*
 Function TreeNode is inbuilt in the solution file on leetcode.com. 
 When running the code on the website, do not include this function.
 */
function TreeNode(val, left, right) {
    this.val = (val === undefined ? 0 : val);
    this.left = (left === undefined ? null : left);
    this.right = (right === undefined ? null : right);
}
