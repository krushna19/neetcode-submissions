class WordDictionary {
    private static Node root;
    public WordDictionary() {
         root = new Node();
    }

    public void addWord(String word) {
         Node node = root;
         for(int i = 0; i < word.length(); i++){
            if(!node.containsKey(word.charAt(i))){
                node.put(word.charAt(i),new Node());
            }
            node = node.get(word.charAt(i));
         }
         node.setEnd();
    }

    public boolean search(String word) {
       return dfs(word,0,root);
    }
    public boolean dfs(String word,int index,Node node){
        if(node == null){
            return false;
        }
        if(index == word.length()){
            return node.isEnd();
        }
        char ch = word.charAt(index);
        if(ch == '.'){
            for(Node child : node.links){
                if(child != null && dfs(word,index+1,child)){
                    return true;
                }
            }
            return false;
        }
        if(!node.containsKey(ch)){
            return false;
        }
        return dfs(word,index + 1,node.get(ch));
    }
}
class Node{
    Node[] links = new Node[26];
    boolean flag = false;
    public Node(){

    }
    boolean containsKey(char ch){
        return links[ch - 'a'] != null;
    }
    Node get(char ch){
        return links[ch - 'a'];
    }
    void put(char ch,Node node){
        links[ch - 'a'] = node;
    }
    void setEnd(){
        flag = true;
    }
    boolean isEnd(){
        return flag;
    }
}
