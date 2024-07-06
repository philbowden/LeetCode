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
    public boolean isValidBST(TreeNode root) {
        return dfs(null, root, null);
    }
    private boolean dfs(Integer min, TreeNode root, Integer max) {
        if (root == null) return true;

        if (min != null && root.val <= min || max != null && root.val >= max) return false;
        return dfs(min, root.left, root.val) && dfs(root.val, root.right, max);
    }
}