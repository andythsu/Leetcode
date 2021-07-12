class Solution {
    public String minRemoveToMakeValid(String s) {
        Stack<Integer> stack = new Stack();
        Set<Integer> invalid = new HashSet();
        
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(c == '(') stack.push(i);
            if(c == ')'){
                if(stack.isEmpty()){
                    invalid.add(i);  
                }else{
                    stack.pop();                    
                }
            }
        }
        
        while(!stack.isEmpty()) invalid.add(stack.pop());
        
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(invalid.contains(i)) continue;
            sb.append(c);
        }
        
        return sb.toString();
    }
}