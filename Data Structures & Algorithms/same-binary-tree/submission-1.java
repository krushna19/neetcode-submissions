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
    public boolean isSameTree(TreeNode p, TreeNode q) {
       
        Stack<TreeNode[]> res = new Stack<>();
        res.push(new TreeNode[]{p,q});
        while(!res.isEmpty()){
            TreeNode[] nodes = res.pop();
            TreeNode curr1 = nodes[0];
            TreeNode curr2 = nodes[1];
            if(curr1 == null && curr2 == null){
                continue;
            }
            if(curr1 == null || curr2 == null || curr1.val != curr2.val){
                return false;
            }
            res.push(new TreeNode[]{curr1.right,curr2.right});
            res.push(new TreeNode[]{curr1.left,curr2.left});
        }
        return true;
    }
}
