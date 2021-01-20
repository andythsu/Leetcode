class Solution {
    public int maxArea(int[] height) {
        int max = Integer.MIN_VALUE;
        int left = 0;
        int right = height.length - 1;
        while(left < right){
            int width = right - left;
            if(height[left] > height[right]){
                max = Math.max(max, height[right] * width);
                right--;
            }else{
                max = Math.max(max, height[left] * width);
                left++;
            }
        }
        return max;
    }
}
