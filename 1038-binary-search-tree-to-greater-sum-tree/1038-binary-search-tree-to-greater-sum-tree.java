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
    int sum;
    public TreeNode bstToGst(TreeNode root) {
        if (root == null) return null;
        this.sum = 0;
        reverseInorder(root);
        return root;
        }
     private void reverseInorder(TreeNode root) {
            if (root == null) return;
            reverseInorder(root.right);
            root.val += sum;
            sum = root.val;
            reverseInorder(root.left);
        }
}