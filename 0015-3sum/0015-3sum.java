class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        Set<List<Integer>> set = new HashSet<>();
        Arrays.sort(nums);
        for(int i = 0; i < nums.length-2; i++) {
            int left = i+1, right = nums.length-1;
            while(left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                   List<Integer> next = Arrays.asList(nums[i],nums[left],nums[right]);
                    if (!set.contains(next)) {
                        res.add(next);
                        set.add(next);
                    }
                    left++;
                    right--;
                } else if (sum < 0) left++;
                else right--;
            }
        }
        return res;
    }
}