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
        if (root == null) return count;
        preorder(root, Integer.MIN_VALUE);
        return count;
    }
    private void preorder(TreeNode node, int min) {
        if (node == null) return;

        if (node.val >= min) count++;
        preorder(node.left, Math.max(min, node.val));
        preorder(node.right, Math.max(min, node.val));
    }
}