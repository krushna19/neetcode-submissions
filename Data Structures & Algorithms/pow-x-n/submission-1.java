class Solution {
    public double myPow(double x, int n) {
        double ans  = 1;
        if(n >= 0){
        for(int i = 0; i < n; i++){
            ans = ans * x;
        }
        }else{
            for(int i = 0; i < Math.abs(n); i++){
                ans = ans * (1/x);
            }
        }

        return ans;
    }
}
