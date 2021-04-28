class Solution {
    public String multiply(String num1, String num2) {
        if(num1 == null || num2 == null || num1 == "" || num2 == "") return "";
        if(num1.equals("0") || num2.equals("0")) return "0";
        int[] ret = new int[num1.length() + num2.length()];
        for(int i=num1.length()-1; i>=0; i--){
            for(int j=num2.length()-1; j>=0; j--){
                ret[i + j + 1] += Character.getNumericValue(num1.charAt(i)) * Character.getNumericValue(num2.charAt(j));
            }
        }
        for(int i=ret.length-1; i>0; i--){
            ret[i-1] += ret[i] / 10;
            ret[i] = ret[i] % 10;
        }
        String result = "";
        for(int i=0; i<ret.length; i++){
            if(result.length() == 0 && ret[i] == 0) continue;
            result += ret[i] + "";
        }
        return result;
    }
}