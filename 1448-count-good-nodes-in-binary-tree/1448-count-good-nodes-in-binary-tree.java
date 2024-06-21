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
    int goodNodeCount = 0;
    public int goodNodes(TreeNode root) {
        if (root == null) return goodNodeCount;
        dfs(root, root.val);
        return goodNodeCount;
    }
    private void dfs(TreeNode root, int max) {
        if (root == null) return;

        if (root.val >= max) goodNodeCount++;
        int currentMax = Math.max(root.val, max);
        dfs(root.left, currentMax);
        dfs(root.right, currentMax);
    }
}