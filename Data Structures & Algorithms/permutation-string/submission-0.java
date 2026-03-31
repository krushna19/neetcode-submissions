class Solution {
    public boolean isFreqSame(int[] freq1,int[] freq2){
        for(int i = 0; i < 26; i++){
            if(freq1[i] != freq2[i]){
                return false;
            }
            
        } 
        return true;
    }
    public boolean checkInclusion(String s1, String s2) {
       int[] freq = new int[26];
       for(int i = 0; i < s1.length(); i++){
          freq[s1.charAt(i) - 'a']++;
       }
       int winsiz = s1.length();
       for(int i = 0; i < s2.length(); i++){
         int winidx = 0; 
         int index = i;
         int[] winfreq = new int[26];
         while(winidx < winsiz && index < s2.length()){
            winfreq[s2.charAt(index) - 'a']++;
            winidx++;
            index++;
         }
         if(isFreqSame(winfreq,freq)){
            return true;
         }
       }
       return false;
    }
    
}
