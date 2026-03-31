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
    public int goodNodes(TreeNode root) {
        if(root == null){
            return 0;
        }
        int count = 0;
        Stack<Pair> s = new Stack<>();
        s.push(new Pair(root,root.val));
        while(!s.isEmpty()){
            Pair p = s.pop();
            TreeNode curr = p.node;
            int maxSoFar = p.max;
            if(curr.val >= maxSoFar){
                count++;
            }
            int newMax = Math.max(curr.val,maxSoFar);

            if(curr.left != null){
                s.push(new Pair(curr.left,newMax));
            }
            if(curr.right != null){
                s.push(new Pair(curr.right,newMax));
            }
        }
        return count;
    }
    private class Pair{
        TreeNode node;
        int max;
        Pair(TreeNode n,int m){
            this.node = n;
            this.max = m;
        }
    }
}
