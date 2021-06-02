var map = new Map();
var rob = function(root) {
    if(!root) return 0;
    if(!root.left && !root.right) return root.val;
    if(map.get(root)) return map.get(root);
    var val1 = root.val;
    //dont rob root
    if(root.left) val1 += rob(root.left.left) + rob(root.left.right);
    if(root.right) val1 += rob(root.right.left) + rob(root.right.right);
    //rob the root
    var val2 = rob(root.left) + rob(root.right);
    map.set(root, Math.max(val1, val2));
    return Math.max(val1, val2);
};
