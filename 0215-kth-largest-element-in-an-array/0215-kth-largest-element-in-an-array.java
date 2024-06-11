class Solution {
    public int findKthLargest(int[] nums, int k) {
        int n = nums.length, left = 0, right = n-1;
        int kIndex = n - k;
        Random random = new Random();

        while(left < right) {
            int randomIdx = random.nextInt(right - left + 1) + left;
            int pivot = partition(nums, left, right, randomIdx);
            if (pivot == kIndex) break;
            else if (pivot > kIndex) right = pivot-1;
            else left = pivot+1;
        }
        return nums[kIndex];
    }

    private int partition(int[] nums, int start, int pivot, int randomIdx) {
        swap(nums, pivot, randomIdx);
        int i = start, j = start;
        while(j < pivot) {
            if (nums[j] < nums[pivot]) {
                swap(nums, i++, j);
            } 
            ++j;
        }
        swap(nums,i,pivot);
        return i;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}