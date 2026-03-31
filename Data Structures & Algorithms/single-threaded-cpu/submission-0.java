class Solution {
    public int[] getOrder(int[][] tasks) {
       int n = tasks.length;
       Task[] t = new Task[n]; 
       for(int i = 0; i < n; i++){
          t[i] = new Task(i,tasks[i][0],tasks[i][1]);
       }
       Arrays.sort(t,(a,b) -> a.startTime == b.startTime ? a.processingTime - b.processingTime : a.startTime - b.startTime);
       PriorityQueue<Task> waitingTask = new PriorityQueue<>((a,b) -> a.processingTime == b.processingTime ? a.index - b.index : a.processingTime - b.processingTime);
       int index = 0 , resIndex = 0;
       int endTime = 0; 
       int[] result = new int[n];
       while(index < n){
          if(waitingTask.size() > 0){
             Task currentTask = waitingTask.remove();
             endTime = Math.max(currentTask.startTime , endTime) + currentTask.processingTime;
             result[resIndex++] = currentTask.index++;
             while(index < n && endTime >= t[index].startTime){
                waitingTask.add(t[index++]);
             }
          }else{
                waitingTask.add(t[index++]);
          }
       }
       while(waitingTask.size() > 0){
          Task task = waitingTask.remove();
          result[resIndex++] = task.index;
       }
       return result;
    }
    class Task{
        int index;
        int startTime;
        int processingTime;
        Task(int index ,int startTime ,int processingTime){
            this.index = index;
            this.startTime = startTime;
            this.processingTime = processingTime;
        }
    }
}