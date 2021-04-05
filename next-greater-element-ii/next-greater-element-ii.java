class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int[] newNums = new int[nums.length*2];
        for(int i=0; i<newNums.length; i++){
            newNums[i] = nums[i%nums.length];
        }
        Map<String, Integer> map = new HashMap<>();
        Stack<String> stack = new Stack<>();
        for(int i=0; i<newNums.length; i++){
            while(!stack.isEmpty() && newNums[i] > Integer.valueOf(stack.peek().split("=")[0])){
                map.put(stack.pop(), newNums[i]);
            }
            stack.push(newNums[i]+"="+i);
        }
        int[] result = new int[nums.length];
        for(int i=0; i<result.length; i++){
            result[i] = map.getOrDefault(nums[i]+"="+i, -1);
        }
        return result;
    }
}