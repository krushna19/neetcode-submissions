class Solution {
    public char turnRight(char c){
      return c == '9' ? '0' : (char)(c+1);
    }
    public char turnLeft(char c){
      return c == '0' ? '9' : (char)(c-1);
    }
    public List<String> nextOptions(String s){
        List<String> options = new ArrayList<>();
        for(int i = 0; i < 4; i++){
            char[] copy = s.toCharArray();
            copy[i] = turnRight(s.charAt(i));
            options.add(new String(copy));
            copy[i] = turnLeft(s.charAt(i));
            options.add(new String(copy));
        }
        return options;
    }
    public int openLock(String[] deadends, String target) {
        Queue<String> q = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        Set<String> deadend = new HashSet<>(Arrays.asList(deadends));
        int level = 0;
        q.offer("0000");
        visited.add("0000");
        while(!q.isEmpty()){
            int size = q.size();
            while(size-- > 0){
                String curr = q.poll();
                if(curr.equals(target)){
                    return level;
                }
                if(deadend.contains(curr)){
                    continue;
                }
                for(String option : nextOptions(curr)){
                    if(!visited.contains(option) && !deadend.contains(option)){
                        q.offer(option);
                        visited.add(option);
                    }
                }
            }
            level++;
        }
        return -1;
    }
}