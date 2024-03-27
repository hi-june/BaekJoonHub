import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        Arrays.sort(people);
        
        int idx = 0;
        int count = 0;
        for (int i = people.length - 1; i >= idx; i--) {
            int fat = people[i];
            int thin = people[idx];
            
            if (fat + thin <= limit) {
                idx++;
            }
            
            count++;
        }
        
        return count;
    }
}