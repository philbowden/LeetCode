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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null) return false;
        if (root.val == subRoot.val && preorder(root, subRoot)) return true;
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }
    private boolean preorder(TreeNode node, TreeNode subRoot) {
        if (node == null || subRoot == null) {
            return node == null && subRoot == null;
        }
        if (node.val != subRoot.val) return false;
        return preorder(node.left, subRoot.left) && preorder(node.right, subRoot.right);
    }
}