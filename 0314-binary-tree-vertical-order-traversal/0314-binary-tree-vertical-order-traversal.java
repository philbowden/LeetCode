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
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;

        int minLeft = 0;
        int maxRight = 0;

        Map<Integer, List<Integer>> map = new HashMap<>();
        Queue<TreeNode> q = new LinkedList<>();
        Queue<Integer> posQ = new LinkedList<>();
        q.add(root);
        posQ.add(0);

        while(!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = q.poll();
                int currentPos = posQ.poll();
                
                if (!map.containsKey(currentPos)) map.put(currentPos, new ArrayList<>());
                map.get(currentPos).add(cur.val);
                
                if (cur.left != null) {
                    q.add(cur.left);
                    posQ.add(currentPos-1);
                    minLeft = Math.min(minLeft, currentPos-1);
                }
                if (cur.right != null) {
                    q.add(cur.right);
                    posQ.add(currentPos+1);
                    maxRight = Math.max(maxRight, currentPos+1);
                }
            }
        }
        for (int i = minLeft; i <= maxRight; i++) {
            if (map.containsKey(i)) {
                res.add(map.get(i));
            }
        }
        return res;
    }
}