class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        int[][] pair = new int[n][2];
        for(int i = 0; i < n; i++){
            pair[i][0] = position[i];
            pair[i][1] = speed[i];
        }
        Arrays.sort(pair,(a,b) -> Integer.compare(b[0],a[0]));
        int fleet = 0;
        double time = -0.1;
        for(int j = 0; j < n; j++){
            double curtime = (double)(target-pair[j][0]) / pair[j][1];
            if(curtime > time){
                fleet++;
                time = curtime;
            }
        }
        return fleet;
    }
}
