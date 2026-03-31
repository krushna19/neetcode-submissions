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
    public int diameterOfBinaryTree(TreeNode root) {
        Map<TreeNode,Integer> res = new HashMap<>();
        Stack<TreeNode> stack = new Stack<>();
        int diameter = 0;
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode node = stack.peek();
            if(node.left != null && !res.containsKey(node.left)){
                stack.push(node.left);
            }else if(node.right != null && !res.containsKey(node.right)){
                stack.push(node.right);
            }else{
                stack.pop();
                int leftSubtree = res.getOrDefault(node.left,0);
                int rightSubtree = res.getOrDefault(node.right,0);
                res.put(node, 1+Math.max(leftSubtree,rightSubtree));
                diameter = Math.max(diameter,leftSubtree+rightSubtree);
            }
        }
        return diameter;
    }
}
