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
    boolean isSameTree = true;
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null || q == null) return p == null && q == null;
        preorder(p,q);
        return isSameTree;
    }
    public void preorder(TreeNode p, TreeNode q) {
        if (p == null || q == null) {
            if (p == null && q != null || p != null && q == null) {
                isSameTree = false;
            }
            return;
        }
        if (p.val != q.val) {
            isSameTree = false;
            return;
        }
        preorder(p.left, q.left);
        preorder(p.right, q.right);
    }
}