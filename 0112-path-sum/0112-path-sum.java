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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;
        
        Stack<TreeNode> nodeStack = new Stack<>();
        Stack<Integer> sumStack = new Stack<>();
        nodeStack.push(root);
        sumStack.push(targetSum - root.val);
        
        while(!nodeStack.isEmpty()) {
            TreeNode node = nodeStack.pop();
            int currentSum = sumStack.pop();
            
            if (node.left == null && node.right == null && currentSum == 0) {
                return true;
            } 
            if (node.left != null) {
                sumStack.push(currentSum - node.left.val);
                nodeStack.push(node.left);
            }
            if (node.right != null) {
                sumStack.push(currentSum - node.right.val);
                nodeStack.push(node.right);
            }
        }
        return false;
    }
}