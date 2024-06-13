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
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        Map<Integer, List<Integer>> map = new HashMap<>();
        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        queue.add((new Pair<>(root, 0)));

        int minIndex = 0, maxIndex = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Pair<TreeNode, Integer> pair = queue.poll();
                
                int index = pair.getValue();
                minIndex = Math.min(minIndex, index);
                maxIndex = Math.max(maxIndex, index);
                
                if (!map.containsKey(index)) map.put(index, new ArrayList<>());
                map.get(index).add(pair.getKey().val);
                
                TreeNode node = pair.getKey();
                if (node.left != null) queue.add(new Pair<>(node.left, index-1));
                if (node.right != null) queue.add(new Pair<>(node.right, index+1));
            }
        }
        for (int i = minIndex; i <= maxIndex; i++) {
            if (map.containsKey(i)) result.add(map.get(i));
        }
        return result;
    }
}