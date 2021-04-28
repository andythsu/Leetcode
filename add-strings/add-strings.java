class Solution {
    public String addStrings(String num1, String num2) {
        int num1Length = num1.length();
        int num2Length = num2.length();
        // make them same length
        if(num1Length < num2Length){
            for(int i=0; i<num2Length - num1Length; i++){
                num1 = "0" + num1;
            }
        }else{
            for(int i=0; i<num1Length - num2Length; i++){
                num2 = "0" + num2;
            }
        }
        String result = "";
        int carry = 0;
        int digit = 0;
        for(int i=num1.length() - 1; i >= 0; i--){
            int c1 = Character.getNumericValue(num1.charAt(i));
            int c2 = Character.getNumericValue(num2.charAt(i));
            int sum = c1 + c2 + carry;
            carry = sum / 10;
            digit = sum % 10;
            result = digit + "" + result;
        }
        if(carry > 0) result = carry + "" + result;
        return result;
    }
}