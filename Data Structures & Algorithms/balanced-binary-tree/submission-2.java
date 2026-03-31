/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

// class Solution {
//     public boolean isBalanced(TreeNode root) {
//         if (root == null) return true;
//         Map<TreeNode,Integer> outMap = new HashMap<>();
        
//         Stack<TreeNode> stack = new Stack<>();
//         stack.push(root);
//         TreeNode curr = root;
//         TreeNode lastVisited = null;
//         while(!stack.isEmpty() || curr != null){
//             if(curr != null){
//                 stack.push(curr);
//                 curr = curr.left;
//             }else{
//                 TreeNode peek = stack.peek();
//                 if(peek.right != null && lastVisited != peek.right){
//                     curr = peek.right;
//                 }else{
//                     stack.pop();
//                     int lh = outMap.getOrDefault(peek.left,0);
//                     int rh = outMap.getOrDefault(peek.right,0);
//                     if(Math.abs(lh-rh)>1){
//                         return false;
//                     }
//                     outMap.put(peek,1+Math.max(lh,rh));
//                     lastVisited = peek;
//                 }
//             }
//         }
//         return true;
//     }
// }
class Solution {
    public boolean isBalanced(TreeNode root) {
        return check(root) != -1;
    }

    private int check(TreeNode node) {
        if (node == null) return 0;

        int left = check(node.left);
        if (left == -1) return -1;

        int right = check(node.right);
        if (right == -1) return -1;

        if (Math.abs(left - right) > 1) return -1;

        return Math.max(left, right) + 1;
    }
}

