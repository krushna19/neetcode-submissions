class Solution {
    List<List<String>> res = new ArrayList<>();
    int n;
    public List<List<String>> partition(String s) {
        n = s.length();
        recur(s,0,new ArrayList<>());
        return res;
    }
    public boolean isPalndrome(String s , int start,int end){
        while(start < end){
            if(s.charAt(start) != s.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
    public void recur(String s, int pi, List<String> sublist){
         if(pi == n){
            res.add(new ArrayList<>(sublist));
            return;
         }
         for(int end = pi; end < n; end++){
            if(isPalndrome(s,pi,end)){
                sublist.add(s.substring(pi,end+1));
                recur(s,end+1,sublist);
                sublist.remove(sublist.size()-1);
            }
         }
    }
}