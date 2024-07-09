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
    class TreeInfo {
        int depth;
        boolean isBalanced;
        public TreeInfo(int depth, boolean isBalanced) {
            this.depth = depth;
            this.isBalanced = isBalanced;
        }
        public TreeInfo() {};
    }
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        return dfs(root).isBalanced;
    }
    private TreeInfo dfs(TreeNode node) {
        if (node == null) return new TreeInfo(0, true);

        TreeInfo left = dfs(node.left);
        TreeInfo right = dfs(node.right);

        int diff = Math.abs(left.depth - right.depth);
        int currentDepth = Math.max(left.depth, right.depth) + 1;
        TreeInfo res = new TreeInfo(currentDepth, true);
        if (diff > 1 || !left.isBalanced || !right.isBalanced) {
            res.isBalanced = false;
        }
        return res;
    }
}