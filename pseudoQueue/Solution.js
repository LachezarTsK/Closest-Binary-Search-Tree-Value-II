
/**
 * @param {TreeNode} root
 * @param {number} targetValue
 * @param {number} targetNumberOfNodes
 * @return {number[]}
 */
var closestKValues = function (root, targetValue, targetNumberOfNodes) {
    const util = new Util();
    inOrderSearch(root, targetValue, targetNumberOfNodes, util);
    return util.queue.slice(util.front, util.queue.length);
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
    updateQueue(root, targetValue, targetNumberOfNodes, util);
    inOrderSearch(root.right, targetValue, targetNumberOfNodes, util);
}

/**
 * @param {TreeNode} root
 * @param {number} targetValue
 * @param {number} targetNumberOfNodes
 * @param {Util} util 
 * @return {void}
 */
function updateQueue(root, targetValue, targetNumberOfNodes, util) {
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
    front = 0;
    queue = new Array();
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
