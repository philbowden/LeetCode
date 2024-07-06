/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    private TreeNode result;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root, p, q);
        return result;
    }
    private boolean dfs(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return false;

        boolean left = dfs(root.left, p, q);
        boolean right = dfs(root.right, p, q);

        boolean current = (root == p || root == q);
        if ((left && right) || (left && current) || (right && current)) result = root;
        return left || right || current;
    }
}