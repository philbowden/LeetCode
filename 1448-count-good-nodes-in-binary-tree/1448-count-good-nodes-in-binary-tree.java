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
    int count = 0;
    public int goodNodes(TreeNode root) {
        if (root == null) return 0;
        dfs(root, root.val);
        return count;
    }
    private void dfs(TreeNode node, int min) {
        if (node == null) return;
        if (node.val >= min) count++;
        dfs(node.left, Math.max(node.val, min));
        dfs(node.right, Math.max(node.val, min));
    }
}