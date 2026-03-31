class Solution {
    public String simplifyPath(String path) {
        Stack<String> s = new Stack<>();
        String[] arr = path.split("/");
        for(String cur : arr){
            if(cur.equals("..")){
               if(!s.isEmpty()){
                 s.pop();
               }
            }else if(!cur.equals("")&& !cur.equals(".")){
                s.push(cur);
            }
        }
        return "/"+String.join("/",s);
    }
}