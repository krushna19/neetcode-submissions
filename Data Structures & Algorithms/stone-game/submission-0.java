class Solution {
    public boolean stoneGame(int[] piles) {
        int alice = 0;
        int  bob = 0;
        int i = 0;
        int j =  piles.length-1;
        while(i < j){
            alice += Math.max(piles[i],piles[j]);
            bob += Math.min(piles[i],piles[j]);
            i++;
            j--;
        }
        if(alice > bob){
            return true;
        }
        return false;
    }
}