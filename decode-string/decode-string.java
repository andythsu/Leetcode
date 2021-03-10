class Solution {
    public String decodeString(String s) {
        String currentRes = "";
        Stack<Integer> counts = new Stack<>();
        Stack<String> strings = new Stack<>();
        int i = 0;
        while(i < s.length()){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                int count = 0;
                while(Character.isDigit(s.charAt(i))){
                    count = count * 10 + Character.getNumericValue(s.charAt(i));
                    i++;
                }
                counts.push(count);
            }else if (c == '['){
                strings.push(currentRes);
                currentRes = "";
                i++;
            }else if (c == ']'){
                StringBuilder sb = new StringBuilder(strings.pop());
                int count = counts.pop();
                for(int j=0; j<count; j++){
                    sb.append(currentRes);
                }
                currentRes = sb.toString();
                i++;
            }else{
                currentRes += c;
                i++;
            }
        }
        return currentRes;
    }
}