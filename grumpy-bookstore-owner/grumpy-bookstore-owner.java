class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        // find out how many "unhappy" customers we can recover
        int totalHappy = 0;
        int totalUnhappy = 0;
        int diff = 0;
        for(int i=0; i<customers.length; i++){
            if(grumpy[i] == 0){
                totalHappy += customers[i];
            }else{
                diff += customers[i];                
            }
            
            if(i >= minutes){
                if(grumpy[i - minutes] == 1){
                    diff -= customers[i - minutes];
                }
            }
            
            if(diff > totalUnhappy){
                totalUnhappy = diff;
            }
        }
        
        return totalHappy + totalUnhappy;
    }
}