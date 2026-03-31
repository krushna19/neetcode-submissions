class MyCircularQueue {
    int[] data;
    int capacity;
    int head;
    int tail;
    int count;
    public MyCircularQueue(int k) {
        this.data = new int[k];
        this.capacity = k;
        this.head = 0;
        this.tail = 0;
        this.count = 0;
    }
    
    public boolean enQueue(int value) {
        if(isFull()){
            return false;
        }
        data[tail] = value;
        tail = (tail + 1) % capacity;
        count++;
        return true;
    }
    
    public boolean deQueue() {
        if(isEmpty()){
            return false;
            
        }
        head = (head + 1) % capacity;
        count--;
        return true;
    }
    
    public int Front() {
        if(isEmpty()){
            return -1;
        }
        return data[head];
    }
    
    public int Rear() {
        if(isEmpty()){
            return -1;
        }
        int lastIndex = (tail - 1 + capacity) % capacity;
        return data[lastIndex];
    }
    
    public boolean isEmpty() {
        return count == 0;
    }
    
    public boolean isFull() {
        return capacity == count;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */