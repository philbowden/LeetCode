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
   public int countUnivalSubtrees(TreeNode root) {
       if (root == null) return count;
       dfs(root);
       return count;
   }
    private boolean dfs(TreeNode node) {
        if (node == null) return true;
        
        boolean isLeftAUniSub = dfs(node.left);
        boolean isRightAUniSub = dfs(node.right);
        
        if (isLeftAUniSub && isRightAUniSub) {
            if (node.left != null && node.left.val != node.val) return false;
            if (node.right != null && node.right.val != node.val) return false;
            count++;
            return true;
        }
        return false;
    }
}