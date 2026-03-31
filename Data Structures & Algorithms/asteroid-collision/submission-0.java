class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> s = new Stack<>();
       
        for(int a : asteroids){
            while(!s.isEmpty() && a < 0 && s.peek() > 0){
                int diff = a + s.peek();
                if(diff < 0){
                    s.pop();
                }else if(diff > 0){
                    a = 0;
                    
                }else{
                    a = 0;
                    s.pop();
                }
            }
            if(a != 0){
                s.push(a);
            }
               
               

               
        }
        int[] ans = new int[s.size()];
        for(int j = ans.length-1; j >= 0;  j--){
            ans[j] = s.pop();
        }
        return ans;
     }
}