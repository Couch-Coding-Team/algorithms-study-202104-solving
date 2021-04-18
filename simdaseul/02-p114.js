/**
 * Definition for a binary tree node.
 * function TreeNode(val, left, right) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.left = (left===undefined ? null : left)
 *     this.right = (right===undefined ? null : right)
 * }
 */
/**
 * @param {TreeNode} root
 * @return {void} Do not return anything, modify root in-place instead.
 */
var flatten = function(root) {
    
    if(root === null) return;
    
    function makeNode(node){
        if(node.right === null && leftNodes.length !== 0){
            node.right = new TreeNode(leftNodes.shift());
            makeNode(node.right);
        }
    } 
    function dfs1(node){
        leftNodes.push(node.val);
        if(node.left !== null){
            dfs1(node.left);
            node.left = null;
        } 
        if(node.right !== null){
            dfs1(node.right);
            node.right = null;
        }
    }
    function dfs2(node){
        leftNodes.push(node.val);
        node.val = leftNodes.shift();
        
        if(node.left !== null){
            dfs1(node.left);
            node.left = null
        }
        if(node.right !== null){
            dfs2(node.right);
        }
        
        makeNode(node);

        
    }
    

    let leftNodes = [];
    
    if(root.left !== null){
        dfs1(root.left);
        root.left = null;
    }
    if(root.right !== null){
        dfs2(root.right);
    }

    makeNode(root);

    
    
};
