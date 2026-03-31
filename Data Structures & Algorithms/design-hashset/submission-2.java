class MyHashSet {
    int number = 769;
    Bucket[] buckets;
    public MyHashSet() {
        this.buckets = new Bucket[number];
        for(int i = 0; i < number; i++){
           this.buckets[i] = new Bucket();
        }
    }
    public int getIndex(int key){
        return key % number;
    }
    public void add(int key) {
        int index = this.getIndex(key);
        this.buckets[index].insert(key);
    }
    
    public void remove(int key) {
        int index = this.getIndex(key);
        this.buckets[index].remove(key);
    }
    
    public boolean contains(int key) {
        int index = this.getIndex(key);
        return this.buckets[index].contains(key);
    }
}
class Bucket{
    private LinkedList<Integer> container;
    public Bucket(){
        this.container = new LinkedList<>();
    }
    public void insert(Integer val){
        int index = this.container.indexOf(val);
        if(index == -1){
            this.container.addFirst(val);
        }
    }
     public void remove(Integer key){
        this.container.remove(key);
        
    }
     public boolean contains(Integer key){
        int index = this.container.indexOf(key);
        return index != -1;
    }
}
/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */