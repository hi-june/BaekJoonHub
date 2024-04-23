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
        int extIdx = map.get(ext);
        int sortIdx = map.get(sort_by);
        
        data = Arrays.stream(data)
            .filter(d -> d[extIdx] < val_ext)
            .sorted((d1, d2) -> d1[sortIdx] - d2[sortIdx])
            .toArray(int[][]::new);
        
        return data;
    }
}