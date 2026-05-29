class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
       if(hand.length % groupSize != 0){
          return false;
       }
       Map<Integer,Integer> map = new HashMap<>();
       for(int num : hand){
          map.put(num,map.getOrDefault(num,0)+1);
       }
       for(int num : hand){
           if(!map.containsKey(num)){
             continue;
           }
          int start = num;
          while(map.containsKey(start - 1)){
            start--;
          }
          for(int i = 0; i < groupSize; i++){
             int card = start+i;
             if(!map.containsKey(card)){
                return false;
             }
             map.put(card,map.get(card)-1);
             if(map.get(card) == 0){
                map.remove(card);
             }
          }
       }
       return true;
    }
}
