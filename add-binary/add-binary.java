class Solution {
    public String addBinary(String a, String b) {
        // make a and b same length
        int aLength = a.length();
        int bLength = b.length();
        if(a.length() > b.length()){
            for(int i=0; i<aLength - bLength; i++){
                b = "0" + b;
            }
        }else{
            for(int i=0; i < bLength - aLength; i++){
                a = "0" + a;
            }
        }
        String result = "";
        int carry = 0;
        for(int i=a.length()-1; i>=0; i--){
            int aNum = Character.getNumericValue(a.charAt(i));
            int bNum = Character.getNumericValue(b.charAt(i));
            int sum = aNum + bNum + carry;
            carry = 0;
            if(sum == 0){
                result = "0" + result;
            }else if(sum == 1){
                result = "1" + result;
            }else if (sum == 2){
                result = "0" + result;
                carry = 1;
            }else{
                result = "1" + result;
                carry = 1;
            }
        }
        if(carry == 1) result = "1" + result;
        
        return result;
    }
}
