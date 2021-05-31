class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int targetVal = convertToInt(target);
        if(targetVal >= convertToInt(letters[letters.length - 1]) ||
           targetVal < convertToInt(letters[0])){
            return letters[0];
        }
        int left = 0;
        int right = letters.length - 1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            int midVal = convertToInt(letters[mid]);
            if(convertToInt(letters[mid]) > targetVal && convertToInt(letters[mid - 1]) <= targetVal){
                return letters[mid];
            }
            if(convertToInt(letters[mid]) <= targetVal && convertToInt(letters[mid + 1]) > targetVal){
                return letters[mid + 1];
            }
            if(convertToInt(letters[mid]) > targetVal){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return letters[left];
    }
    public int convertToInt(char c){
        return c - 'a';
    }
}