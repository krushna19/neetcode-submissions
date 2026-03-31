class Solution {
    public int numRescueBoats(int[] people, int limit) {
        int[] freq = new int[limit+1];
        for(int p : people){
            freq[p]++;
        }
        int index = 0;
        for(int p = 1; p <= limit; p++){
            while(freq[p] > 0){
                people[index++] = p;
                freq[p]--;
            }
        }
        int i = 0;
        int j = people.length - 1;
        int c = 0;
        while(i <= j){
            if(people[i] + people[j] <= limit){
                i++;
                j--;
            }else{
                j--;
            }
            c++;
        }
        return c;
    }
}