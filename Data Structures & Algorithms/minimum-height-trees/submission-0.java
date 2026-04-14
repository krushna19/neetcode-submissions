class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> res = new ArrayList<>();
        if(n == 1){
            res.add(0);
            return res;
        }
        int[] arr = new int[n];
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edg : edges){
            int u = edg[0];
            int v = edg[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
            arr[u]++;
            arr[v]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < n; i++){
            if(arr[i] == 1){
                q.offer(i);
            }
        }
        
        while(n > 2){
            int size = q.size();
            n = n - size;
            while(size > 0){
                int el = q.poll();
                for(int nei : adj.get(el)){
                    arr[nei]--;
                    if(arr[nei] == 1){
                        q.offer(nei);
                    }
                }
                size--;
            }
        }
        while(!q.isEmpty()){
            int el = q.poll();
            res.add(el);
        }
        return res;
    }
}