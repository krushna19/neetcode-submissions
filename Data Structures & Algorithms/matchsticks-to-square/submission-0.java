class Solution {
    public boolean makesquare(int[] matchsticks){
       if(matchsticks.length < 4){
           return false;
       }
       int perimeter = 0;
       for(int el : matchsticks){
          perimeter += el;
       }
       if(perimeter % 4 != 0){
         return false;
       }
       int side = perimeter / 4;
       int[] sides = new int[]{side,side,side,side};
       return makeSquare(matchsticks,0,sides);
    }
    public boolean makeSquare(int[] matchsticks,int i , int[] sides){
        if(i == matchsticks.length){
            return sides[0] == 0 && sides[1] == 0 & sides[2] == 0 & sides[3] == 0;
        }
        for(int j = 0; j < 4; j++){
            if(matchsticks[i] > sides[j]){
                continue;
            }
            sides[j] -= matchsticks[i];
            if(makeSquare(matchsticks,i+1,sides)){
               return true;
            }
            sides[j] += matchsticks[i];
         }
         return false;
    }
}