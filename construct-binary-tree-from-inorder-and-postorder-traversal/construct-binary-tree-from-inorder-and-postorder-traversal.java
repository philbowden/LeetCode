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
 
 root.left inO = [1,2,3,4] postO = [1,4,3,2] \ root.right inO = [6,7,8,9,10] postO = [6,8,10,9,7]
  
 
 
 */
class Solution {
    int[] inorder;
    int[] postorder;
    Map<Integer, Integer> map = new HashMap<>();
    int index;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.inorder = inorder;
        this.postorder = postorder;
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i],i);
        }
        int n = postorder.length;
        index = n-1;
        return dfs(0,n-1);
    }
    private TreeNode dfs(int start, int end) {
        if (start > end) return null;
        
        int currentVal = postorder[index--];
        TreeNode node = new TreeNode(currentVal);
        int mid = map.get(currentVal);
        node.right = dfs(mid+1, end);
        node.left = dfs(start, mid-1);
        return node;
    }
}