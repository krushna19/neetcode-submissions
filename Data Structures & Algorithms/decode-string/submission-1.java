class Solution {
    public String decodeString(String s) {
        Stack<Integer> numStack = new Stack<>();
        Stack<String> worStack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int k = 0;
        for(char c : s.toCharArray()){
            if(Character.isDigit(c)){
                k = k * 10 + (c - '0');
            }else if(c == '['){
                worStack.push(sb.toString());
                numStack.push(k);
                sb = new StringBuilder();
                k = 0;
            }else if(c == ']'){
                String temp = sb.toString();
                sb = new StringBuilder(worStack.pop());
                int count = numStack.pop();
                for(int i = 0; i < count; i++){
                    sb.append(temp);
                }
            }else{
                sb.append(c);
            }
        }
        return sb.toString();
    }
}