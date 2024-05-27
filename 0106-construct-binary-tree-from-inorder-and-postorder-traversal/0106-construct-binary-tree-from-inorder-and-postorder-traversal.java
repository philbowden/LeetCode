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
    int[] inOrder;
    int[] postOrder;
    Map<Integer, Integer> map = new HashMap<>();
    int index;
    
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        inOrder = inorder;
        postOrder = postorder;
        int n = postorder.length;
        index = n-1;
        
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return dfs(0, n-1);
    }
    
    private TreeNode dfs(int start, int end) {
        if (start > end) return null;
        
        int currentVal = postOrder[index--];
        TreeNode node = new TreeNode(currentVal);
        
        int mid = map.get(currentVal);
    
        node.right = dfs(mid+1, end);
        node.left = dfs(start, mid-1);
        return node;
    }
}