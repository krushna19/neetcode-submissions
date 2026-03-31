class Solution {
    class Task{
        int freq;
        int exe_time;
        Task(int f, int e){
           freq = f;
           exe_time = e;
        }
    }
    public int leastInterval(char[] tasks, int n) {
        HashMap<Character,Integer> freqMap = new HashMap<>();
        for(char ch: tasks){
            freqMap.put(ch,freqMap.getOrDefault(ch,0)+1);
        }
        PriorityQueue<Task> pq = new PriorityQueue<>((a, b) -> b.freq - a.freq);
        for(Character ch : freqMap.keySet()){
            int frequency = freqMap.get(ch);
            pq.offer(new Task(frequency,0));
        }
        Queue<Task> queue = new LinkedList<>();
        int time = 0;
        while(!queue.isEmpty() || !pq.isEmpty()){
            time++;
            if(!pq.isEmpty()){
                Task task = pq.poll();
                task.freq--;
                if(task.freq > 0){
                    task.exe_time = time + n;
                    queue.offer(task);
                }
            }
            if(!queue.isEmpty() && queue.peek().exe_time == time){
                pq.offer(queue.poll());
            }
        }
        return time;
    }
}
