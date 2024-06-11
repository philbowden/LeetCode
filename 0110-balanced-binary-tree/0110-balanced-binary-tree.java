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
    boolean isTreeBalanced = true;
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        dfs(root);
        return isTreeBalanced;
    }
    private int dfs(TreeNode node) {
        if (node == null) return 0;

        int left = dfs(node.left);
        int right = dfs(node.right);
        if (Math.abs(left - right) > 1) isTreeBalanced = false;
        return Math.max(left, right) + 1;
    }
}