class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        int i = 0;
        while(i < heights.length){
            if(stack.isEmpty() || heights[i] > heights[stack.peek()]){
                stack.push(i);
                i++;
            }else{
                int curMax = stack.pop();
                int height = heights[curMax];
                int width = i - (stack.isEmpty() ? 0 : (1 + stack.peek()));
                maxArea = Math.max(maxArea, height * width);
            }
        }
        while(!stack.isEmpty()){
            int curMax = stack.pop();
            int height = heights[curMax];
            int width = i - (stack.isEmpty() ? 0 : (1 + stack.peek()));
            maxArea = Math.max(maxArea, height * width);
        }
        return maxArea;
    }
}
