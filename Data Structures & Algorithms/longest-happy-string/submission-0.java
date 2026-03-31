class Solution {
    public String longestDiverseString(int a, int b, int c) {
       
       return calculate(a,b,c);
    }
    public String calculate(int x,int y,int z){
        PriorityQueue<Pair> pq = new PriorityQueue<>((m,n) -> Integer.compare(n.frequency,m.frequency));
        if(x > 0) pq.offer(new Pair('a',x));
        if(y > 0) pq.offer(new Pair('b',y));
        if(z > 0) pq.offer(new Pair('c',z));
        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()){
            Pair first = pq.poll();
            int len = sb.length();
            if(len >= 2 && sb.charAt(len - 1) == first.p && sb.charAt(len - 2) == first.p){
               if(pq.isEmpty()){
                 break;
               }
               Pair second = pq.poll();
               sb.append(second.p);
               second.frequency--;
               if(second.frequency > 0){
                 pq.offer(second);
               }
               pq.offer(first);
            }else{
            
            sb.append(first.p);
            
            first.frequency--;
            
            if(first.frequency > 0) pq.offer(first);
            }
        }
        return sb.toString();
    }
    class Pair{
        Character p;
        int frequency;
        Pair(Character x,int frequency){
            this.p = x;
            this.frequency = frequency;
        }
    }
}