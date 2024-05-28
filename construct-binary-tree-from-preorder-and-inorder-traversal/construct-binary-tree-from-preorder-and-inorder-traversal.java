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
    int[] preOrder;
    int[] inOrder;
    Map<Integer, Integer> map = new HashMap<>();
    int index = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        preOrder = preorder;
        inOrder = inorder;
        for (int i = 0; i < inorder.length; i++) {
            map.put(inOrder[i],i);
        }
        return dfs(0,preorder.length-1);
    }
    private TreeNode dfs(int start, int end) {
        if (start > end) return null;
        
        int currentVal = preOrder[index++];
        TreeNode node = new TreeNode(currentVal);
        
        int mid = map.get(currentVal);
        
        node.left = dfs(start,mid-1);
        node.right = dfs(mid+1, end);
        return node;
    }
}