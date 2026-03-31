class TimeMap {
    Map<String,ArrayList<timeStampedValue>> entriesByKey;
    public TimeMap() {
        entriesByKey = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if(!entriesByKey.containsKey(key)){
            entriesByKey.put(key,new ArrayList<>());
        }
        ArrayList<timeStampedValue> out = entriesByKey.get(key);
        out.add(new timeStampedValue(timestamp,value));
    }
    
    public String get(String key, int timestamp) {
        if(!entriesByKey.containsKey(key)){
            return "";
        }
        ArrayList<timeStampedValue> out = entriesByKey.get(key);
        Optional<timeStampedValue> timestamps = binarySearchTimestamped(out,timestamp);
        if(timestamps.isEmpty()){
            return "";
        }
        return timestamps.get().value;
    }
    private Optional<timeStampedValue> binarySearchTimestamped(ArrayList<timeStampedValue> arr, int target){
        int left = 0;
        int right = arr.size() - 1;
        int matchIndex = -1;
        while(left <= right){
           int mid = left + (right-left)/2;
           timeStampedValue curr = arr.get(mid);
           if(curr.timestamp <= target){
               matchIndex = mid;
               left = mid + 1;
           }else{
               right = mid - 1;
           }
        }
        if(matchIndex == -1){
            return Optional.empty();
        }
        return Optional.of(arr.get(matchIndex));
    }
}
class timeStampedValue{
    public int timestamp;
    public String value;
     
    public timeStampedValue(int timestamp,String value){
         this.timestamp = timestamp;
         this.value = value;
    }
}