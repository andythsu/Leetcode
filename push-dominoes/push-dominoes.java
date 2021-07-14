class Solution {
    public String pushDominoes(String dominoes) {
        int[] forces = new int[dominoes.length()];
        int force = 0;
        
        for(int i=0; i<forces.length; i++){
            char c = dominoes.charAt(i);
            if(c == '.'){
                force = Math.max(force - 1, 0);
            }else if (c == 'L'){
                force = 0;
            }else{
                // c == 'R'
                force = dominoes.length();
            }
            forces[i] = force;
        }
        
        force = 0;
        
        for(int i=forces.length - 1;  i>=0; i--){
            char c = dominoes.charAt(i);
            if(c == '.'){
                force = Math.max(force - 1, 0);
            }else if (c == 'R'){
                force = 0;
            }else{
                // c == 'L'
                force = dominoes.length();
            }
            forces[i] -= force;
        }
        
        StringBuilder sb = new StringBuilder();
        
        for(int i=0; i<forces.length; i++){
            if(forces[i] < 0){
                sb.append('L');
            }else if (forces[i] > 0){
                sb.append('R');
            }else{
                sb.append('.');
            }
        }
        
        return sb.toString();
        
        
    }
}