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

class Solution {
    public int maxDepth(TreeNode root) {
        Stack<Pair<TreeNode,Integer>> s = new Stack<>();
        int res = 0;
        s.push(new Pair<>(root,1));
        while(!s.isEmpty()){
            Pair<TreeNode,Integer> currNode = s.pop();
            TreeNode curr = currNode.getKey();
            int depth = currNode.getValue();
            if(curr != null){
                res = Math.max(res,depth);
                s.push(new Pair<>(curr.left,depth+1));
                s.push(new Pair<>(curr.right,depth+1));
            }
        }
        return res;
    }
}
