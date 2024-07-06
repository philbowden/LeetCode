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
    boolean treeIsBalanced = true;
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        postorder(root);
        return treeIsBalanced;
    }
    private int postorder(TreeNode node) {
        if (node == null) return 0;
        int left = postorder(node.left);
        int right = postorder(node.right);
        int diff = Math.abs(left - right);
        if (diff > 1) treeIsBalanced = false;
        return Math.max(left, right) + 1;
    }
}