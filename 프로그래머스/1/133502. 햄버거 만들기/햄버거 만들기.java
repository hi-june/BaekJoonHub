import java.util.*;

class Solution {
    public int solution(int[] ingredient) {
        List<Integer> table = new ArrayList<>();
        List<Integer> ham = Arrays.asList(1,2,3,1);
        int count = 0;
        
        for (int i : ingredient) {
            table.add(i);
            
            int size = table.size();
            if (size >= 4 && table.subList(size - 4, size).equals(ham)) {
                // table = table.subList(0, size - 4);
                
                for (int j = 0; j < 4; j++) {
                    table.remove(table.size() - 1);
                }
                count += 1;
            }
        }
        
        return count;
    }
    
    // public boolean check(List<Integer> table, int size) {
    //     if (table.get(size - 4) == 1 && )
    // }
}