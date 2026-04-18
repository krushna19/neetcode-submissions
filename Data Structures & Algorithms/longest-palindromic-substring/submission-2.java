class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        int maxi = 0;
        int maxj = 0;
        for(int i = n-1; i >= 0; i--){
            for(int j = 0; j <= i; j++){
                int currL = i - j + 1;
                int maxL = maxi - maxj + 1;
                if(isPalindrome(s.substring(j,i+1)) && currL > maxL){
                    maxi = i;
                    maxj = j;
                }
            }
        }
        return s.substring(maxj,maxi+1);
    }
    public boolean isPalindrome(String s){
        int i = 0;
        int j = s.length()-1;
        while(i <= j){
            if(s.charAt(i) != s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
