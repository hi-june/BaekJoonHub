import java.util.*;
import java.util.stream.*;

class Solution {
    private static final Map<String, Integer> map = Map.of(
        "code", 0,
        "date", 1,
        "maximum", 2,
        "remain", 3
    );
    
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {        
        List<List<Integer>> remainData = new ArrayList<>();
        
        for (int[] d : data) {
            if (isAvail(d, ext, val_ext)) {
                remainData.add(
                    Arrays.stream(d)
                    .boxed()
                    .collect(Collectors.toList())
                );
            }
        }
        
        Collections.sort(remainData, (r1, r2) -> {
            int idx = map.get(sort_by);
            
            return r1.get(idx) - r2.get(idx);
        });
        
        int[][] answer = new int[remainData.size()][];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = remainData.get(i).stream()
                .mapToInt(Integer::intValue)
                .toArray();
        }
        
        return answer;
    }
    
    private static boolean isAvail(int[] d, String ext, int val_ext) {
        int idx = map.get(ext);
        int value = d[idx];
        
        return value < val_ext;
    }
}