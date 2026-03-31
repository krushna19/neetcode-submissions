class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int x = 0;
        int y = 0;
        for(int i = 0; i < weights.length; i++){
            if(weights[i] > x){
                x = weights[i];
                
            }
            y += weights[i];
        }
        int res = y;
        while(x <= y){
            int cap = (x+y)/2;
            if(canShip(weights,days,cap)){
                res = Math.min(res,cap);
                y = cap - 1;
            }else{
                x = cap + 1;
            }
            
        }
        return res;
    }
    public boolean canShip(int[] weights, int days, int cap){
        int ships = 1 , currCap = cap;
        for(int w : weights){
            if(currCap - w < 0){
                ships++;
                if(ships > days){
                    return false;
                }
                currCap = cap;
            }
            currCap -= w;
        }
        return true;
    }
}