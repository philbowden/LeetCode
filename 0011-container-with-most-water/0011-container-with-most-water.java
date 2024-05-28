class Solution {
    public int maxArea(int[] height) {
        int max = Integer.MIN_VALUE;
        int i = 0, j = height.length-1;
        while(i < j) {
            int area = getArea(i,j,Math.min(height[i],height[j]));
            max = Math.max(max, area);
            if (height[i] > height[j]) j--;
            else i++;
        }
        return max;
    }
    private int getArea(int i, int j, int height) {
        int length = j-i;
        return length*height;
    }
}