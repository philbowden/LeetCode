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
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return compare(root.left, root.right, 0);
    }
    private boolean compare(TreeNode left, TreeNode right, int level) {
        if (left == null || right == null) return left == right;
        if (left.val != right.val) return false;
        return compare(left.left, right.right, ++level) && compare(left.right, right.left, ++level);
    }
}
