class Solution {
    public int countComponents(int n, int[][] edges) {
        List<List<Integer>> list = new ArrayList<>();
        boolean[] visit = new boolean[n];
        for(int i = 0; i < n; i++){
            list.add(new ArrayList<>());
        }
        for(int[] edge : edges){
            list.get(edge[0]).add(edge[1]);
            list.get(edge[1]).add(edge[0]);
        }
        int res = 0;
        for(int node = 0; node < n; node++){
            if(!visit[node]){
                dfs(list,visit,node);
                res++;
            }
        }
        return res;
    }
    public void dfs(List<List<Integer>> list,boolean[] visit,int node){
        visit[node] = true;
        for(int nei : list.get(node)){
            if(!visit[nei]){
                dfs(list,visit,nei);
            }
        }
    }
}
