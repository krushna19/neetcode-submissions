class MinStack {
    Stack<Long> out;
    long min;
    public MinStack() {
        out = new Stack<>();
    }
    
    public void push(int val) {
        if(out.isEmpty()){
            out.push(0L);
            min = val;
        }else{
            out.push(val - min);
            if(val < min) min = val;
        }
    }
    
    public void pop() {
        if(out.isEmpty()) return;
        long pop = out.pop();
        if(pop < 0) min = min - pop;
    }
    
    public int top() {
       long top = out.peek();
       if(top > 0){
          return (int)(top + min);
       }else{
        return (int) min;
       }
    }
    
    public int getMin() {
        
        return (int)min;
    }
}
