class Solution {
    public void reverseString(char[] s) {
        int start = 0;
        int end = s.length-1;
        while(start < end){
            swap(start,end,s);
            start++;
            end--;
        }
    }
    public void swap(int i,int j, char[] s){
        char ch = s[i];
        s[i] = s[j];
        s[j] = ch;
    }
}