class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> res = new PriorityQueue<>((a,b) -> Integer.compare(dist(b),dist(a)));
        for(int[] p : points){
            res.offer(p);
            if(res.size() > k){
                res.poll();
            }
        }
        int[][] result = new int[k][2];
        int i = 0;
        while(!res.isEmpty()){
            result[i++] = res.poll();
        }
        return result;
    }
    private int dist(int[] p){
        return p[0]*p[0] + p[1]*p[1];
    }
}
