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
    PriorityQueue<Integer> q;
    public int kthSmallest(TreeNode root, int k) {
        this.q = new PriorityQueue<>(Collections.reverseOrder());
        dfs(root, k);
        return q.peek();
    }
    private void dfs(TreeNode node, int k) {
        if (node == null) return;

        q.add(node.val);
        if (q.size() > k) q.poll();
        dfs(node.left, k);
        dfs(node.right, k);
    }
}