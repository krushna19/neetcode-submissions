class Solution {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder sb =  new StringBuilder();
        int a = 0;
        int b = 0;
        while (a < word1.length() && b < word2.length()){
            sb.append(word1.charAt(a)).append(word2.charAt(b));
            a++;
            b++;
        }
        if(a < word1.length()){
            sb.append(word1.substring(a,word1.length()));
        }
        if(b < word2.length()){
            sb.append(word2.substring(b,word2.length()));
        }
        return sb.toString();
    }
}