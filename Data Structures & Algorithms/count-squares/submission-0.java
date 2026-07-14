class CountSquares {
    private Map<String,Integer> freq;
    private List<int[]> points;
    public CountSquares() {
        freq = new HashMap<>();
        points = new ArrayList<>();
    }
    
    public void add(int[] point) {
        int x = point[0];
        int y = point[1];
        String key = x + "#" + y;
        freq.put(key,freq.getOrDefault(key,0)+1);
        points.add(point);
    }
    
    public int count(int[] point) {
        int x = point[0];
        int y = point[1];
        int ans = 0;
        for(int[] p : points){
            int x1 = p[0];
            int y1 = p[1];
            if(Math.abs(x-x1) != Math.abs(y-y1)){
                continue;
            }
            if(x == x1 || y == y1){
                continue;
            }
            String corner1 = x + "#" + y1;
            String corner2 = x1 + "#" + y;
            ans += freq.getOrDefault(corner1,0) * freq.getOrDefault(corner2,0);
        }
        return ans;
    }
}
