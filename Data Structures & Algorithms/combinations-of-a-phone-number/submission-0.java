class Solution {
    List<String> res = new ArrayList<>();
    String[] digitToChar = {"","","abc","def","ghi","jkl","mno","qprs","tuv","wxyz"};
    public List<String> letterCombinations(String digits) {
        if(digits.isEmpty()){
            return res;
        }
        backtrack(0,"",digits);
        return res;
    }
    public void backtrack(int idx,String curr,String digits){
        if(curr.length() == digits.length()){
            res.add(curr);
            return;
        }
        String chars = digitToChar[digits.charAt(idx)-'0'];
        for(char c : chars.toCharArray()){
            backtrack(idx+1,curr + c, digits);
        }
    }
}
